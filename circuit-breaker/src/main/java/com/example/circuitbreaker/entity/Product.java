package com.example.circuitbreaker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.sql.Time;



@Getter
@Setter
public class Product implements Serializable {
    private int proId;

    private String name;

    private int price;

    public Product() {
    }

}