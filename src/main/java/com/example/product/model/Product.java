/*
 author Anastasiya
 created on 15/07/2021
 */


package com.example.product.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;
    @Column
    private  String name;
    @Column
    private  String description;
    @Column
    private  double price;
    @Column
    private  double discount;
    @Column
    private  String discountName;
    @Column
    private  double grandTotal;
}
