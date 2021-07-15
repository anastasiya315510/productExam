/*
 author Anastasiya
 created on 15/07/2021
 */


package com.example.product.service.discountService;

import com.example.product.dto.ProductDTO;
import com.example.product.model.Product;
import com.example.product.model.Response;
import com.example.product.repository.ClientRepository;
import com.example.product.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountRegularClientHandlerImpl implements DiscountRegularClientHandler {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public Response getDiscount(ProductDTO productDTO) {
        Product product = convertFromDto(productDTO);
        Product productRes = productRepository.findByName(product.getName());
        return Response.builder()
                .name(productRes.getName())
                .grandTotal(productRes.getGrandTotal())
                .price(productRes.getPrice())
                .discountName(productRes.getDiscountName())
                .description(productRes.getDescription())
                .discount(productRes.getDiscount())
                .build();
    }

    private Product convertFromDto(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }
}
