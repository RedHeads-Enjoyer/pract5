package com.example.pract5.controller;

import com.example.pract5.entity.WashingMachine;
import com.example.pract5.exception.ResourceNotFoundException;
import com.example.pract5.repository.WashingMachineRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class WashingMachineController {
    private WashingMachineRepository washingMachineRepository;
    @GetMapping("/washingmachines")
    public List<WashingMachine> getAll() {
        return washingMachineRepository.findAll();
    }

    @PostMapping("/washingmachines")
    public WashingMachine createWashingMachine(@RequestBody WashingMachine washingMachine) {
        return washingMachineRepository.save(washingMachine);
    }

    @GetMapping("/washingmachines/{id}")
    public ResponseEntity<WashingMachine> getWashingMachineById(@PathVariable int id) {
        WashingMachine washingMachine = washingMachineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Washing machine not exist with id :" + id));
        return ResponseEntity.ok(washingMachine);
    }

    @PutMapping("/washingmachines/{id}")
    public ResponseEntity<WashingMachine> updateWashingMachine(@PathVariable int id, @RequestBody WashingMachine newWashingMachine){
        WashingMachine washingMachine = washingMachineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Washing machine not exist with id :" + id));

        washingMachine.setCompany(newWashingMachine.getCompany());
        washingMachine.setPrice(newWashingMachine.getPrice());
        washingMachine.setSeller_id(newWashingMachine.getSeller_id());
        washingMachine.setTitle(newWashingMachine.getTitle());

        WashingMachine updatedWashingMachine = washingMachineRepository.save(washingMachine);
        return ResponseEntity.ok(updatedWashingMachine);
    }

    @DeleteMapping("/washingmachines/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteWashingMachine(@PathVariable int id){
        WashingMachine washingMachine = washingMachineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Washing machine not exist with id :" + id));

        washingMachineRepository.delete(washingMachine);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
