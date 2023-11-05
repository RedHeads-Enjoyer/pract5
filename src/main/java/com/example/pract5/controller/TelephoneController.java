package com.example.pract5.controller;


import com.example.pract5.entity.Telephone;
import com.example.pract5.exception.ResourceNotFoundException;
import com.example.pract5.repository.TelephoneRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TelephoneController {
    private TelephoneRepository telephoneRepository;
    @GetMapping("/telephones")
    public List<Telephone> getAll() {
        return telephoneRepository.findAll();
    }

    @PostMapping("/telephones")
    public Telephone createTelephone(@RequestBody Telephone telephone) {
        return telephoneRepository.save(telephone);
    }

    @GetMapping("/telephones/{id}")
    public ResponseEntity<Telephone> getTelephoneById(@PathVariable int id) {
        Telephone telephone = telephoneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Telephone not exist with id :" + id));
        return ResponseEntity.ok(telephone);
    }

    @PutMapping("/telephones/{id}")
    public ResponseEntity<Telephone> updateTelephone(@PathVariable int id, @RequestBody Telephone newTelephone){
        Telephone telephone = telephoneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Telephone not exist with id :" + id));

        telephone.setBatterySize(newTelephone.getBatterySize());
        telephone.setCompany(newTelephone.getCompany());
        telephone.setPrice(newTelephone.getPrice());
        telephone.setSeller_id(newTelephone.getSeller_id());
        telephone.setTitle(newTelephone.getTitle());

        Telephone updatedTelephone = telephoneRepository.save(telephone);
        return ResponseEntity.ok(updatedTelephone);
    }

    @DeleteMapping("/telephones/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteTelephone(@PathVariable int id){
        Telephone telephone = telephoneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Telephone not exist with id :" + id));

        telephoneRepository.delete(telephone);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
