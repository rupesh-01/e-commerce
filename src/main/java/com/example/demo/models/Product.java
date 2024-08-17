package com.example.demo.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String name;
    private String imageUrl;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;
    private double price;
    private String description;
}
