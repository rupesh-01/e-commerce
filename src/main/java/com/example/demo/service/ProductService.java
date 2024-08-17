package com.example.demo.service;

import java.util.List;

import com.example.demo.models.Product;

public interface ProductService {
    Product getSingleProduct(Long id);
    List<Product> getAllProducts();
    Product createProduct(String title,double price, String image, String description, String category);
}
