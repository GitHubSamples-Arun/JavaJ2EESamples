package com.chase.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.chase.entity.Accounts;

public class AccountsDaoSpring extends HibernateDaoSupport 
{   
	//@Transactional 
	public void createAccount(BigDecimal accountNumber,String owner,Double balance)
	{
/*		 SessionFactory sessionFactory = getHibernateTemplate().getSessionFactory(); 
		 Session session = sessionFactory.openSession(); 
		 Transaction txn = session.beginTransaction();*/
		 Accounts account = new Accounts(accountNumber,owner,balance);
		 getHibernateTemplate().save(account);
	}
	public void updateBalance(BigDecimal accountNumber,double newBalance)
	{
		Accounts account = getHibernateTemplate().get(Accounts.class, accountNumber);
		if(account != null)
		{
			account.setBalance(newBalance);
		}
		getHibernateTemplate().update(account);
	}
	public void deleteAccount(BigDecimal accountNumber)
	{
		Accounts account = getHibernateTemplate().get(Accounts.class, accountNumber);
		if(account != null)
			getHibernateTemplate().delete(account);
	}
	public List<Accounts> getAllAccounts()
	{
		return (List<Accounts>) getHibernateTemplate().find("from Accounts");
	}
	
}
