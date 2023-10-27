package com.example.webfluxDemo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "product")
public class Product {

    @Id
    private String id;
    private String description;
    private Integer price;
    private Integer qtyAvailable;
}
