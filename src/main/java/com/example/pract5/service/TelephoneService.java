package com.example.pract5.service;


import com.example.pract5.entity.Telephone;
import com.example.pract5.exception.ResourceNotFoundException;
import com.example.pract5.repository.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TelephoneService {
    @Autowired
    TelephoneRepository telephoneRepository;

    public List<Telephone> getAll() {
        return telephoneRepository.findAll();
    }

    public ResponseEntity<Telephone> getById(@PathVariable int id) {
        Telephone telephone = telephoneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Telephone not exist with id :" + id));
        return ResponseEntity.ok(telephone);
    }
    public Telephone save(@RequestBody Telephone telephone) {
        return telephoneRepository.save(telephone);
    }

    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable int id) {
        Telephone telephone = telephoneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Telephone not exist with id :" + id));

        telephoneRepository.delete(telephone);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<Telephone> update(@PathVariable int id, @RequestBody Telephone newTelephone) throws ResourceNotFoundException {
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
}
