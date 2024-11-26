package com.example.demo.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;
//import com.example.demo.repositories.projections.ProductProjection;

@Primary
@Service("ownProductService")
public class OwnProductService implements ProductService {
    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    public OwnProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long id) {
        Product product = productRepository.findByIdIs(id);
        if(product == null){
            throw new ProductNotFoundException("Product id not found " + id);
        }
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        /* Use of Product projection example
        List<ProductProjection> products = productRepository.findProductWithPrice(22.5);
        products.get(0).getDescription();
        */
        return productRepository.findAll();
    }


    @Override
    public Product createProduct(String title, double price, String image, String description, String category) {
        Product product = new Product();
        product.setName(title);
        product.setPrice(price);
        product.setImageUrl(image);
        product.setDescription(description);
        Category categoryFromDb = categoryRepository.findByTitle(category);
        if(categoryFromDb == null){
            Category category2 = new Category();
            category2.setTitle(category);
            categoryFromDb = category2;
        }
        product.setCategory(categoryFromDb);
        return productRepository.save(product);
    }
    
}
