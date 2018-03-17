
import org.hibernate.Session;

import entities.Departments;
import entities.DepartmentsHome;
import util.HibernateUtil;

public class DepartmentsImpl {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + Oracle");
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
		
		Departments dept = new Departments();

		dept.setDepartmentId((short) 101);
		dept.setDepartmentName("Hibernate");
        //dept.setLocationId(locationId);
		
		session.save(dept);
		
		//System.out.println("deptInfo size"+deptInfo.toString());
		
		session.getTransaction().commit();
	}

}

