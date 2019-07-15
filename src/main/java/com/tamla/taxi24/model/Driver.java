/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tamla.taxi24.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tamla.taxi24.model.enumeration.DriverStatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mlangeni
 */
@Data
@Entity
@Table(name = "drivers")
public class Driver extends AbstractPerson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "driver_id")
    private Long driverId;
    @Size(max = 255)
    @Column(name = "driver_photo")
    private String driverPhoto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "completed_trips")
    private int completedTrips;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kms_done")
    private int kmsDone;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;
    @Basic(optional = false)
    @NotNull
    //@JoinColumn(name = "driver_status", referencedColumnName = "driver_status_id")
    //@ManyToOne
    @Enumerated(value = EnumType.STRING)
    private DriverStatusEnum driverStatus;
    @JsonIgnore
    @OneToMany(mappedBy = "driverId")
    private List<Trip> tripList;


}
