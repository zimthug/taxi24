package com.tamla.taxi24.repository;

import com.tamla.taxi24.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    List<Driver> findAllByDriverStatus(String driverStatus);
}
