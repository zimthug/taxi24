/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tamla.taxi24.model;

import com.tamla.taxi24.model.enumeration.TripStatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mlangeni
 */
@Data
@Entity
@Table(name = "trips")
public class Trip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trip_id")
    private Long tripId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitude_start")
    private double latitudeStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitude_start")
    private double longitudeStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "requested_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestedAt;
    @Column(name = "assigned_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assignedAt;
    @Column(name = "started_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startedAt;
    @Column(name = "completed_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date completedAt;
    @Column(name = "km_distance_covered")
    private Integer kmDistanceCovered;
    @Basic(optional = false)
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private TripStatusEnum tripStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitude_finish")
    private double latitudeFinish;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitude_finish")
    private double longitudeFinish;
    @JoinColumn(name = "driver_id", referencedColumnName = "driver_id")
    @ManyToOne
    private Driver driverId;
    @JoinColumn(name = "rider_id", referencedColumnName = "rider_id")
    @ManyToOne(optional = false)
    private Rider riderId;


}
