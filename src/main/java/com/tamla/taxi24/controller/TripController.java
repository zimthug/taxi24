package com.tamla.taxi24.controller;

import com.tamla.taxi24.model.Trip;
import com.tamla.taxi24.model.dto.Invoice;
import com.tamla.taxi24.model.dto.TripRequest;
import com.tamla.taxi24.service.TripService;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Post data to request and start a trip.
     * TODO: The requirement was not very clear so I made assumption that request = start of trip
     *
     * @param tripRequest this is a JSON object. The following 3 objects are necessary
     *                    riderId:
     *                    startLongitude:
     *                    startLatitude:
     * @return
     */
    @PostMapping(value = { "/trip/request"}, consumes = "application/json")
    public Trip create(@RequestBody TripRequest tripRequest){
        return this.tripService.create(tripRequest);
    }


    @PostMapping(value = { "/trip/complete"}, consumes = "application/json")
    public Invoice finishTrip(@RequestBody TripRequest tripRequest){
        return this.tripService.finishTrip(tripRequest);
    }


    @GetMapping(value = { "/trips/status/{tripStatus}"})
    public List<Trip> findByStatus(@PathVariable String tripStatus){
        return this.tripService.findAllByTripStatus(tripStatus);
    }
}
