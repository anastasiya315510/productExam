/*
 author Anastasiya
 created on 15/07/2021
 */


package com.example.product.controller.productController;

import com.example.product.dto.ProductDTO;
import com.example.product.model.Product;
import com.example.product.service.clientService.ClientHandler;
import com.example.product.service.productService.ProductHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductCreator {
    @Autowired
    ProductHandler productHandler;

    @Autowired
    ClientHandler clientHandler;

    @PostMapping("/product")
    Product createProduct(@RequestBody ProductDTO product){
        if(product.getClientDTO()!=null){
            clientHandler.createClient(product.getClientDTO());
            System.out.println("Client Handler"+product.getClientDTO().getFirstName());
        }
        return productHandler.createProduct(product);
    }

    @GetMapping("/product/{name}")
    Product findByName(@PathVariable String name){
        return productHandler.findByName(name);
    }
}
