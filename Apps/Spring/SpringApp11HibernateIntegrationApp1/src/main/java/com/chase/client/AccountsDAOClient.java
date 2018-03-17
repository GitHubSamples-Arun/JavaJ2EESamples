package com.chase.client;

import java.math.BigDecimal;
import java.util.List;

import com.chase.dao.AccountsDAO;
import com.chase.dao.AccountsDAOImpl;
import com.chase.entity.Accounts;

public class AccountsDAOClient {

	public static void main(String[] args) {
		AccountsDAO accountDao = new AccountsDAOImpl();
		System.out.println("AccountsDAOClient");
		
		 Accounts account = new Accounts(); //Creating first user
	     account.setAccountNumber(new BigDecimal(80));
	     account.setBalance(60000d);
	     account.setOwner("QA");
	     accountDao.addAccount(account);
	     
	     accountDao.deposit(new BigDecimal(10), 500d);
	     accountDao.deposit(new BigDecimal(20), 500d);
	     
	     //List<Accounts> accounts = accountDao.getAllAccounts();
//	     System.out.println("AccountsDAOClient end");
//	     System.out.println(accounts.size());
	     
	}

}
