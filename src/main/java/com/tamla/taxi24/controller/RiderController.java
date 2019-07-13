package com.tamla.taxi24.controller;

import com.tamla.taxi24.model.Rider;
import com.tamla.taxi24.service.RiderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RiderController {

    private RiderService riderService;

    public RiderController(RiderService riderService) {
        this.riderService = riderService;
    }

    @GetMapping(value = { "/riders"})
    public List<Rider> list(){
        return this.riderService.list();
    }
}
