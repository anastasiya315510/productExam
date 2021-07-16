/*
 author Anastasiya
 created on 15/07/2021
 */

package com.example.product.service.discountService;

import com.example.product.dto.ProductDTO;
import com.example.product.model.Product;
import com.example.product.model.Response;

public interface DiscountRegularClientHandler {
    Response getDiscount(ProductDTO product);

}
