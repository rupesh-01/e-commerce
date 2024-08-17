package com.example.demo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestBodyProductdto {
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
