package com.tamla.taxi24.controller;

import com.tamla.taxi24.model.Trip;
import com.tamla.taxi24.service.TripService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TripController {

    private TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping(value = { "/trips"})
    public List<Trip> list(){
        return this.tripService.list();
    }



}
