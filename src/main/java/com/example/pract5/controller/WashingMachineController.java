package com.example.pract5.controller;

import com.example.pract5.entity.Telephone;
import com.example.pract5.entity.WashingMachine;
import com.example.pract5.exception.ResourceNotFoundException;
import com.example.pract5.repository.WashingMachineRepository;
import com.example.pract5.service.TelephoneService;
import com.example.pract5.service.WashingMachineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class WashingMachineController {
    WashingMachineService washingMachineService;

    @PostMapping("/washingmachines")
    public int create(@RequestBody WashingMachine washingMachine) {
        washingMachineService.save(washingMachine);
        return washingMachine.getId();
    }

    @GetMapping("/washingmachines")
    public List<WashingMachine> getAll() {
        return washingMachineService.getAll();
    }

    @GetMapping("/washingmachines/{id}")
    public WashingMachine getById(@PathVariable int id) {
        return washingMachineService.getById(id);
    }

    @PutMapping("/washingmachines/{id}")
    public WashingMachine update(@PathVariable int id, @RequestBody WashingMachine washingMachine){
        washingMachineService.update(id, washingMachine);
        return washingMachine;
    }

    @DeleteMapping("/washingmachines/{id}")
    public void delete(@PathVariable int id){
        washingMachineService.delete(id);
    }
}
