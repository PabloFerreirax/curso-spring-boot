package com.example.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.application.entities.User;
import com.example.application.repositories.UserRepository;
import com.example.application.services.exceptions.DatabaseEception;
import com.example.application.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired // de forma transparente ao programador
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) { // se quiser achar um erro especifico apenas trocar EmptyResultDataAccessException por RunTimeException
			throw new ResourceNotFoundException(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseEception(e.getMessage());
		}
		
	}

	public User update(Long id, User user) { // uma junção de insert e delete
		User entity = userRepository.getOne(id); //instancia um usuario mas não vai em um banco de dados ainda. ele deixa em memoria para usalo
		updateData(entity, user);
		return userRepository.save(user); // salva
	}

	private void updateData(User entity, User user) { // quais campos são atualizados
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getEmail());
	}
}




