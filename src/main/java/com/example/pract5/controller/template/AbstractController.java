package com.example.pract5.controller.template;

import com.example.pract5.entity.template.AbstractEntity;
import com.example.pract5.exception.NotFoundException;
import com.example.pract5.service.template.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class AbstractController<E extends AbstractEntity<F>, S extends CommonService<E,F>, F> implements CommonController<E,F>{

    private final S service;

    @Autowired
    public AbstractController(S service) {
        this.service = service;
    }

    @Override
    public ResponseEntity getAll() {
        List list = service.getAll();
        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity getOne(Long id) {
        try{
            return ResponseEntity.ok(service.getOne(id));
        } catch (NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @Override
    public ResponseEntity<String> deleteOne(Long id) {
        try {
            service.deleteOne(id);
            return ResponseEntity.ok("Удалено!");
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @Override
    public ResponseEntity updateOne(Long id, F form) {
        try{
            service.updateOne(id, form);
            return  ResponseEntity.ok(form);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @Override
    public ResponseEntity<String> createOne(F form) {
        try {
            service.createOne(form);
            return ResponseEntity.ok().body("Успешно создано!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
