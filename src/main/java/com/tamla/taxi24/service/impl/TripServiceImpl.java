package com.tamla.taxi24.service.impl;

import com.tamla.taxi24.model.Trip;
import com.tamla.taxi24.repository.TripRepository;
import com.tamla.taxi24.service.TripService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    private TripRepository tripRepository;

    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public List<Trip> list() {
        return tripRepository.findAll();
    }
}
