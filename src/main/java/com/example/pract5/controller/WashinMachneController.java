package com.example.pract5.controller;

import com.example.pract5.entity.Book;
import com.example.pract5.entity.WashingMachine;
import com.example.pract5.exception.ResourceNotFoundException;
import com.example.pract5.service.BookService;
import com.example.pract5.service.WashingMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class WashinMachneController {
    @Autowired
    WashingMachineService washingMachineService;


    @PostMapping("/washingmachines")
    public WashingMachine create(@RequestBody WashingMachine washingMachine) {
        return washingMachineService.save(washingMachine);
    }


    @GetMapping("/washingmachines")
    public List<WashingMachine> getAll() {
        return washingMachineService.getAll();
    }

    @GetMapping("/washingmachines/{id}")
    public ResponseEntity<WashingMachine> getById(@PathVariable int id) throws ResourceNotFoundException {
        return washingMachineService.getById(id);
    }

    @PutMapping("/washingmachines/{id}")
    public WashingMachine update(@PathVariable int id, @RequestBody WashingMachine washingMachine) throws ResourceNotFoundException {
        washingMachineService.update(id, washingMachine);
        return washingMachine;
    }

    @DeleteMapping("/washingmachines/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable int id) throws ResourceNotFoundException {
        return washingMachineService.delete(id);
    }
}
