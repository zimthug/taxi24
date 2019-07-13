package com.tamla.taxi24.service;

import com.tamla.taxi24.model.Driver;
import org.springframework.stereotype.Service;


public interface DriverService {

    Iterable<Driver> list();
}
