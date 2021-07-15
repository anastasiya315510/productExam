/*
 author Anastasiya
 created on 15/07/2021
 */


package com.example.product.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Client {
    @Column
    private String firstName;
    @Column
    private String   lastName;
    @Column
    private Type type;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long clientId;


}
