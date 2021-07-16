/*
 author Anastasiya
 created on 15/07/2021
 */

package com.example.product.service.clientService;

import com.example.product.dto.ClientDTO;
import com.example.product.model.Client;

public interface ClientHandler {
    Client createClient(ClientDTO client);
    Client getByName(String name);

}
