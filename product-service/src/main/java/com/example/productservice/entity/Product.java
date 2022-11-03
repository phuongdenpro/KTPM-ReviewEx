package com.example.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Time;


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