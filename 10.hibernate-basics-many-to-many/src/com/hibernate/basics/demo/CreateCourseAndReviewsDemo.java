package com.hibernate.basics.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.basics.entity.Course;
import com.hibernate.basics.entity.Instructor;
import com.hibernate.basics.entity.InstructorDetail;
import com.hibernate.basics.entity.Review;

public class CreateCourseAndReviewsDemo {

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
			
			// create a course 
			
			Course theCourse = new Course("Super Mario - Brothers of disstrction !! ");
			
			// add some reviews 
			theCourse.addReiew(new Review("Best course ever"));
			theCourse.addReiew(new Review("Play it. you'll get adicted to it"));
			theCourse.addReiew(new Review("Loved it!"));
			theCourse.addReiew(new Review("Grate course !!"));
			
			// save the course ... and leverage the cascade all :-)
			
			System.out.println(theCourse.getReviews());
			
			session.save(theCourse);
			
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
