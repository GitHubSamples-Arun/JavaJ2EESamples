package com.chase.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.chase.entity.Accounts;
import com.chase.util.HibernateUtil;

public class AccountsDAOImpl implements AccountsDAO {
	static Session session;
	static SessionFactory sessionFactory;
	Accounts account;
	
	static{
	sessionFactory = HibernateUtil.getSessionFactory();
    }

	public void addAccount(Accounts accountDetails) {
		session  = sessionFactory.openSession(); 
		session.beginTransaction(); 
	    session.save(accountDetails); 
	    session.getTransaction().commit();
	    session.close();
	}

	public Accounts getAccount(BigDecimal accountId) {
		session  = sessionFactory.openSession(); 
		session.beginTransaction(); 
		account = (Accounts) session.get(Accounts.class, accountId); //we get user object from session object using method session.get(Class arg1, Serializable arg2) here arg2 is primary key or id of the fetching object and arg1 is the what the model object we want to retrieve from database.
		session.getTransaction().commit();
		session.close();
		return account;
	}

	public void updateAccount(Accounts accounts) {
		session  = sessionFactory.openSession(); 
		session.beginTransaction(); 
		session.merge(accounts);
		session.close();
	    session.getTransaction().commit();
		
	}

	public void deleteAccount(BigDecimal accountId) {
      session  = sessionFactory.openSession(); 
	  session.beginTransaction(); 
	  session.delete(accountId);
	  session.close();
	  session.getTransaction().commit();
		
	}

	public List<Accounts> getAllAccounts() {
		session  = sessionFactory.openSession(); 
		List<Accounts >accounts = session.createQuery("from Accounts").list();
		session.close();
		return accounts;
	}

	public void deposit(BigDecimal accountId, Double amount) {
		session  = sessionFactory.openSession(); 
		session.beginTransaction(); 
		account = (Accounts) session.get(Accounts.class, accountId); //we get user object from session object using method session.get(Class arg1, Serializable arg2) here arg2 is primary key or id of the fetching object and arg1 is the what the model object we want to retrieve from database.
		account.setBalance(account.getBalance()+amount);
		session.getTransaction().commit();
		session.close();	
	}

	public void withdraw(BigDecimal accountId, Double amount) {
		session  = sessionFactory.openSession(); 
		session.beginTransaction(); 
		account = (Accounts) session.get(Accounts.class, accountId); //we get user object from session object using method session.get(Class arg1, Serializable arg2) here arg2 is primary key or id of the fetching object and arg1 is the what the model object we want to retrieve from database.
		account.setBalance(account.getBalance()-amount);
		session.getTransaction().commit();
		session.close();	
		
	}

}
