package com.example.demo.controllers;

import java.util.List;

import com.example.demo.commons.AuthUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.RequestBodyProductdto;
import com.example.demo.models.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
    private final ProductService productService;
    private final AuthUtil authUtil;

    public ProductController(@Qualifier("fakeService") ProductService productService, AuthUtil authUtil){
        this.productService = productService;
        this.authUtil = authUtil;
    }

    @GetMapping("/product/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){
        return productService.getSingleProduct(id);
    }

    @GetMapping("/products/{token}")
    public ResponseEntity<List<Product>> getAllProducts(@PathVariable String token){
        authUtil.validateToken(token);
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody RequestBodyProductdto productDto){
        return productService.createProduct(productDto.getTitle(),
                productDto.getPrice(),
                productDto.getImage(),
                productDto.getDescription(),
                productDto.getCategory()
        );
    }
}
