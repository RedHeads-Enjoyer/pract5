package com.example.pract5.service;

import com.example.pract5.entity.Telephone;
import com.example.pract5.repository.TelephoneRepository;

public class TelephoneService extends AbstractService<Telephone, TelephoneRepository> {
    public TelephoneService(TelephoneRepository telephoneRepository) {
        super(telephoneRepository);
    }
}
