package com.chase.client;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.chase.dao.AccountsDAOImpl;
import com.chase.dao.AccountsDaoSpring;
import com.chase.entity.Accounts;

public class AccountsClient 
{
	public static void main(String[] args)
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("src/beans.xml");
		AccountsDAOImpl accountsDao = context.getBean("accountsDAO",AccountsDAOImpl.class);
		
		Accounts accountDetails = new Accounts();
		
		accountDetails.setAccountNumber(new BigDecimal(110));
		accountDetails.setOwner("KKR");
		accountDetails.setBalance(1000d);
		
		accountsDao.addAccount(accountDetails);
		//accountsDao.createAccount(new BigDecimal(111), "Sam", 2300d);
		System.out.println("Accounts created");
		
		//accountsDao.updateBalance(new BigDecimal(50), 1345d);
		System.out.println("Account balance updated");
		
		//accountsDao.deleteAccount(111);
		System.out.println("Account deleted");
		
		List<Accounts> accounts = accountsDao.listAccounts();
		for (int i = 0; i < accounts.size(); i++) 
		{
			Accounts acc = accounts.get(i);
			System.out.println(acc.getAccountNumber() + " : " + acc.getOwner() + " (" + acc.getBalance() + ")");
		}
	}
}
