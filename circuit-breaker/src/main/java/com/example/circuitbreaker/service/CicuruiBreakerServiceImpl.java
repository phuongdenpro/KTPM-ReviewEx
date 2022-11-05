package com.example.circuitbreaker.service;

import com.example.circuitbreaker.entity.Product;
import com.google.gson.Gson;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CicuruiBreakerServiceImpl implements CicuruiBreakerService{
    static final String URL_API = "http://localhost:8084/product";
    private static Gson gson = new Gson();

    @Autowired
    private RestTemplate restTemplate;

    private static final String PRODUCT_SERVICE = "product-service";
    int count=1;
    @Override
    @RateLimiter(name = PRODUCT_SERVICE)
    public List<Product> getProduct() {
        String url = URL_API + "b";
        System.out.println("Retry method called " + count++ + " times at " + new Date());
        Object[] products = restTemplate.getForEntity(URL_API, Object[].class).getBody();
        List<Product> arr = new ArrayList<>();
        for (Object item : products) {
            arr.add(gson.fromJson(gson.toJson(item), Product.class));
        }
        return arr;
    }
    public String serviceAFallback(Exception e) {
        return "This is a fallback method for Service Product";
    }

}
