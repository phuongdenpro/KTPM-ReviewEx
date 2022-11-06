package com.example.productserviceretry.service;

import com.example.productserviceretry.entity.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> listProduct();
    Product getProductById(int id);
    boolean deleteProductById(int id);
}
