/*
 author Anastasiya
 created on 15/07/2021
 */


package com.example.product.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Builder
public class Response {
    private String name;
    private String description;
    private double price;
    private double discount;
    private String discountName;
    private double grandTotal;
}
