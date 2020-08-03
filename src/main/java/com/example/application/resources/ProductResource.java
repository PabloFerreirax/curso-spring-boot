package com.example.application.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.entities.Product;
import com.example.application.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = productService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}") // /{id} serve para dizer que vai aceitar um id dentro do metodo
	public ResponseEntity<Product> findById(@PathVariable Long id) { // esta @ anotação serve para dizer que vamos utilizar o id declarado acima
																		
		Product obj = productService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
