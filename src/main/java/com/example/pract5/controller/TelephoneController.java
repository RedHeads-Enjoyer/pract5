package com.example.pract5.controller;


import com.example.pract5.entity.Telephone;
import com.example.pract5.service.TelephoneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;;

@RestController
@RequestMapping("/api")
public class TelephoneController {
    TelephoneService telephoneService;

    @PostMapping("/telephones")
    public int create(@RequestBody Telephone telephone) {
        telephoneService.save(telephone);
        return telephone.getId();
    }

    @GetMapping("/telephones")
    public List<Telephone> getAll() {
        return telephoneService.getAll();
    }

    @GetMapping("/telephones/{id}")
    public Telephone getById(@PathVariable int id) {
        return telephoneService.getById(id);
    }

    @PutMapping("/telephones/{id}")
    public Telephone update(@PathVariable int id, @RequestBody Telephone telephone){
        telephoneService.update(id, telephone);
        return telephone;
    }

    @DeleteMapping("/telephones/{id}")
    public void delete(@PathVariable int id){
        telephoneService.delete(id);
    }
}
