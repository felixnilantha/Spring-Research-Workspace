package com.hibernate.basics.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.basics.entity.Instructor;
import com.hibernate.basics.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {

		//@formatter:off
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		//@formatter:on
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int theId = 1;
			Instructor theInstructor = session.get(Instructor.class, theId);

			if (theInstructor != null) {
				session.delete(theInstructor);
			}

			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
