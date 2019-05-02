package com.hibernate.basics.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.basics.entity.Course;
import com.hibernate.basics.entity.Instructor;
import com.hibernate.basics.entity.InstructorDetail;
import com.hibernate.basics.entity.Review;
import com.hibernate.basics.entity.Student;

public class CreateCourseAndStudentsDemo {

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

			Course theCourse = new Course("Super Mario - Brothers of disstrction !! ");
			session.save(theCourse);

			// create the students
			
			Student student1 = new Student("John", "Doe", "john@email.com");
			Student student2 = new Student("Jane", "woo", "woo@email.com");

			// add students to the course
			
			theCourse.addStudent(student1);
			theCourse.addStudent(student2);

			// save the students
			
			System.out.println("\nSaving students ..");
			
			session.save(student1);
			session.save(student2);
			
			System.out.println("\nSaved students: " + theCourse.getStudents());

			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
