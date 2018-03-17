package main.java.com.chase.impl;

import org.hibernate.Session;

import main.java.com.chase.entities.Departments;
import main.java.com.chase.entities.DepartmentsHome;
import main.java.com.chase.util.HibernateUtil;

public class DepartmentsImpl {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + Oracle");
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
		
		DepartmentsHome dept = new DepartmentsHome();
		Departments deptInfo = dept.findById((short) 10);
		
		System.out.println("deptInfo size"+deptInfo.toString());
		
		//session.getTransaction().commit();
	}

}
