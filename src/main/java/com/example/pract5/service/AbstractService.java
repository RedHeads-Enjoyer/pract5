package com.example.pract5.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public class AbstractService<E, R extends JpaRepository<E, Integer>> {

    private final R r;

    public AbstractService(R r) {
        this.r=r;
    }

    public List<E> getAll() {
        List<E> es = new ArrayList<E>();
        r.findAll().forEach(e -> es.add(e));
        return es;
    }

    public E getById(int id) {
        return r.findById(id).get();
    }

    public void save(E e) {
        r.save(e);
    }

    public void delete(int id) {
        r.deleteById(id);
    }

    public void update(int id, E e) {
        r.deleteById(id);
        r.save(e);
    }
}
