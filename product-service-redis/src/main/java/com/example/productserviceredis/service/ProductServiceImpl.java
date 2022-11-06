package com.example.productserviceredis.service;

import com.example.productserviceredis.entity.Product;
import com.example.productserviceredis.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> listProduct() {
        List<Product> productList = (List<Product>) productRepository.findAll();
        return productList;
    }

    @Override
    public Product getProductById(int id) {
        Product product = productRepository.findById(id).orElse(null);
        return product;
    }

    @Override
    public boolean deleteProductById(int id) {
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}