package com.chase.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chase.entity.Accounts;

@Repository
public class AccountsDAOImpl implements AccountsDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountsDAOImpl.class);

	private SessionFactory sessionFactory;
	Session session;
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	Accounts account;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	public void AccountsDAOImpl() {
		Session session = this.sessionFactory.getCurrentSession();
	}
	

	public void addAccount(Accounts accountDetails) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(accountDetails);
		logger.info("Person saved successfully, Person Details="+accountDetails);
	}


	public void updateAccount(Accounts account) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(account);
		logger.info("Account updated successfully, Account Details="+account);
	}

	@SuppressWarnings("unchecked")
	public List<Accounts> listAccounts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Accounts> personsList = session.createQuery("from Accounts").list();
		for(Accounts p : personsList){
			logger.info("Person List::"+p);
		}
		return personsList;
	}

	public Accounts getAccountById(BigDecimal id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Accounts p = (Accounts) session.load(Accounts.class, id);
		logger.info("Account loaded successfully, Person details="+p);
		return p;
	}

	public void removeAccount(BigDecimal id) {
		Session session = this.sessionFactory.getCurrentSession();
		Accounts p = (Accounts) session.load(Accounts.class, id);
		if(null != p){
			session.delete(p);
		}
		logger.info("Account deleted successfully, person details="+p);
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
