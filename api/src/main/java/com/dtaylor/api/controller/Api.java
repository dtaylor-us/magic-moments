package com.dtaylor.api.controller;

import com.dtaylor.api.domain.Product;
import com.dtaylor.api.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class Api {

    private static final String PRODUCTS = "/products";
    private static final String PRODUCT = PRODUCTS + "/{id}";
    ProductRepository productRepository;

    public Api(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(PRODUCTS)
    public Flux<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping(PRODUCT)
    public Mono<ResponseEntity<Product>> getProduct(@PathVariable String id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping(PRODUCTS)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Product> saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping(PRODUCT)
    public Mono<ResponseEntity<Product>> updateProduct(@PathVariable(value = "id") String id,
                                                       @RequestBody Product product) {
        return productRepository.findById(id)
                .flatMap(it -> {
                    it.setName(product.getName());
                    it.setPrice(product.getPrice());
                    return productRepository.save(it);
                })
                .map(ResponseEntity::ok)
                .defaultIfEmpty(getNotFoundEntity());
    }

    private ResponseEntity<Product> getNotFoundEntity() {
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(PRODUCT)
    public Mono<ResponseEntity<Void>> deleteProduct(@PathVariable(value = "id") String id) {
        return productRepository.findById(id)
                .flatMap(it -> productRepository.delete(it)
                        .then(Mono.just(ResponseEntity.ok().<Void>build())))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping(PRODUCTS)
    public Mono<Void> deleteProducts() {
        return productRepository.deleteAll();
    }
}
