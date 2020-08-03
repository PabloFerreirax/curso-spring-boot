package com.example.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long>{ //nao precisa implementar

}
