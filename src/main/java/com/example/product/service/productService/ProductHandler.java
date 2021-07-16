/*
 author Anastasiya
 created on 15/07/2021
 */


package com.example.product.service.productService;

import com.example.product.dto.ProductDTO;
import com.example.product.model.Product;

public interface ProductHandler {
    Product createProduct(ProductDTO product);

    Product findByName(String name);

}
