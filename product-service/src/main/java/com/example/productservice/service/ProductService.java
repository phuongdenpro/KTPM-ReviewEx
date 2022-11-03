package com.example.productservice.service;

import com.example.productservice.entity.Product;


import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> listProduct();
    Product getProductById(int id);
    boolean deleteProductById(int id);
}
