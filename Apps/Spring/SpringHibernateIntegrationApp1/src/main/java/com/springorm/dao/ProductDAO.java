package com.springorm.dao;

import java.util.List;
import com.springorm.model.Product;

public interface ProductDAO {
	
	List<Product> findAll();
	void addProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(Integer id);

}
