package com.example.productserviceretry.controller;

import com.example.productserviceretry.entity.Product;
import com.example.productserviceretry.service.ProductService;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("")
    public Product addProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping("")
    public List<Product> getListProduct() {
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(3)
                .waitDuration(Duration.ofSeconds(2))
                .build();
        RetryRegistry registry = RetryRegistry.of(config);
        Retry retry = registry.retry("productService", config);
        List<Product> products = retry.executeSupplier(
                () -> productService.listProduct());

        return products;
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(3)
                .waitDuration(Duration.ofSeconds(2))
                .build();
        RetryRegistry registry = RetryRegistry.of(config);
        Retry retry = registry.retry("productService", config);
        Product product = retry.executeSupplier(
                () -> productService.getProductById(id));
        return product;
    }
    @DeleteMapping("/{id}")
    public boolean deleteProductById(@PathVariable int id){
        return productService.deleteProductById(id);
    }

}