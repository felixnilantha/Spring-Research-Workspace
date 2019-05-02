package com.hibernate.basics.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.basics.entity.Course;
import com.hibernate.basics.entity.Instructor;
import com.hibernate.basics.entity.InstructorDetail;
import com.hibernate.basics.entity.Review;
import com.hibernate.basics.entity.Student;

public class DeleteCourseForStudentsDemo {

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

			int courseId = 10;
			
			// get a course from db
			Course theCourse = session.get(Course.class, courseId);

			
			// commit transaction
			
			System.out.println("\nDeleting course" + theCourse);
			
			session.delete(theCourse);
			

			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
