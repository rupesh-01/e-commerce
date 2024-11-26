package com.example.demo;

import com.example.demo.controllers.ProductController;
import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class RandomTest {
    @Autowired
    private ProductController productController;
    //3A -> Arrange, Act, Assert

    @Test
    void testAddition(){
        int a = 6;
        int b = 4;
        int actualOutput = a + b;
        assertEquals(10, actualOutput, "result should be 10");
//        assertThrows(
//                ProductNotFoundException.class,
//                () -> productController.getSingleProduct(-1L)
//        );
//        assertTimeout(
//                Duration.ofMillis(100),
//                () -> productController.getAllProducts()
//        );
//        Product product = productController.getSingleProduct(1l);
//        assertNotNull(product);
//
//        assertInstanceOf(
//                Penguin.class,
//                () -> birdFactory.get("PENGUIN");
//        );

        //assert actualOutput == 9;
    }
}
