package com.example.pract5.service;

import com.example.pract5.entity.Client;
import com.example.pract5.exception.ResourceNotFoundException;
import com.example.pract5.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public ResponseEntity<Client> getById(@PathVariable int id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not exist with id :" + id));
        return ResponseEntity.ok(client);
    }
    public Client save(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable int id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not exist with id :" + id));

        clientRepository.delete(client);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<Client> update(@PathVariable int id, @RequestBody Client newClient) throws ResourceNotFoundException {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not exist with id :" + id));

        client.setEmail(newClient.getEmail());
        client.setLogin(newClient.getLogin());
        client.setName(newClient.getName());
        client.setPassword(newClient.getPassword());

        Client updatedClient = clientRepository.save(client);
        return ResponseEntity.ok(updatedClient);
    }
}
