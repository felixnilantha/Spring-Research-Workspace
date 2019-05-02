package com.hibernate.basics.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.basics.entity.Course;
import com.hibernate.basics.entity.Instructor;
import com.hibernate.basics.entity.InstructorDetail;
import com.hibernate.basics.entity.Review;
import com.hibernate.basics.entity.Student;

public class GetCourseForStudentsDemo {

	public static void main(String[] args) {

		//@formatter:off
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//@formatter:on
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			// get the student from the database

			int theId = 1;

			Student theStudent = session.get(Student.class, theId);

			System.out.println("\nLoaded students: " + theStudent);
			System.out.println("Course: " + theStudent.getCourses());

			
			// commit transaction
			
			

			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
