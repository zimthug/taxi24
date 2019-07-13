package com.tamla.taxi24.controller;

import com.tamla.taxi24.model.Driver;
import com.tamla.taxi24.service.DriverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DriverController {

    private DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping(value = { "/drivers"})
    public List<Driver> list() {
        return this.driverService.list();
    }

    @GetMapping(value = { "/drivers/status/{status}"})
    public List<Driver> listDriversByStatus(@PathVariable String status) {
        return this.driverService.listDriversByStatus(status);
    }

    @GetMapping(value = { "/driver/{driverId}"})
    public ResponseEntity<Driver> findDriverById(@PathVariable Long driverId) {
        Optional<Driver> driver = this.driverService.findDriverById(driverId);
        return ResponseEntity.of(driver);
    }
}
