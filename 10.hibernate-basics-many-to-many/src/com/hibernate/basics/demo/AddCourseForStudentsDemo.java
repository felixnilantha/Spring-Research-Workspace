package com.hibernate.basics.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.basics.entity.Course;
import com.hibernate.basics.entity.Instructor;
import com.hibernate.basics.entity.InstructorDetail;
import com.hibernate.basics.entity.Review;
import com.hibernate.basics.entity.Student;

public class AddCourseForStudentsDemo {

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

			int theId = 2;

			Student theStudent = session.get(Student.class, theId);

			System.out.println("\nLoaded students: " + theStudent);
			System.out.println("Course: " + theStudent.getCourses());

			// create more courses
			
			Course course1 = new Course("Office 97 - Word processing with MS Word and spredsheets with MS Excel");
			Course course2 = new Course("Visual Basic 6.0 - Crash course");

			// add students to courses
			course1.addStudent(theStudent);
			course2.addStudent(theStudent);
			// save the courses
			
			System.out.println("\nSaving the courses");

			session.save(course1);
			session.save(course2);
			
			// commit transaction
			
			

			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
