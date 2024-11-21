package com.order.demo.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.demo.dto.product.AddProductDto;
import com.order.demo.dto.product.EditProductDto;
import com.order.demo.model.Product;
import com.order.demo.repository.ProductRepository;


@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product saveProduct(AddProductDto addProductDto) {
        Product product = new Product();

        product.setLabel(addProductDto.getLabel());
        product.setQuantity(addProductDto.getQuantity());
        product.setUnitPrice(addProductDto.getUnitPrice());

        return this.productRepository.save(product);
    }

    public Product editProduct(EditProductDto editProductDto, UUID iUuid) {

        Optional optional = this.productRepository.findById(iUuid);

        if (optional.isPresent()) {
            
            Product product = (Product) optional.get();

            product.setLabel(editProductDto.getLabel());
            product.setQuantity(editProductDto.getQuantity());
            product.setUnitPrice(editProductDto.getUnitPrice());

            return this.productRepository.save(product);
        }       

        return null;
    }

    public void deleteProduct(UUID id) {

        Optional optional = this.productRepository.findById(id);

        if (optional.isPresent()) {
            Product product = (Product) optional.get();
            this.productRepository.delete(product);
        }

    }

    public Page<Product> getProducts(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return this.productRepository.findAll(pageable); 
    }

    public Product getProduct(UUID id){
        Optional optional = this.productRepository.findById(id);

        if (optional.isPresent()) return (Product)optional.get();

        return null;

    }

}
