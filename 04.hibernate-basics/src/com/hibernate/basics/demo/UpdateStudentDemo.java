package com.hibernate.basics.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.basics.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		//@formatter:off
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//@formatter:on
		Session session = factory.getCurrentSession();

		try {

			int studentId = 1;
			session = factory.getCurrentSession();
			session.beginTransaction();

			System.out.println("\nGetting student with id: " + studentId);
			Student myStudent = session.get(Student.class, studentId);

			myStudent.setEmail("john.doe@hell.com");

			System.out.println("Get complete !! : " + myStudent);

			session.getTransaction().commit();

			session = factory.getCurrentSession();
			session.beginTransaction();

			session.createQuery("update Student set email ='foo@foo.com.au'").executeUpdate();

			session.getTransaction().commit();
			System.out.println("Done !!!");

		} finally {
			factory.close();
		}

	}

}
