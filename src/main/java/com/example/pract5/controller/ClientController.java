package com.example.pract5.controller;

import com.example.pract5.entity.Client;
import com.example.pract5.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {

    ClientService clientService;

    @PostMapping("/clients")
    public int create(@RequestBody Client client) {
        clientService.save(client);
        return client.getId();
    }

    @GetMapping("/clients")
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @GetMapping("/clients/{id}")
    public Client getById(@PathVariable int id) {
        return clientService.getById(id);
    }

    @PutMapping("/clients/{id}")
    public Client update(@PathVariable int id, @RequestBody Client client){
        clientService.update(id, client);
        return client;
    }

    @DeleteMapping("/clients/{id}")
    public void delete(@PathVariable int id){
        clientService.delete(id);
    }
}
