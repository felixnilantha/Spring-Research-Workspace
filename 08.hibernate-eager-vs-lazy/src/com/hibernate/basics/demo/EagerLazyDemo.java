package com.hibernate.basics.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.basics.entity.Course;
import com.hibernate.basics.entity.Instructor;
import com.hibernate.basics.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		//@formatter:off
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		//@formatter:on
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			// get the instructor from database

			int theId = 1;
			Instructor theInstructor = session.get(Instructor.class, theId);

			System.out.println("\nInstructor: " + theInstructor);
			
			// get course instructor
			System.out.println("\nCourses: " + theInstructor.getCourses());

			session.getTransaction().commit();

			// close the session
			System.out.println("Closing session !!");
			
			session.close();
			
			System.out.println("\nSession closed !!!!");

			// get course instructor
			System.out.println("\nCourses: " + theInstructor.getCourses());

			System.out.println("my logs !!!");

		} finally {
			factory.close();
		}

	}

}
