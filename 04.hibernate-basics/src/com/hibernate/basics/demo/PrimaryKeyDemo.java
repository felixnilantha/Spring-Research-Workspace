package com.hibernate.basics.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.basics.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		//@formatter:off
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		//@formatter:on
		Session session = factory.getCurrentSession();

		try {

			Student student1 = new Student("John", "Doe", "john.doe@hbresearch.com");
			Student student2 = new Student("Mary", "Public", "mary.public@hbresearch.com");
			Student student3 = new Student("Marty", "Sweet", "marty.sweet@hbresearch.com");
			

			session.beginTransaction();

			session.save(student1);
			session.save(student2);
			session.save(student3);

			session.getTransaction().commit();
		
			System.out.println("Done !!!");

		} finally {
			factory.close();
		}

	}

}
