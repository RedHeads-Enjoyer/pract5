package com.example.pract5.repository;

import com.example.pract5.entity.WashingMachine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WashingMachineRepository extends JpaRepository<WashingMachine, Integer> {}