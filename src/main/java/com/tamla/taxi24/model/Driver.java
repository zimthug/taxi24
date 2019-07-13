package com.tamla.taxi24.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Driver.
 */
@Entity
@Table(name = "drivers")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "driver_id")
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "surname")
    private String surname;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "email")
    private String email;

    @Column(name = "driver_photo")
    private String driverPhoto;

    @Column(name = "completed_trips")
    private Integer completedTrips;

    @Column(name = "kms_done")
    private Integer kmsDone;

    @Column(name = "latitude")
    private Float latitude;

    @Column(name = "longitude")
    private Float longitude;

    @ManyToOne
    @JsonIgnoreProperties("driverStatuses")
    private DriverStatus driverStatus;

    @OneToMany(mappedBy = "driver")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Trip> tripDrivers = new HashSet<>();
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public Driver firstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public Driver surname(String surname) {
        this.surname = surname;
        return this;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public Driver mobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public Driver email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDriverPhoto() {
        return driverPhoto;
    }

    public Driver driverPhoto(String driverPhoto) {
        this.driverPhoto = driverPhoto;
        return this;
    }

    public void setDriverPhoto(String driverPhoto) {
        this.driverPhoto = driverPhoto;
    }

    public Integer getCompletedTrips() {
        return completedTrips;
    }

    public Driver completedTrips(Integer completedTrips) {
        this.completedTrips = completedTrips;
        return this;
    }

    public void setCompletedTrips(Integer completedTrips) {
        this.completedTrips = completedTrips;
    }

    public Integer getKmsDone() {
        return kmsDone;
    }

    public Driver kmsDone(Integer kmsDone) {
        this.kmsDone = kmsDone;
        return this;
    }

    public void setKmsDone(Integer kmsDone) {
        this.kmsDone = kmsDone;
    }

    public Float getLatitude() {
        return latitude;
    }

    public Driver latitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public Driver longitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public Driver driverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
        return this;
    }

    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }

    public Set<Trip> getTripDrivers() {
        return tripDrivers;
    }

    public Driver tripDrivers(Set<Trip> trips) {
        this.tripDrivers = trips;
        return this;
    }

    public Driver addTripDriver(Trip trip) {
        this.tripDrivers.add(trip);
        trip.setDriver(this);
        return this;
    }

    public Driver removeTripDriver(Trip trip) {
        this.tripDrivers.remove(trip);
        trip.setDriver(null);
        return this;
    }

    public void setTripDrivers(Set<Trip> trips) {
        this.tripDrivers = trips;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Driver driver = (Driver) o;
        if (driver.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), driver.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Driver{" +
            "id=" + getId() +
            ", firstname='" + getFirstname() + "'" +
            ", surname='" + getSurname() + "'" +
            ", mobileNo='" + getMobileNo() + "'" +
            ", email='" + getEmail() + "'" +
            ", driverPhoto='" + getDriverPhoto() + "'" +
            ", completedTrips=" + getCompletedTrips() +
            ", kmsDone=" + getKmsDone() +
            ", latitude=" + getLatitude() +
            ", longitude=" + getLongitude() +
            "}";
    }
}
