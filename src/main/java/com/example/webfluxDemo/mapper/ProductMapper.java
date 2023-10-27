package com.example.webfluxDemo.mapper;

import com.example.webfluxDemo.dto.ProductDto;
import com.example.webfluxDemo.entity.Product;

public class ProductMapper {

    public static ProductDto toProductDto(Product product){
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        dto.setQtyAvailable(product.getQtyAvailable());
        return dto;
    }

    public static Product toProduct(ProductDto dto){
        Product product = new Product();
        product.setId(dto.getId());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setQtyAvailable(dto.getQtyAvailable());
        return product;
    }
}
