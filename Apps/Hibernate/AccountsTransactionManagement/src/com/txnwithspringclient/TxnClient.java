package com.txnwithspringclient;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.txnwithspring.AccountService;

public class TxnClient {
	
	public static void main(String[] args) 
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans.xml");
		AccountService accService = (AccountService) context.getBean("accountServiceBean");
		System.out.println("Calling deposit::::");
		accService.deposit(1001, 1000);
		System.out.println("Calling withdraw::::");
		accService.withdraw(1001, 100);
		System.out.println("Account operation completed successfully::::");
	}

}
