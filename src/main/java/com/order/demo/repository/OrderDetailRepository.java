package com.order.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.demo.model.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,UUID> {
    
}
