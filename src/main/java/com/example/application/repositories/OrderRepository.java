package com.example.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long>{ //nao precisa implementar

}
