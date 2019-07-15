package com.tamla.taxi24.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class TripRequest implements Serializable {
    private Long tripId;
    private Long riderId;
    private double startLongitude;
    private double startLatitude;
    private double finishLongitude;
    private double finishLatitude;
    private Long driverId;

}
