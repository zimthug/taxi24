package com.tamla.taxi24.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class InvoiceDriver implements Serializable {
    private Long driverId;
    private String firstname;
    private String surname;
    private String email;
    private String mobileNo;
}
