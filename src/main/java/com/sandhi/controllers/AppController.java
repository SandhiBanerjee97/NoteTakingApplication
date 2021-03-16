package com.sandhi.controllers;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.sandhi.dao.NotesDaoImpl;
import com.sandhi.domain.EmailDto;
import com.sandhi.domain.Note;

@SessionAttributes("id")
@Controller
public class AppController 
{
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	NotesDaoImpl notesDaoImpl;
	
	@RequestMapping("/")			
	public String appStartPage()
	{
		return "index";			
	}
	
	@RequestMapping("/home")			
	public String allNotes(Model model)
	{
		List<Note> notes=notesDaoImpl.getAll();
		Collections.reverse(notes);
		model.addAttribute("notes",notes);
		return "home";			
	}
	@RequestMapping("/addNotes")			
	public String add(Model model)
	{
		Note n= new Note();
		model.addAttribute("page","add");
		model.addAttribute("note",n);
		return "add_notes";			
	}
	@RequestMapping(value="/saveNote",method = RequestMethod.POST)
	public String saveNote(@Valid @ModelAttribute("note") Note note,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			return "add_notes";
		}
		else
		{
			if(note.getNoteId()==null)
			{
				note.setNoteDate(new Date());
				notesDaoImpl.save(note);
			}
			else 
			{
				note.setNoteDate(new Date());
				notesDaoImpl.update(note);
			}
			return "redirect:/home";
		}
		
	}
	@RequestMapping(value="/update",method = RequestMethod.GET)
	public String updateNote(@RequestParam int id,Model model)
	{
		Note note=notesDaoImpl.get(id);
		model.addAttribute("note",note);
		return "add_notes";
	}
	@RequestMapping(value = "/download",method=RequestMethod.GET)
	public void download(@RequestParam int id,HttpServletRequest request ,HttpServletResponse response) 
	{
		Note note=notesDaoImpl.get(id);
		/*generating PDF*/
		try {
			Document document = new Document(PageSize.A4);
			ByteArrayOutputStream bos= new ByteArrayOutputStream();
			PdfWriter.getInstance(document,bos);
			document.open();
			
			Font f1= new Font(Font.FontFamily.TIMES_ROMAN,40);
			
			Paragraph para1 = new Paragraph(note.getNoteTitle(),f1);	//Paragaraph1(Note Title)
			para1.setAlignment(Element.ALIGN_CENTER);
			para1.setSpacingAfter(40f);
			document.add(para1);
			
			Paragraph para2 = new Paragraph(note.getNoteContent());		//paragraph2(Note Body)
			document.add(para2);
			
			
			document.close();
			
			response.setContentType("application/pdf");														//setting file type
			response.addHeader("Content-Disposition", "attachment; filename="+note.getNoteTitle()+".pdf");	//setting filename
			response.setContentLength(bos.size());
			
			OutputStream os=response.getOutputStream();
			bos.writeTo(os);
			os.flush();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/email")
	public String sendEmail(@RequestParam int id,Model model)
	{
		model.addAttribute("emailDto",new EmailDto());
		model.addAttribute("id",id);
		return "emailForm";
	}
	@RequestMapping(value = "/process-email")
	public String processEmail(@Valid @ModelAttribute("emailDto") EmailDto emailDto,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			return "emailForm";
		}
		else 
		{
			Integer id=(Integer) model.getAttribute("id");
			System.out.println(id);
			Note note=notesDaoImpl.get(id);
			System.out.println(emailDto.getUserEmail());
			
			SimpleMailMessage newEmail= new SimpleMailMessage();	
			newEmail.setTo(emailDto.getUserEmail());																	//setting the users email
			newEmail.setSubject(note.getNoteTitle());											//setting the subject
			newEmail.setText(note.getNoteContent());	

			mailSender.send(newEmail);          
			
			return "email-success";
		}

	}
	@RequestMapping(value = "/about")
	public String aboutApplication()
	{
		return "About";
	}
	

	@RequestMapping(value = "/delete")
	public String delete(@RequestParam int id,Model model)
	{
		notesDaoImpl.delete(id);
		return "redirect:/home";

	}
}
