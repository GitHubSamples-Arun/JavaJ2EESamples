package com.chase.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.chase.dao.AccountsDAO;
import com.chase.entity.Accounts;

public class ProjectServiceImpl implements ProjectService{
	
	private AccountsDAO accountsDAO;
    
	public AccountsDAO getAccountsDAO() {
		return accountsDAO;
	}

	@Transactional
	public void setAccountsDAO(AccountsDAO accountsDAO) {
		this.accountsDAO = accountsDAO;
	}
    
	@Transactional
	public void addAccount(Accounts account) {
		this.accountsDAO.addAccount(account); 
		
	}
    
	@Transactional
	public void updateAccount(Accounts account) {
		this.accountsDAO.updateAccount(account); 
		
	}
    
	@Transactional
	public List<Accounts> listAccounts() {
		return this.accountsDAO.listAccounts(); 
	}

	@Transactional
	public Accounts getAccountById(BigDecimal id) {
		return this.accountsDAO.getAccountById(id) ;
	}
    
	@Transactional
	public void removeAccount(BigDecimal id) {
		this.accountsDAO.removeAccount(id); 
		
	}
    
	@Transactional
	public void deposit(BigDecimal accountId, Double amount) {
		this.accountsDAO.deposit(accountId, amount); 
		
	}
    
	@Transactional
	public void withdraw(BigDecimal accountId, Double amount) {
		this.accountsDAO.withdraw(accountId, amount); 
		
	}

}
