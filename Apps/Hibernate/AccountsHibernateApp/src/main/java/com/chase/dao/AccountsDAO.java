package com.chase.dao;

import java.math.BigDecimal;
import java.util.List;

import com.chase.entity.Accounts;

public interface AccountsDAO {
	
	 public void addAccount(Accounts account);

	 public List<Accounts> getAllAccounts();
	 
	 public Accounts getAccount(BigDecimal accountId);
	 
	 public void updateAccount(Accounts accounts);
	 
	 public void deleteAccount(BigDecimal accountId);
	 
	 public void deposit(BigDecimal accountId,Double amount);
	 
	 public void withdraw(BigDecimal accountId,Double amount);

}
