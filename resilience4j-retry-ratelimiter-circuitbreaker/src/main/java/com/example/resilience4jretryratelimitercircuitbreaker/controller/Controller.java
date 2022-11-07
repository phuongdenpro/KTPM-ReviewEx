package com.example.resilience4jretryratelimitercircuitbreaker.controller;

import com.example.resilience4jretryratelimitercircuitbreaker.entity.Product;
import com.example.resilience4jretryratelimitercircuitbreaker.service.ProductService;
import com.google.gson.Gson;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/product")
public class Controller {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProductService productService;
    private static final String SERVICE_RESILIENCE4J = "serviceResilience4j";
    @GetMapping
//    @CircuitBreaker(name = SERVICE_RESILIENCE4J, fallbackMethod = "serviceResilience4jFallback")
    @Retry(name = SERVICE_RESILIENCE4J)
//    @RateLimiter(name = SERVICE_RESILIENCE4J)
    public List<Product> getProduct() {
        return productService.getProduct();
    }
    public ResponseEntity<String> serviceResilience4jFallback(Exception e) {
        return ResponseEntity.ok("Fallback!!");
    }
}
