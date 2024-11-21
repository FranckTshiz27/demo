package com.order.demo.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;
    
    @Column(nullable = false,unique = true)
    private String label;

    @Column(name = "unit_price",nullable = false)
    @DecimalMin(value="0.01",message = "La valeur du prix unitaire n'est pas valide")
    private double unitPrice;

    @Column(name = "quantity",nullable = false)
    @Min(value = 1,message = "La quantité doit être strictement positive")
    private int quantity;

    @JsonIgnore()
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> details;

    @CreationTimestamp
    private Date createdat;

    @UpdateTimestamp
    private Date updatedat;
}
