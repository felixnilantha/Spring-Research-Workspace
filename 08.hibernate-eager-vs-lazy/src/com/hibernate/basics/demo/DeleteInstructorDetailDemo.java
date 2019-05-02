package com.hibernate.basics.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.basics.entity.Instructor;
import com.hibernate.basics.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		//@formatter:off
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		//@formatter:on
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			int theId = 3;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);
			
			System.out.println("Instructor Detail : " + instructorDetail.getId());
			System.out.println("Associated Instrctor : " + instructorDetail.getInstructor());

			instructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(instructorDetail);
			session.getTransaction().commit();

		} 
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
