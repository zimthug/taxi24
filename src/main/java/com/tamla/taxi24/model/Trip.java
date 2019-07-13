/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tamla.taxi24.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
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
    private Integer tripId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitude_start")
    private BigDecimal latitudeStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitude_start")
    private BigDecimal longitudeStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "requested_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestedAt;
    @Column(name = "assigned_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assignedAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "started_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startedAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "completed_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date completedAt;
    @Column(name = "km_distance_covered")
    private BigDecimal kmDistanceCovered;
    @JoinColumn(name = "driver_id", referencedColumnName = "driver_id")
    @ManyToOne
    private Driver driver;
    @JoinColumn(name = "rider_id", referencedColumnName = "rider_id")
    @ManyToOne(optional = false)
    private Rider riderId;
    @JoinColumn(name = "trip_status_id", referencedColumnName = "trip_status_id")
    @ManyToOne(optional = false)
    private TripStatus tripStatusId;

    public Trip() {
    }

    public Trip(Integer tripId) {
        this.tripId = tripId;
    }


}
