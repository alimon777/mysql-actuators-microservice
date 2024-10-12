package com.ust.client.controller;
import java.util.List;
import java.util.Optional;
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
import org.springframework.web.client.RestTemplate;
import com.ust.client.model.Product;

@RestController
@RequestMapping("/client/api1.0")
public class ProductController {
	@Autowired
	RestTemplate template;
	
	@GetMapping("/allProducts")
	public List<Product>fetchProducts()
	{
		String url = "http://localhost:8090/product/api1.0/all";
		List<Product> list = template.getForObject(url,List.class);
		return list;
	}
	
	@GetMapping(value = "/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id)
	{
		String url = "http://localhost:8090/product/api1.0/product/"+id;
		Product result = template.getForObject(url,Product.class);
		return ResponseEntity.ok().body(result);
	}
	
	
	@PostMapping(value="/addProduct",consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		String url = "http://localhost:8090/product/api1.0/add";
		Product result = template.postForObject(url,product,Product.class);
		return ResponseEntity.ok().body(result);
	}
	
	@PutMapping(value="/updateProduct",consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> updateProduct(@RequestBody Product product)
	{
		String url = "http://localhost:8090/product/api1.0/update";
		template.put(url,product);
		return ResponseEntity.ok().body(product);
	}
	@DeleteMapping(value="/deleteProduct/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> deleteProduct(@PathVariable Long id)
	{
		String url = "http://localhost:8090/product/api1.0/delete/"+id;
		template.delete(url);
		return ResponseEntity.ok().build();
	}
	
}