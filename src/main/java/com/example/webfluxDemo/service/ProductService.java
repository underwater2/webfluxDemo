package com.example.webfluxDemo.service;

import com.example.webfluxDemo.dto.ProductDto;
import reactor.core.publisher.Mono;

public interface ProductService {

    Mono<ProductDto> getProduct(String id);
    Mono<Void> updateProduct(String id, Mono<ProductDto> productDto);
}
