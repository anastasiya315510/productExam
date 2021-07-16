/*
 author Anastasiya
 created on 15/07/2021
 */


package com.example.product.controller.discountController;

import com.example.product.dto.ProductDTO;
import com.example.product.model.Client;
import com.example.product.model.Type;
import com.example.product.repository.ClientRepository;
import com.example.product.service.clientService.ClientHandler;
import com.example.product.model.Response;
import com.example.product.service.discountService.DiscountGoldClientHandler;
import com.example.product.service.discountService.DiscountRegularClientHandler;
import com.example.product.service.discountService.DiscountSilverClientHandler;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DiscountController {
    @Autowired
    ClientHandler clientHandler;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    DiscountRegularClientHandler discountRegularClientHandler;

    @Autowired
    DiscountSilverClientHandler discountSilverClientHandler;

    @Autowired
    private DiscountGoldClientHandler discountGoldClientHandler;



    @GetMapping("/discount")
    Response getDiscount(@RequestBody ProductDTO product) {
        if (product.getClientDTO() == null) {
            return discountRegularClientHandler.getDiscount(product);
        }
        Client clientByLastName = clientRepository.findClientByLastName(product.getClientDTO().getLastName());
        log.info("ClientDTO not null");
        if (clientByLastName.getType().equals(Type.SILVER)) {
            log.info("Client type is Silver");
            return discountSilverClientHandler.getDiscount(product);
        } else if (clientByLastName.getType().equals(Type.GOLDEN)) {
            log.info("Client type is Golden");
            return discountGoldClientHandler.getDiscount(product);
        }else {
            log.info("Client type is regular");
            return discountRegularClientHandler.getDiscount(product);

        }
    }
}


