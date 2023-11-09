package com.example.pract5.service;

import com.example.pract5.entity.Client;
import com.example.pract5.entity.WashingMachine;
import com.example.pract5.exception.ResourceNotFoundException;
import com.example.pract5.repository.ClientRepository;
import com.example.pract5.repository.WashingMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WashingMachineService {
    @Autowired
    WashingMachineRepository washingMachineRepository;

    public List<WashingMachine> getAll() {
        return washingMachineRepository.findAll();
    }

    public ResponseEntity<WashingMachine> getById(@PathVariable int id) {
        WashingMachine washingMachine = washingMachineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Washing machine not exist with id :" + id));
        return ResponseEntity.ok(washingMachine);
    }
    public WashingMachine save(@RequestBody WashingMachine washingMachine) {
        return washingMachineRepository.save(washingMachine);
    }

    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable int id) {
        WashingMachine washingMachine = washingMachineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Washing machine not exist with id :" + id));

        washingMachineRepository.delete(washingMachine);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<WashingMachine> update(@PathVariable int id, @RequestBody WashingMachine newWashingMachine) throws ResourceNotFoundException {
        WashingMachine washingMachine = washingMachineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Washing machine not exist with id :" + id));

        washingMachine.setCompany(newWashingMachine.getCompany());
        washingMachine.setPrice(newWashingMachine.getPrice());
        washingMachine.setSeller_id(newWashingMachine.getSeller_id());
        washingMachine.setTitle(newWashingMachine.getTitle());

        WashingMachine updatedWashingMachine = washingMachineRepository.save(washingMachine);
        return ResponseEntity.ok(updatedWashingMachine);
    }
}
