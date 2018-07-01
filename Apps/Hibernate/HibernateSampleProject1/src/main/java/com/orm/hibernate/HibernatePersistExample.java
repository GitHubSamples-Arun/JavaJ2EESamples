package com.orm.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.orm.hibernate.model.Student;

public class HibernatePersistExample {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Student student = new Student("David Pham", new Date(), "USA", "1234569");		
		session.persist(student);
		trans.commit();
		System.out.println(" Successfully saved");
		
		Session session2 = sessionFactory.openSession();
		Transaction trans2 = session2.beginTransaction();
				
		Student student2 = (Student) session2.load(Student.class, 1);		
		student2.setName("David Villa");
		session2.persist(student2);
		trans2.commit();
		System.out.println(" Successfully saved");
		
		sessionFactory.close();
	}

}
