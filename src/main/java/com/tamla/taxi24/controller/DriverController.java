package com.tamla.taxi24.controller;

import com.tamla.taxi24.model.Driver;
import com.tamla.taxi24.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DriverController {

    private DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    /**
     * Get a list of all the drivers.
     * To access the URL GET <b>http://yourserver/api/drivers</b>
     * @return JSON list of all drivers
     */
    @GetMapping(value = { "/drivers"})
    public List<Driver> list() {
        return this.driverService.list();
    }

    /**
     * Get a list of all the drivers with status specified.
     * To access the URL GET <b>http://yourserver/api/drivers/status/[status]</b>
     * @param driverStatusId {Valid statuses are AVAILABLE, OFF_DUTY, ON_TRIP, ASSIGNED}
     * @return JSON list of all drivers with the current status
     */
    @GetMapping(value = { "/drivers/status/{driverStatusId}"})
    public List<Driver> listDriversByStatus(@PathVariable String driverStatusId) {
        return this.driverService.listDriversByStatus(driverStatusId);
    }

    /**
     * Get a driver by their ID
     * To access the URL GET <b>http://yourserver/api/driver/[ID]</b>
     * @param driverId
     * @return JSON with the driver details or status 404 if not found
     */
    @GetMapping(value = { "/driver/{driverId}"})
    public ResponseEntity<Driver> findDriverById(@PathVariable Long driverId) {
        Driver driver = this.driverService.findDriverById(driverId);
        if(driver!=null){
            return ResponseEntity.ok(driver);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Get driver within the specified radius.
     * To access the URL GET <b>http://yourserver/api/driversnear?longitude={longitude}&latitude={latitude}&radius={radius}</b>
     * @param longitude search center longitude
     * @param latitude search center latitude
     * @param radius radius in which the drivers locations will lay
     * @return
     */
    @GetMapping(value = "/driversnear") //{"/availabledriver?longitude={longitude}&latitude={latitude}&radius={radius}"})
    public List<Driver> findDriverNear(@RequestParam double longitude, @RequestParam double latitude, @RequestParam Integer radius) {
        return this.driverService.findDriversNear(longitude, latitude, radius);
    }
}
