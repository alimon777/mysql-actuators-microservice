package com.ust.rest.controller;

import java.util.ArrayList; 
import java.util.List; 
import java.util.Optional; 
import java.util.logging.Logger;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.HttpStatusCode; 
import org.springframework.http.MediaType; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

import com.ust.rest.model.Product; 
import com.ust.rest.service.ProductService;

@RestController 
@RequestMapping("/product/api1.0") //root of the resource or controller public class ProductController {
public class ProductController{
	@Autowired
	private ProductService service;

	@GetMapping(value = "/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.getProductById(id));
	}

	@GetMapping(value = "/products/{brand}")
	public ResponseEntity<List<Product>> getByBrand(@PathVariable String brand)
	{
		return ResponseEntity.ok().body(service.getProductsByBrand(brand));
	}

	@GetMapping(value="/all",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>>displayProducts()
	{
		return ResponseEntity.ok().body(service.getAllProducts());
	}


	@PostMapping(value="/add",consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		return ResponseEntity.ok().body(service.addProduct(product));
	}


	@PutMapping(value="/update", consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product>updateProduct(@RequestBody Product product)
	{
		Product updateProduct = service.updateProduct(product);
		if(updateProduct!=null)
		{
			return ResponseEntity.ok().body(product);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<Product>deleteById(@PathVariable long id)
	{
		service.deleteProduct(id);
		return ResponseEntity.ok().build();
	}
}