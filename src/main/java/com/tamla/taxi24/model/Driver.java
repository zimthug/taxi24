/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tamla.taxi24.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "driver_id")
    private Integer driverId;
    @Size(max = 60)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = 60)
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "mobile_no")
    private String mobileNo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
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
    private BigDecimal latitude;
    @Column(name = "longitude")
    private BigDecimal longitude;
    @JsonIgnore
    @OneToMany(mappedBy = "driver")
    private List<Trip> tripList;
    //@JsonIgnoreProperties("driverStatusDriver")
    @JoinColumn(name = "driver_status_id", referencedColumnName = "driver_status_id")
    @ManyToOne(optional = false)
    private DriverStatus driverStatus;

    public Driver() {
    }

    public Driver(Integer driverId) {
        this.driverId = driverId;
    }

    public Driver(Integer driverId, String mobileNo, String email, int completedTrips, int kmsDone) {
        this.driverId = driverId;
        this.mobileNo = mobileNo;
        this.email = email;
        this.completedTrips = completedTrips;
        this.kmsDone = kmsDone;
    }
}
