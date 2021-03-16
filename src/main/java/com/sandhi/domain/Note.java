package com.sandhi.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Note 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer noteId;
	
	@Column(length = 40)
	@Size(min=3, message = "* Your name should have minimum 3 charecters")
	private String noteAuthor;
	
	@Size(min=3, message = "* Your name should have minimum 3 charecters")
	@Column(length = 120)
	private String noteTitle;
	
	@NotBlank(message = "* Note Content cannot be blank")
	@Column(length = 1400)
	private String noteContent;
	
	private Date noteDate;
	
	public Note() {
		super();
	}
	
	
	public Note(Integer noteId, String noteAuthor, String noteTitle, String noteContent, Date noteDate) {
		super();
		this.noteId = noteId;
		this.noteAuthor = noteAuthor;
		this.noteTitle = noteTitle;
		this.noteContent = noteContent;
		this.noteDate = noteDate;
	}


	public Integer getNoteId() {
		return noteId;
	}
	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}
	public String getNoteAuthor() {
		return noteAuthor;
	}
	public void setNoteAuthor(String noteAuthor) {
		this.noteAuthor = noteAuthor;
	}
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	public String getNoteContent() {
		return noteContent;
	}
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}
	public Date getNoteDate() {
		return noteDate;
	}
	public void setNoteDate(Date noteDate) {
		this.noteDate = noteDate;
	}
	@Override
	public String toString() {
		return getNoteTitle()+ ":" +getNoteContent() ;
	}
	
}
