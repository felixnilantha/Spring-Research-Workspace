package com.hibernate.basics.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.basics.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		//@formatter:off
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//@formatter:on
		Session session = factory.getCurrentSession();

		try {
			
			Student student = new Student("John", "Doe","john.doe@hbresearch.com");
			
			session.beginTransaction();
			
			session.save(student);
			
			session.getTransaction().commit();;
			
			System.out.println("Done !!!");

		} finally {
			factory.close();
		}

	}

}
