package com.sandhi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.query.Query;

import com.sandhi.domain.Note;

@Component
public class NotesDao 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public int save(Note note)
	{
		Session session=sessionFactory.getCurrentSession();
		Integer res=(Integer) session.save(note);
		return res;
	}
	@Transactional
	public Note get(int id)
	{
		Session session=sessionFactory.getCurrentSession();
		Note note=session.get(Note.class, id);
		return note;
	}
	@Transactional
	public List<Note> getAll()
	{
		Session session=sessionFactory.getCurrentSession();
		
		/*CAN ALSO BE WRITTEN LIKE =>List<Note> notes=session.createQuery("from Note").list()*/
		Query q=session.createQuery("from Note");
		List<Note> notes=q.list();
		
		return notes;
	}
}
