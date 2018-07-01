package com.orm.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.orm.hibernate.model.Student;

public class HibernateSaveExample {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Student student = new Student("David Pham", new Date(), "USA", "1234569");
		Integer studentId = (Integer) session.save(student);
		System.out.println(" Identifier : " + studentId);
		System.out.println(" Successfully saved");
		
		Session session2 = sessionFactory.openSession();
		Transaction trans = session2.beginTransaction();
		
		Student student2 = new Student("David Pham", new Date(), "USA", "1234569");
		Integer studentId2 = (Integer) session2.save(student2);
		trans.commit();
		System.out.println(" Identifier : " + studentId2);
		System.out.println(" Successfully saved");
		
		sessionFactory.close();
	}

}
