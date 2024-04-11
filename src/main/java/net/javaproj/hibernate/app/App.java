package net.javaproj.hibernate.app;

import java.util.ArrayList;

import net.javaproj.hibernate.dao.StudentDao;
import net.javaproj.hibernate.model.Student;

public class App{
	
	public static void main(String[] args)
	{
		StudentDao studentDao = new StudentDao();
		Student student = new Student("Arushi", "Agrawal", "aagrawal@gmail.com");
		
		studentDao.saveStudent(student);
		
		Student student2= new Student("Soumya", "sommi","soumyas@gmail.com");
		studentDao.saveStudent(student2);
		
		Student student3 = studentDao.DisplayStudentById(student.getId());
		System.out.println(student3.getFname()+ " "+ student3.getLname()+" "+student.getEmail());
		
	/*	ArrayList<Student> students = studentDao.DisplayAllStudents();
		
		for (Student s : students)
		{
			System.out.println(s.getId());
		}
		
		*/
	}
}