package com.tamla.taxi24.service.impl;

import com.tamla.taxi24.model.Driver;
import com.tamla.taxi24.model.Rider;
import com.tamla.taxi24.model.Trip;
import com.tamla.taxi24.model.dto.Invoice;
import com.tamla.taxi24.model.dto.InvoiceDriver;
import com.tamla.taxi24.model.dto.TripRequest;
import com.tamla.taxi24.model.enumeration.DriverStatusEnum;
import com.tamla.taxi24.model.enumeration.TripStatusEnum;
import com.tamla.taxi24.repository.DriverRepository;
import com.tamla.taxi24.repository.RiderRepository;
import com.tamla.taxi24.repository.TripRepository;
import com.tamla.taxi24.service.TripService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TripServiceImpl implements TripService {

    private TripRepository tripRepository;
    private DriverRepository driverRepository;
    private RiderRepository riderRepository;

    public TripServiceImpl(TripRepository tripRepository, DriverRepository driverRepository, RiderRepository riderRepository) {
        this.tripRepository = tripRepository;
        this.driverRepository = driverRepository;
        this.riderRepository = riderRepository;
    }

    @Override
    public List<Trip> list() {
        return tripRepository.findAll();
    }

    @Override
    public Trip create(TripRequest tripRequest) {
        double startLatitude = tripRequest.getStartLatitude();
        double startLongitude = tripRequest.getStartLongitude();
        Driver driver = this.driverRepository.findNearestAvailableDriver(startLongitude, startLatitude);
        Rider rider = this.riderRepository.findRiderByRiderId(tripRequest.getRiderId());
        Trip trip = new Trip();
        trip.setRiderId(rider);
        trip.setDriverId(driver);
        trip.setAssignedAt(new Date());
        trip.setLongitudeStart(startLongitude);
        trip.setLatitudeStart(startLatitude);
        trip.setRequestedAt(new Date());
        trip.setStartedAt(new Date());
        trip.setTripStatus(TripStatusEnum.ON_TRIP);
        driver.setDriverStatus(DriverStatusEnum.ON_TRIP);
        this.driverRepository.save(driver);
        return this.tripRepository.save(trip);
        //return trip;
    }

    @Override
    public Invoice finishTrip(TripRequest tripRequest) {
        Trip trip = this.tripRepository.findById(tripRequest.getTripId()).orElse(null);
        if(trip==null){
            return null;
        }

        Integer distanceCovered = this.tripRepository.findDistanceCovered(tripRequest.getTripId(), tripRequest.getFinishLongitude(), tripRequest.getFinishLatitude());

        trip.setCompletedAt(new Date());
        trip.setTripStatus(TripStatusEnum.COMPLETED);
        trip.setLongitudeFinish(tripRequest.getFinishLongitude());
        trip.setLatitudeFinish(tripRequest.getFinishLatitude());
        trip.setKmDistanceCovered(distanceCovered);

        Driver driver = this.driverRepository.findById(trip.getDriverId().getDriverId()).orElse(null);
        driver.setCompletedTrips(driver.getCompletedTrips() + distanceCovered);
        driver.setDriverStatus(DriverStatusEnum.AVAILABLE);
        this.driverRepository.save(driver);
        this.tripRepository.save(trip);

        //Now make the invoice
        Invoice invoice = new Invoice();
        InvoiceDriver invoiceDriver = new InvoiceDriver();
        invoiceDriver.setDriverId(driver.getDriverId());
        invoiceDriver.setSurname(driver.getSurname());
        invoiceDriver.setFirstname(driver.getFirstname());
        invoiceDriver.setEmail(driver.getEmail());
        invoiceDriver.setMobileNo(driver.getMobileNo());
        invoice.setInvoiceDriver(invoiceDriver);
        invoice.setCompletedAt(trip.getCompletedAt());
        invoice.setDistanceCovered(trip.getKmDistanceCovered());
        invoice.setPricePerKm(100.0);
        invoice.setRider(trip.getRiderId());
        invoice.setTotalAmount(100 * trip.getKmDistanceCovered());
        invoice.setTripId(trip.getTripId());
        return invoice;
    }

    @Override
    public List<Trip> findAllByTripStatus(String tripStatus) {
        return this.tripRepository.findAllByTripStatus(TripStatusEnum.valueOf(tripStatus));
    }


}
