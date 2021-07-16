/*
 author Anastasiya
 created on 15/07/2021
 */


package com.example.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private  String name;
    private  String description;
    private  double price;
    private  double discount;
    private  String discountName;
    private  double grandTotal;
    private  ClientDTO clientDTO;

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = price-(price*discount/100);
    }
}
