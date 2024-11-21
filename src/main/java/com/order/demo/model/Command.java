package com.order.demo.model;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Data
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @OneToMany(mappedBy = "command", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderDetail> details;

    @CreationTimestamp
    private Date createdat;

    @UpdateTimestamp
    private Date updatedat;

    Date date;
}
