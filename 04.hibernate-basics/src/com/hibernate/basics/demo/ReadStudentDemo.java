package com.hibernate.basics.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.basics.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		//@formatter:off
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//@formatter:on
		Session session = factory.getCurrentSession();

		try {

			Student student = new Student("Lucyfer", "Morningstar", "lucyfer.morningstar@hbresearch.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();

			System.out.println("Saved student generated id : " + student.getId());

			session = factory.getCurrentSession();
			session.beginTransaction();

			Student myStudent = session.get(Student.class, student.getId());

			System.out.println("Get complete !! : " + myStudent);
			System.out.println("Done !!!");

		} finally {
			factory.close();
		}

	}

}
