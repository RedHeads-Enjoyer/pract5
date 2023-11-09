package com.example.pract5.controller;

import com.example.pract5.entity.Client;
import com.example.pract5.exception.ResourceNotFoundException;
import com.example.pract5.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientService clientService;


    @PostMapping("/clients")
    public Client create(@RequestBody Client client) {
        return clientService.save(client);
    }


    @GetMapping("/clients")
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getById(@PathVariable int id) throws ResourceNotFoundException {
        return clientService.getById(id);
    }

    @PutMapping("/clients/{id}")
    public Client update(@PathVariable int id, @RequestBody Client client) throws ResourceNotFoundException {
        clientService.update(id, client);
        return client;
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable int id) throws ResourceNotFoundException {
        return clientService.delete(id);
    }
}
