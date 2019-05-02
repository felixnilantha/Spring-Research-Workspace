package com.hibernate.basics.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.basics.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		//@formatter:off
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//@formatter:on
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			System.out.println("\nList all student(s)");
			List<Student> theStudents = session.createQuery("from Student").getResultList();

			dispayStudent(theStudents);
			
			
			System.out.println("\nList student(s) with a (WHERE) clause");
			theStudents = session.createQuery("from Student s where s.lastName='Morningstar'").list();

			dispayStudent(theStudents);
			
			
			System.out.println("\nList student(s) with a (OR) clause");
			theStudents = session
					.createQuery("from Student s where s.lastName='Morningstar' " + " or s.firstName='Marty'").list();

			dispayStudent(theStudents);
			
			
			System.out.println("\nList student(s) with a (LIKE) clause");
			theStudents = session.createQuery("from Student s where s.email LIKE '%hbresearch.com'").list();
			dispayStudent(theStudents);

			session.getTransaction().commit();

			System.out.println("Done !!!");

		} finally {
			factory.close();
		}

	}

	private static void dispayStudent(List<Student> theStudents) {
		theStudents.forEach(System.out::println);
	}

}
