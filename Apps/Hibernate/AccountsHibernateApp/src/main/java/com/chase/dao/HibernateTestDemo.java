package com.chase.dao;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chase.entity.Accounts;

public class HibernateTestDemo {
	public static void main(String[] args) 
    {
        Accounts account = new Accounts(); //Creating first user
        account.setAccountNumber(new BigDecimal(50));
        account.setBalance(60000d);
        account.setOwner("Dev");
               
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); //Creating a session factory object
        Session session = sessionFactory.openSession(); //Creating a session object for inserting users  object to the database table USER_TABLE
        session.beginTransaction(); //Open the transaction of session object to do something
        
        session.save(account); //Inserting or Saving the first user object        session.save(user2);  //Inserting or Saving the second user object
        
        session.getTransaction().commit();//Close the transaction of session object after to do something
        session.close(); //Close the session object performing saving event to database
        
        account = null;  //Now getting a user object from database table from session object
        session = sessionFactory.openSession(); //Creating a new session object for fetching user object
        session.beginTransaction(); //Again Open the transaction of the session object
        
        account = (Accounts) session.get(Accounts.class, new BigDecimal(20)); //we get user object from session object using method session.get(Class arg1, Serializable arg2) here arg2 is primary key or id of the fetching object and arg1 is the what the model object we want to retrieve from database.
        session.close();
        
        System.out.println("end"+account.getAccountNumber());
        System.out.println("end"+account.getBalance());
        System.out.println("end"+account.getOwner());
        System.out.println("end");
        
        account = null;  //Now getting a user object from database table from session object
        session = sessionFactory.openSession(); //Creating a new session object for fetching user object
        session.beginTransaction(); //Again Open the transaction of the session object
        
        account = (Accounts) session.get(Accounts.class, new BigDecimal(30)); //we get user object from session object using method session.get(Class arg1, Serializable arg2) here arg2 is primary key or id of the fetching object and arg1 is the what the model object we want to retrieve from database.
        account.setBalance(40000d);
        account.setOwner("Finance Team");
        session.merge(account);
        session.getTransaction().commit();
        session.close();
        
        session = sessionFactory.openSession(); //Creating a new session object for fetching user object
        session.beginTransaction(); //Again Open the transaction of the session object
        account = (Accounts) session.get(Accounts.class, new BigDecimal(21));
        session.delete(account);
        session.getTransaction().commit();
        session.close();
        
        System.out.println("end"+account.getAccountNumber());
        System.out.println("end"+account.getBalance());
        System.out.println("end"+account.getOwner());
        System.out.println("end");
    }
}