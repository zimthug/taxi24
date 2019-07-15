package com.tamla.taxi24.service;

import com.tamla.taxi24.model.Driver;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface DriverService {

    List<Driver> list();

    List<Driver> listDriversByStatus(String driverStatus);

    Driver findDriverById(Long driverId);

    List<Driver> findDriversNear(double longitude, double latitude, Integer radius);
}
