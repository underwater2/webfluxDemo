package com.example.webfluxDemo.service;

import com.example.webfluxDemo.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@ConditionalOnProperty(name = "cache.enabled", havingValue = "true")
public class ProductServiceWithRedisCache extends ProductServiceWithNoCache {

    private static final String KEY = "product";

//    @Autowired
//    private ReactiveHashOperations<String, String, ProductDto> hashOperations;

//    @Override
//    public Mono<ProductDto> getProduct(String id) {
//        return hashOperations.get(KEY, id)
//                .switchIfEmpty(hashOperations.get)
//    }
//
//    @Override
//    public Mono<Void> updateProduct(String id, Mono<ProductDto> productDto) {
//        return super.updateProduct(id, productDto);
//    }
}
