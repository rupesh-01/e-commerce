package com.example.demo.controllers;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductContollerTest {
    @Autowired
    private ProductContoller productContoller;
    @MockBean
    private ProductService productService;

    @Test
    void testGetAllProducts() {
        List<Product> expectedProducts = new ArrayList<>();
        Product p1 = new Product();
        p1.setName("Rolex Watch");
        p1.setPrice(22.50);
        Product p2 = new Product();
        p2.setName("Key Board");
        p2.setPrice(111.00);
        Product p3 = new Product();
        p3.setName("Mouse");
        p3.setPrice(20.5);
        expectedProducts.add(p1);
        expectedProducts.add(p2);
        expectedProducts.add(p3);
        when(productService.getAllProducts())
                .thenReturn(expectedProducts);
        List<Product> actualProduct = productContoller.getAllProducts();

        assertEquals(expectedProducts.size(), actualProduct.size());
        for(int i = 0; i < expectedProducts.size(); i++){
            assertEquals(expectedProducts.get(i),
                    actualProduct.get(i));
        }

    }
}