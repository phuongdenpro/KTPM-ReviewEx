package com.example.productserviceredis.service;

import com.example.productserviceredis.entity.Product;


import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> listProduct();
    Product getProductById(int id);
    boolean deleteProductById(int id);
}
