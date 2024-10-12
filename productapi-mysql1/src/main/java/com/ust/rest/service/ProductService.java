package com.ust.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.rest.model.Product;
import com.ust.rest.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product addProduct(Product newProduct) {
		return repository.save(newProduct);
	}
	
	public List<Product> getAllProducts(){
		return repository.findAll();
	}
	
	public Product getProductById(Long id){
		return repository.findById(id).orElse(null);
	}
	
	public List<Product> getProductsByBrand(String brand){
		return repository.findByBrandIgnoreCase(brand);
	}
	
	public Product updateProduct(Product product) {
		if(repository.existsById(product.getId()))
			return repository.save(product);
		return null;
	}
	
	public void deleteProduct(Long id) {
		repository.deleteById(id);
	}
	
}
