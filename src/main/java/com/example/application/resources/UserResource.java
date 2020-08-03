package com.example.application.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.entities.User;
import com.example.application.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") // /{id} serve para dizer que vai aceitar um id dentro do metodo
	public ResponseEntity<User> findById(@PathVariable Long id){ // esta @ anotação serve para dizer que vamos utilizar o id declarado acima
		User obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
