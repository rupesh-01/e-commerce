package com.example.demo.dtos;

import com.example.demo.models.Category;
import com.example.demo.models.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakestoreProductdto {
    Long id;
    String title;
    double price;
    String description;
    String image;
    String category;

    public Product toProduct(){
        Product product = new Product();
        product.setId(id);
        product.setName(title);
        Category category1 = new Category();
        category1.setTitle(category);
        product.setCategory(category1);
        product.setImageUrl(image);
        product.setPrice(price);
        return product;
    }
}
