package com.example.circuitbreaker.controller;

import com.example.circuitbreaker.entity.Product;
import com.example.circuitbreaker.service.CicuruiBreakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CicruitBreakerController {

    @Autowired
    private CicuruiBreakerService cicuruiBreakerService;
    @GetMapping("/product")
    public List<Product> getChuyenBay() {
        List<Product> dsChuyenBay = cicuruiBreakerService.getProduct();
//        logger.info(dsChuyenBay.size());

        return dsChuyenBay;
    }
}
