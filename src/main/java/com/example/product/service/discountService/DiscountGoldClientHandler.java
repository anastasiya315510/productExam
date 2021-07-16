/*
 author Anastasiya
 created on 16/07/2021
 */

package com.example.product.service.discountService;

import com.example.product.dto.ProductDTO;
import com.example.product.model.Response;

public interface DiscountGoldClientHandler {
    Response getDiscount(ProductDTO product);
}
