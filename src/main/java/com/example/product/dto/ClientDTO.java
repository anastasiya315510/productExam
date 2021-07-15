/*
 author Anastasiya
 created on 15/07/2021
 */


package com.example.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDTO {
    private String firstName;
    private String   lastName;
    private Type type;
}

