package com.example.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.entities.OrderItem;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{ //nao precisa implementar

}
