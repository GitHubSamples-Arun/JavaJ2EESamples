package com.chase.service;

import java.math.BigDecimal;
import java.util.List;

import com.chase.entity.Accounts;

public interface ProjectService {
	
	public void addAccount(Accounts account);
	 
	 public void updateAccount(Accounts account);
	 
	 public List<Accounts> listAccounts();
	 
	 public Accounts getAccountById(BigDecimal id);
	 
	 public void removeAccount(BigDecimal id);

	 public void deposit(BigDecimal accountId,Double amount);
	 
	 public void withdraw(BigDecimal accountId,Double amount);

}
