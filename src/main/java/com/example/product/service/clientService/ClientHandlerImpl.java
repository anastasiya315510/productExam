/*
 author Anastasiya
 created on 15/07/2021
 */


package com.example.product.service.clientService;

import com.example.product.dto.ClientDTO;
import com.example.product.dto.ProductDTO;
import com.example.product.model.Client;
import com.example.product.model.Product;
import com.example.product.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientHandlerImpl implements ClientHandler {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Client createClient(ClientDTO clientDTO) {

        Client client = convertFromDto(clientDTO);
        return clientRepository.save(client);
    }

    @Override
    public Client getByName(String name) {
        return clientRepository.findClientByLastName(name);
    }

    private Client convertFromDto(ClientDTO clientDTO) {
        return modelMapper.map(clientDTO, Client.class);
    }
}
