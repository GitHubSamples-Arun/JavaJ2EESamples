package com.springorm.client;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.springorm.model.Product;
import com.springorm.service.ProductService;

public class SpringOrmMain {
	
	public static void main(String[] args) {
		
		//Create Spring application context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");
		
		//Get service from context. (service's dependency (ProductDAO) is autowired in ProductService)
		ProductService productServiceImpl = ctx.getBean(ProductService.class);
		
		//Do some data operation	
		productServiceImpl.addProduct(new Product(100, "Book1"));

		productServiceImpl.addProduct(new Product(200, "Book2"));
		
		Product product1 = new Product();
		product1.setId(100);
		product1.setName("P100");
		productServiceImpl.updateProduct(product1);
		
		productServiceImpl.deleteProduct(200);
		
		System.out.println("listAll: " + productServiceImpl.listAll());
		
		productServiceImpl.addAll(Arrays.asList(new Product(5, "Book"), new Product(6, "Soap")));
		
		//Test transaction rollback (duplicated key)
		
		try {
			productServiceImpl.addAll(Arrays.asList(new Product(7, "Book"), new Product(8, "Soap"), new Product(1, "Computer")));
		} catch (DataAccessException dataAccessException) {
		}
		
		//Test element list after rollback
		System.out.println("listAll: " + productServiceImpl.listAll());
		
		ctx.close();
		
	}
}
