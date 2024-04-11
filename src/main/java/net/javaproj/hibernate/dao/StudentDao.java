package net.javaproj.hibernate.dao;

import java.util.ArrayList;

//import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.List;

import net.javaproj.hibernate.model.Student;
import net.javaproj.hibernate.util.HibernateUtil;

//import java.util.List;

public class StudentDao{
	
	//Save
	
	public void saveStudent(Student student)
	{
		Transaction tx = null;
		
		try
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			session.save(student);
			
			tx.commit();
			
		}
		
		catch(Exception e)
		{
			if(tx != null)
			{
			tx.rollback();
		}
		
	}
	}
	
	public Student DisplayStudentById(long id)
	{
		Transaction tx = null;
		Student student = null;
		
		try
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			student= (Student)session.get(Student.class, id);
			 
			tx.commit();
			
		}
		
		catch(Exception e)
		{
			if(tx != null)
			{
			tx.rollback();
		}
		
	}
		return student;
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Student> DisplayAllStudents()
	{
		Transaction tx = null;
		ArrayList<Student> students = null;
		
		try
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			students= (ArrayList<Student>)session.createQuery("from Student").list();
			 
			tx.commit();
			
		}
		
		catch(Exception e)
		{
			if(tx != null)
			{
			tx.rollback();
		}
		
	}
		return students;
		
	}
	
	public Student UpdateStudentById(long id, String val, int col)
	{
		Transaction tx = null;
		Student student = null;
		
		try
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			student= (Student)session.get(Student.class, id);
			
			switch(col) {
			  case 1:
			    student.setFname(val);
			    break;
			  case 2:
			    student.setLname(val);
			  case 3:
				  student.setEmail(val);
				  break;
			  default:
			    // code block
			}
			session.save(student);
			 
			tx.commit();
			
		}
		
		catch(Exception e)
		{
			if(tx != null)
			{
			tx.rollback();
		}
		
	}
		return student;
		
	}
	
	
	public void DeleteStudentById(long id)
	{
		Transaction tx = null;
		//Student student = null;
		
		try
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			session.delete((Student)session.get(Student.class, id));
			 
			tx.commit();
			
		}
		
		catch(Exception e)
		{
			if(tx != null)
			{
			tx.rollback();
		}
		
	}
	
		
	}
	
}