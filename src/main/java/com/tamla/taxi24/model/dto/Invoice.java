package com.tamla.taxi24.model.dto;

import com.tamla.taxi24.model.Rider;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Invoice implements Serializable {
    private Long tripId;
    private Rider rider;
    private InvoiceDriver invoiceDriver;
    private double distanceCovered;
    private double pricePerKm;
    private double totalAmount;
    private Date completedAt;
}



