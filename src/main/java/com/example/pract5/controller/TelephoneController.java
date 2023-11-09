package com.example.pract5.controller;

import com.example.pract5.entity.Telephone;
import com.example.pract5.exception.ResourceNotFoundException;
import com.example.pract5.service.TelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TelephoneController {
    @Autowired
    TelephoneService telephoneService;


    @PostMapping("/telephones")
    public Telephone create(@RequestBody Telephone telephone) {
        return telephoneService.save(telephone);
    }


    @GetMapping("/telephones")
    public List<Telephone> getAll() {
        return telephoneService.getAll();
    }

    @GetMapping("/telephones/{id}")
    public ResponseEntity<Telephone> getById(@PathVariable int id) throws ResourceNotFoundException {
        return telephoneService.getById(id);
    }

    @PutMapping("/telephones/{id}")
    public Telephone update(@PathVariable int id, @RequestBody Telephone telephone) throws ResourceNotFoundException {
        telephoneService.update(id, telephone);
        return telephone;
    }

    @DeleteMapping("/telephones/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable int id) throws ResourceNotFoundException {
        return telephoneService.delete(id);
    }
}
