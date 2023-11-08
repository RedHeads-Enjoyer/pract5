package com.example.pract5.service;

import com.example.pract5.entity.Client;
import com.example.pract5.repository.ClientRepository;

public class ClientService  extends AbstractService<Client, ClientRepository> {
    public ClientService(ClientRepository clientRepository) {
        super(clientRepository);
    }
}
