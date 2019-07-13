package com.tamla.taxi24.service.impl;

import com.tamla.taxi24.model.Driver;
import com.tamla.taxi24.repository.DriverRepository;
import com.tamla.taxi24.service.DriverService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Driver> listDriversByStatus(String driverStatus) {
        return driverRepository.findAllByDriverStatus(driverStatus);
    }

    @Override
    public Optional<Driver> findDriverById(Long driverId) {
        return driverRepository.findById(driverId);
    }


}
