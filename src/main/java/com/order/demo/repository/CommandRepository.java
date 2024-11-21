package com.order.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.demo.model.Command;

public interface CommandRepository extends JpaRepository<Command,UUID>{
    
}
