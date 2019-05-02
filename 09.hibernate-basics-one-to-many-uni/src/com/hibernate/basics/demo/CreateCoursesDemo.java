package com.hibernate.basics.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.basics.entity.Course;
import com.hibernate.basics.entity.Instructor;
import com.hibernate.basics.entity.InstructorDetail;

public class CreateCoursesDemo {

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

			// create some courses

			Course course1 = new Course("Java programming");
			Course course2 = new Course("Master of arts");
			Course course3 = new Course("How to run an economy");
			Course course4 = new Course("be a looser");
			Course course5 = new Course("Memory management");

			// add courses to instructor

			theInstructor.add(course1);
			theInstructor.add(course2);
			theInstructor.add(course3);
			theInstructor.add(course4);
			theInstructor.add(course5);

			// save the courses

			session.save(course1);
			session.save(course2);
			session.save(course3);
			session.save(course4);
			session.save(course5);

			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
