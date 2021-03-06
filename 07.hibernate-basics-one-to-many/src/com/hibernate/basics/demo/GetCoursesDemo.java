package com.hibernate.basics.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.basics.entity.Course;
import com.hibernate.basics.entity.Instructor;
import com.hibernate.basics.entity.InstructorDetail;

public class GetCoursesDemo {

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

			System.out.println("\nInstructor: " + theInstructor.getFirstName());
			// get course instructor
			System.out.println("\nCourses: " + theInstructor.getCourses());
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
