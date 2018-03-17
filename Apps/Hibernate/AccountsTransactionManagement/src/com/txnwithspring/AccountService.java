package com.txnwithspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class AccountService extends JdbcTemplate{
	
	@Autowired 
	private JdbcTemplate jdbcTemplate; 
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public void deposit(int accountNumber,double amount)
	{
		update("update accounts set balance=balance+" + amount + " where account_number=" + accountNumber);
		execute("insert into statements(account_number,transaction_amount,transaction_type) values(" + accountNumber + "," + amount + ",'Deposit')");
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void withdraw(int accountNumber,double amount)
	{
		update("update accounts set balance=balance-" + amount + " where account_number=" + accountNumber);
		execute("insert into statements(account_number,transaction_amount,transaction_type) values(" + accountNumber + "," + amount + ",'Withdraw')");
	}

}
