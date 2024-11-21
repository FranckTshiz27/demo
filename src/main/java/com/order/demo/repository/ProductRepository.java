package com.order.demo.repository;

import org.hibernate.query.Page;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.order.demo.model.Product;
import java.util.*;

public interface ProductRepository extends JpaRepository<Product,UUID>{
}
