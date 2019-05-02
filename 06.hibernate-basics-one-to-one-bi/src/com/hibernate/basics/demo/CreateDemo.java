package com.hibernate.basics.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.basics.entity.Instructor;
import com.hibernate.basics.entity.InstructorDetail;

public class CreateDemo {

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

//			Instructor instructor = new Instructor("Rogger", "Fun", "roger.fun@udemycom");
//
//			InstructorDetail instructorDetail = new InstructorDetail("https://rogerfun/youtube", "Fishing");
//			instructor.setInstructorDetail(instructorDetail);

			
			Instructor instructor = new Instructor("Rex", "Bar", "rex.b@udemy.com");

			InstructorDetail instructorDetail = new InstructorDetail("https://rex/youtube", "hiking");
			instructor.setInstructorDetail(instructorDetail);
			
			session.beginTransaction();
			session.save(instructor);
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
