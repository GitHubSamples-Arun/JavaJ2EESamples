package com.springorm.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.springorm.dao.ProductDAOImpl;
import com.springorm.model.Product;

@Component
public class ProductService{

	@Autowired
	private ProductDAOImpl productDAOImpl;
    
	@Transactional(readOnly = true)
	public List<Product> listAll() {
		return productDAOImpl.findAll();
	}
	
	@Transactional
	public void addProduct(Product product) {
		productDAOImpl.addProduct(product);
	}
	
	@Transactional
	public void updateProduct(Product product) {
		productDAOImpl.updateProduct(product);
	}
	
	@Transactional
	public void deleteProduct(Integer id) {
		productDAOImpl.deleteProduct(id);
	}
	
	@Transactional
	public void addAll(Collection<Product> products) {
		for (Product product : products) {
			productDAOImpl.addProduct(product);
		}
	}
	
}
