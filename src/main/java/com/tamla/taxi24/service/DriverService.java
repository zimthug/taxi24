package com.tamla.taxi24.service;

import com.tamla.taxi24.model.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverService {

    List<Driver> list();

    List<Driver> listDriversByStatus(String driverStatus);

    Optional<Driver> findDriverById(Long driverId);
}
