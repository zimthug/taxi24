package com.tamla.taxi24.service;

import com.tamla.taxi24.model.Trip;
import com.tamla.taxi24.model.dto.Invoice;
import com.tamla.taxi24.model.dto.TripRequest;

import java.util.List;

public interface TripService {

    List<Trip> list();

    Trip create(TripRequest tripRequest);

    Invoice finishTrip(TripRequest tripRequest);

    List<Trip> findAllByTripStatus(String tripStatus);
}
