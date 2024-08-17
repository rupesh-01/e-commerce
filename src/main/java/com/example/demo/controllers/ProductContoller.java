package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.RequestBodyProductdto;
import com.example.demo.models.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductContoller {
    ProductService productService;

    public ProductContoller(@Qualifier("ownProductService") ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/product/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){
        return productService.getSingleProduct(id);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @PostMapping("/products")
    public Product createProduct(@RequestBody RequestBodyProductdto productdto){
        return productService.createProduct(productdto.getTitle(),
                                productdto.getPrice(),
                                productdto.getImage(),
                                productdto.getDescription(),
                                productdto.getCategory()
                            );
    }
}
