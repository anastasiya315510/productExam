/*
 author Anastasiya
 created on 16/07/2021
 */


package com.example.product.service.discountService;

import com.example.product.controller.discountController.DiscountController;
import com.example.product.dto.ProductDTO;
import com.example.product.model.Product;
import com.example.product.model.Response;
import com.example.product.repository.ClientRepository;
import com.example.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DiscountSilverClientHandlerImpl implements DiscountSilverClientHandler {


    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ProductRepository productRepository;

    @Value("{$discountSilver}")
    private String discountSilver;



    @Override
    public Response getDiscount(ProductDTO productDTO) {
        Product product = convertFromDto(productDTO);
        Product productRes = productRepository.findByName(product.getName());
//        double aDouble = Double.parseDouble(discountSilver);
        log.info("find product : "+productRepository.findByName(product.getName()));
        double aDouble = 5.0;
        if(productRes.getDiscount()>5) {
            log.info("discount more than 5 ");
            return createResponse(productRes);
        }
        else return Response.builder()
                .name(productRes.getName())
                .grandTotal(productRes.getPrice()-(productRes.getPrice()*aDouble)/100)
                .price(productRes.getPrice())
                .discountName(productDTO.getClientDTO().getType().toString())
                .description(productRes.getDescription())
                .discount(aDouble)
                .build();
    }

    private Response createResponse(Product productRes) {
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
