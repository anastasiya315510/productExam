/*
 author Anastasiya
 created on 15/07/2021
 */

package com.example.product.repository;

import com.example.product.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findClientByLastName(String name);

}
