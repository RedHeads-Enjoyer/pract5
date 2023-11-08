package com.example.pract5.service;

import com.example.pract5.entity.WashingMachine;
import com.example.pract5.repository.WashingMachineRepository;

public class WashingMachineService  extends AbstractService<WashingMachine, WashingMachineRepository> {
    public WashingMachineService(WashingMachineRepository washingMachineRepository) {
        super(washingMachineRepository);
    }
}
