package com.tamla.taxi24.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A Trip.
 */
@Entity
@Table(name = "trips")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Trip implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trip_id")
    private Long id;

    @Column(name = "latitude_start")
    private Float latitudeStart;

    @Column(name = "longitude_start")
    private Float longitudeStart;

    @Column(name = "requested_at")
    private Instant requestedAt;

    @Column(name = "assigned_at")
    private Instant assignedAt;

    @Column(name = "started_at")
    private Instant startedAt;

    @Column(name = "completed_at")
    private Instant completedAt;

    @Column(name = "km_distance_covered")
    private Float kmDistanceCovered;

    @ManyToOne
    @JsonIgnoreProperties("tripDrivers")
    private Driver driver;

    @ManyToOne
    @JsonIgnoreProperties("tripRiders")
    private Rider rider;

    @ManyToOne
    @JsonIgnoreProperties("tripStatuses")
    private TripStatus tripStatus;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getLatitudeStart() {
        return latitudeStart;
    }

    public Trip latitudeStart(Float latitudeStart) {
        this.latitudeStart = latitudeStart;
        return this;
    }

    public void setLatitudeStart(Float latitudeStart) {
        this.latitudeStart = latitudeStart;
    }

    public Float getLongitudeStart() {
        return longitudeStart;
    }

    public Trip longitudeStart(Float longitudeStart) {
        this.longitudeStart = longitudeStart;
        return this;
    }

    public void setLongitudeStart(Float longitudeStart) {
        this.longitudeStart = longitudeStart;
    }

    public Instant getRequestedAt() {
        return requestedAt;
    }

    public Trip requestedAt(Instant requestedAt) {
        this.requestedAt = requestedAt;
        return this;
    }

    public void setRequestedAt(Instant requestedAt) {
        this.requestedAt = requestedAt;
    }

    public Instant getAssignedAt() {
        return assignedAt;
    }

    public Trip assignedAt(Instant assignedAt) {
        this.assignedAt = assignedAt;
        return this;
    }

    public void setAssignedAt(Instant assignedAt) {
        this.assignedAt = assignedAt;
    }

    public Instant getStartedAt() {
        return startedAt;
    }

    public Trip startedAt(Instant startedAt) {
        this.startedAt = startedAt;
        return this;
    }

    public void setStartedAt(Instant startedAt) {
        this.startedAt = startedAt;
    }

    public Instant getCompletedAt() {
        return completedAt;
    }

    public Trip completedAt(Instant completedAt) {
        this.completedAt = completedAt;
        return this;
    }

    public void setCompletedAt(Instant completedAt) {
        this.completedAt = completedAt;
    }

    public Float getKmDistanceCovered() {
        return kmDistanceCovered;
    }

    public Trip kmDistanceCovered(Float kmDistanceCovered) {
        this.kmDistanceCovered = kmDistanceCovered;
        return this;
    }

    public void setKmDistanceCovered(Float kmDistanceCovered) {
        this.kmDistanceCovered = kmDistanceCovered;
    }

    public Driver getDriver() {
        return driver;
    }

    public Trip driver(Driver driver) {
        this.driver = driver;
        return this;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Rider getRider() {
        return rider;
    }

    public Trip rider(Rider rider) {
        this.rider = rider;
        return this;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public Trip tripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
        return this;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
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
        Trip trip = (Trip) o;
        if (trip.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), trip.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Trip{" +
            "id=" + getId() +
            ", latitudeStart=" + getLatitudeStart() +
            ", longitudeStart=" + getLongitudeStart() +
            ", requestedAt='" + getRequestedAt() + "'" +
            ", assignedAt='" + getAssignedAt() + "'" +
            ", startedAt='" + getStartedAt() + "'" +
            ", completedAt='" + getCompletedAt() + "'" +
            ", kmDistanceCovered=" + getKmDistanceCovered() +
            "}";
    }
}
