package com.example.application.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.entities.Category;
import com.example.application.services.CategoryService;

@RestController
@RequestMapping(value = "/users")
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = categoryService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") // /{id} serve para dizer que vai aceitar um id dentro do metodo
	public ResponseEntity<Category> findById(@PathVariable Long id){ // esta @ anotação serve para dizer que vamos utilizar o id declarado acima
		Category obj = categoryService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
