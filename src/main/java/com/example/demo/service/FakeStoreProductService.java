package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dtos.FakestoreProductdto;
import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.models.Product;

@Service("fakeService")
public class FakeStoreProductService implements ProductService {
    RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long id) {
        ResponseEntity<FakestoreProductdto> fakestoreProductdto = restTemplate.getForEntity("https://fakestoreapi.com/products/"+id, FakestoreProductdto.class);
        if(fakestoreProductdto.getBody()==null){
            throw new ProductNotFoundException("Product id not found - " + id);
        }
        return fakestoreProductdto.getBody().toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        ResponseEntity<FakestoreProductdto[]> response = restTemplate.getForEntity("https://fakestoreapi.com/products/", FakestoreProductdto[].class);
        for(FakestoreProductdto fakestoreProductdto : response.getBody()){
            products.add(fakestoreProductdto.toProduct());
        }
        return products;
    }

    @Override
    public Product createProduct(String title, double price, String description, String category, String image) {
        FakestoreProductdto fakestoreProductdto = new FakestoreProductdto();
        fakestoreProductdto.setTitle(title);
        fakestoreProductdto.setPrice(price);
        fakestoreProductdto.setDescription(description);
        fakestoreProductdto.setImage(image);
        fakestoreProductdto.setCategory(category);
        FakestoreProductdto fakestoreProductdto2 = restTemplate.postForObject("https://fakestoreapi.com/products", fakestoreProductdto, FakestoreProductdto.class);
        return fakestoreProductdto2.toProduct();
    }

    
    
}
