package com.example.resilience4jretryratelimitercircuitbreaker.service;

import com.example.resilience4jretryratelimitercircuitbreaker.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProduct();
}
