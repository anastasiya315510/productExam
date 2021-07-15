/*
 author Anastasiya
 created on 15/07/2021
 */


package com.example.product.controller.clientController;

import com.example.product.dto.ClientDTO;
import com.example.product.model.Client;
import com.example.product.service.clientService.ClientHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientCreator {
    @Autowired
    ClientHandler clientHandler;

    @PostMapping("/client")
    Client createClient(@RequestBody ClientDTO client){
        return clientHandler.createClient(client);
    }

    @GetMapping("/client/{name}")
    Client getClientByName(@PathVariable String name){
       return clientHandler.getByName(name);
    }
}
