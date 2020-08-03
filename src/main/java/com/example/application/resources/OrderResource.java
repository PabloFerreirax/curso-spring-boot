package com.example.application.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.entities.Order;
import com.example.application.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService userService;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") // /{id} serve para dizer que vai aceitar um id dentro do metodo
	public ResponseEntity<Order> findById(@PathVariable Long id){ // esta @ anotação serve para dizer que vamos utilizar o id declarado acima
		Order obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
