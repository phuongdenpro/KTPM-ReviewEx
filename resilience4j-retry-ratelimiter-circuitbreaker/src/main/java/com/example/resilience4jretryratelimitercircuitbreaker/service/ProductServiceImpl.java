package com.example.resilience4jretryratelimitercircuitbreaker.service;

import com.example.resilience4jretryratelimitercircuitbreaker.entity.Product;
import com.google.gson.Gson;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private RestTemplate restTemplate;
    private static final String BASE_URL
            = "http://localhost:8084/product";
    private static Gson gson = new Gson();
    int count=1;
    @Override
    public List<Product> getProduct() {
        String url = BASE_URL;
        System.out.println((Thread.currentThread().getName()+"...runing"+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))));
        System.out.println("Retry method called " + count++ + " times at " + new Date());
        Object[] products = restTemplate.getForEntity(url, Object[].class).getBody();
        List<Product> arr = new ArrayList<>();
        for (Object item : products) {
            arr.add(gson.fromJson(gson.toJson(item), Product.class));
        }
        return arr;
    }

}
