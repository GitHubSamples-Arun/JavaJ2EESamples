package impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Departments;

public class DepartmentsImpl {
	
	
	public static void main(String[] args) {
		//System.out.println("Maven + Hibernate + Oracle");
		//Session session = HibernateUtil.getSessionFactory().openSession();
		Session session = null;
		SessionFactory sf = null;
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
		session = sf.openSession();
		
		session.beginTransaction();
		
		Departments dept = new Departments();

		dept.setDepartmentId((short) 101);
		dept.setDepartmentName("Hibernate");
        //dept.setLocationId(locationId);
		
		session.save(dept);
		
		//System.out.println("deptInfo size"+deptInfo.toString());
		
		session.getTransaction().commit();
		sf.close();
	}

}

