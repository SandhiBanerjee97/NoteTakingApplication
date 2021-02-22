package com.sandhi.controllers;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.sandhi.dao.NotesDao;
import com.sandhi.domain.Note;


@Controller
public class AppController 
{
	@Autowired
	NotesDao notesDao;
	
	@RequestMapping("/")			
	public String temp(Model model)
	{
		List<Note> notes=notesDao.getAll();
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
	public String saveNote(@ModelAttribute("note") Note note,Model model)
	{
		note.setNoteDate(new Date());
		notesDao.save(note);
		return "home";
	}
	@RequestMapping(value = "/download",method=RequestMethod.GET)
	public void download(@RequestParam int id,HttpServletRequest request ,HttpServletResponse response) 
	{
		Note note=notesDao.get(id);
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
}
