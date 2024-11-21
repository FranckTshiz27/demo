package com.order.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.demo.dto.product.AddProductDto;
import com.order.demo.dto.product.EditProductDto;
import com.order.demo.model.Product;
import com.order.demo.routes.Route;
import com.order.demo.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("*")
@RequestMapping(Route.product)
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("create")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody AddProductDto addProductDto) {

        Product product = this.productService.saveProduct(addProductDto);

        return ResponseEntity.ok().body(product);
    }

    @GetMapping("products")
    public ResponseEntity<Page<Product>> getProducts(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Product> products = this.productService.getProducts(page, size);
        return ResponseEntity.ok().body(products);
    }

    @PatchMapping("edit/{uuid}")
    public ResponseEntity<Product> editProduct(@Valid @RequestBody EditProductDto editProductDto,
            @PathVariable("uuid") UUID uuid) {
        Product product = this.productService.editProduct(editProductDto, uuid);
        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping("delete/{uuid}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("uuid") UUID id){

        this.productService.deleteProduct(id);
        
     return ResponseEntity.noContent().build();
    }
}
