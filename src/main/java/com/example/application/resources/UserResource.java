package com.example.application.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping // usado para inserir um novo recurso no banco
	public ResponseEntity<User> insert(@RequestBody User obj){ // esta anotaçao diz que quando chegar no mode json e esse json vai ser descerializado para um obj user
		obj = userService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}") // .path("/{id}") recebe um padrao para montar url... colocar aquilo que colocou em FindById
				.buildAndExpand(obj.getId()).toUri(); // .buildAndExpand(obj.getId()) espera o Id do que foi inserido... precisa pegar o id /// toUri converte.
		return ResponseEntity.created(uri).body(obj); //created espera um URI acima digo como fazer ela
		// esta tag é muito util para criação do 201 que retorna tudo sobre o obj criado.
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		obj = userService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
