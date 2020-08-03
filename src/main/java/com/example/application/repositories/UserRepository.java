package com.example.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{ //nao precisa implementar

}
