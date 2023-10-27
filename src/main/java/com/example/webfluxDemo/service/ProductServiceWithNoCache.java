package com.example.webfluxDemo.service;

import com.example.webfluxDemo.dto.ProductDto;
import com.example.webfluxDemo.mapper.ProductMapper;
import com.example.webfluxDemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@Service
@ConditionalOnProperty(name = "cache.enabled", havingValue = "false")
public class ProductServiceWithNoCache implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Mono<ProductDto> getProduct(String id) {
        return productRepository.findById(id)
                .map(ProductMapper::toProductDto);
    }

    @Override
    public Mono<Void> updateProduct(String id, Mono<ProductDto> productDto) {
        return productRepository.findById(id)
                .zipWith(productDto)
                .doOnNext(t -> t.getT1().setQtyAvailable(t.getT2().getQtyAvailable()))
                .map(Tuple2::getT1)
                .flatMap(this.productRepository::save)
                .then();
    }
}
