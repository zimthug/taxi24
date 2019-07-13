package com.tamla.taxi24.controller;

import com.tamla.taxi24.model.Driver;
import com.tamla.taxi24.service.DriverService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/driver")
public class DriverController {

    private DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }


    @GetMapping(value = {"", "/"})
    public Iterable<Driver> list() {
        return this.driverService.list();
    }
}
