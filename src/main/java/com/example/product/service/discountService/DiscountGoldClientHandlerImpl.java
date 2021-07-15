/*
 author Anastasiya
 created on 16/07/2021
 */


package com.example.product.service.discountService;

import com.example.product.dto.ProductDTO;
import com.example.product.model.Product;
import com.example.product.model.Response;
import com.example.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DiscountGoldClientHandlerImpl implements DiscountGoldClientHandler {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Response getDiscount(ProductDTO productDTO) {
        Product product = convertFromDto(productDTO);
        Product productRes = productRepository.findByName(product.getName());
//        double aDouble = Double.parseDouble(discountSilver);

        double aDouble = 10.0;
        log.info(((productRes.getPrice()*aDouble)/100)+productRes.getDiscount()+" discount sum: ");
        return Response.builder()
                .name(productRes.getName())
                .grandTotal(productRes.getPrice()-(((productRes.getPrice()*aDouble)/100)+productRes.getDiscount()))
                .price(productRes.getPrice())
                .discountName(productDTO.getClientDTO().getType().toString())
                .description(productRes.getDescription())
                .discount(aDouble)
                .build();

    }

    private Product convertFromDto(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }
}
