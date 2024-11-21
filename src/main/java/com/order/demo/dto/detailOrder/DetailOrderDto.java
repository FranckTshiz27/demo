package com.order.demo.dto.detailOrder;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.order.demo.model.Product;


import lombok.Data;

@Data
public class DetailOrderDto {
    
    UUID product_id;

    private int quantity;

}
