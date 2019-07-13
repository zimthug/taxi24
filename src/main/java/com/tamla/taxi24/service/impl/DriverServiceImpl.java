package com.tamla.taxi24.service.impl;

import com.tamla.taxi24.model.Driver;
import com.tamla.taxi24.repository.DriverRepository;
import com.tamla.taxi24.service.DriverService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    private DriverRepository driverRepository;

    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public List<Driver> list() {
        return driverRepository.findAll();
    }
}
