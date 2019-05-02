package com.hibernate.basics.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.basics.entity.Course;
import com.hibernate.basics.entity.Instructor;
import com.hibernate.basics.entity.InstructorDetail;
import com.hibernate.basics.entity.Review;

public class GetCourseAndReviewsDemo {

	public static void main(String[] args) {

		//@formatter:off
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		//@formatter:on
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			// get the course

			int theId = 10;
			Course theCourse = session.get(Course.class, theId);
			// print the course
			System.out.println(theCourse.getReviews());
			// print the course review

			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
