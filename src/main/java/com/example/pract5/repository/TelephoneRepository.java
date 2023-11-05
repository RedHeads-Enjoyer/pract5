package com.example.pract5.repository;

import com.example.pract5.entity.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelephoneRepository extends JpaRepository<Telephone, Integer> {}