package com.hibernate.basics.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.basics.entity.Course;
import com.hibernate.basics.entity.Instructor;
import com.hibernate.basics.entity.InstructorDetail;

public class CreateInstrctorDemo {

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

			Instructor instructor = new Instructor("Mark", "Young", "mark.young@udemycom");

			InstructorDetail instructorDetail = new InstructorDetail("https://markyoung/youtube", "Gamer");
			instructor.setInstructorDetail(instructorDetail);
			
			session.beginTransaction();
			session.save(instructor);
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
