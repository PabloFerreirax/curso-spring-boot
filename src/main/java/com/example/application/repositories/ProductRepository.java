package com.example.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{ //nao precisa implementar

}
