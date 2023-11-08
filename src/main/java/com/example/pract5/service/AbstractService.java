package com.example.pract5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class AbstractService<E, R extends JpaRepository<E, Integer>> {


    private final R r;

    @Autowired
    public AbstractService(R r) {
        this.r=r;
    }
    @GetMapping
    public List<E> getAll() {
        List<E> es = new ArrayList<E>();
        r.findAll().forEach(e -> es.add(e));
        return es;
    }

    @GetMapping("/{id}")
    public E getById(@PathVariable int id) {
        return r.findById(id).get();
    }
    @PostMapping
    public void save(@RequestBody E e) {
        r.save(e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        r.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody E e) {
        r.deleteById(id);
        r.save(e);
    }
}
