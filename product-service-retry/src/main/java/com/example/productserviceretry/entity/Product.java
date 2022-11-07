package com.example.productserviceretry.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "product")
@Getter
@Setter
public class Product implements Serializable {
    @Id
    @Column(name="proId")
    private int proId;

    @Column(name="name", columnDefinition = "varchar(50)")
    private String name;

    @Column(name="price")
    private int price;

    public Product() {
    }

}