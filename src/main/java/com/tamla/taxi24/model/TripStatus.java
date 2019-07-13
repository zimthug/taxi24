package com.tamla.taxi24.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A TripStatus.
 */
@Entity
@Table(name = "trip_status")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TripStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trip_status_id")
    private Long id;

    @Column(name = "trip_status")
    private String tripStatus;

    @OneToMany(mappedBy = "tripStatus")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Trip> tripStatuses = new HashSet<>();
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTripStatus() {
        return tripStatus;
    }

    public TripStatus tripStatus(String tripStatus) {
        this.tripStatus = tripStatus;
        return this;
    }

    public void setTripStatus(String tripStatus) {
        this.tripStatus = tripStatus;
    }

    public Set<Trip> getTripStatuses() {
        return tripStatuses;
    }

    public TripStatus tripStatuses(Set<Trip> trips) {
        this.tripStatuses = trips;
        return this;
    }

    public TripStatus addTripStatus(Trip trip) {
        this.tripStatuses.add(trip);
        trip.setTripStatus(this);
        return this;
    }

    public TripStatus removeTripStatus(Trip trip) {
        this.tripStatuses.remove(trip);
        trip.setTripStatus(null);
        return this;
    }

    public void setTripStatuses(Set<Trip> trips) {
        this.tripStatuses = trips;
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
        TripStatus tripStatus = (TripStatus) o;
        if (tripStatus.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tripStatus.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TripStatus{" +
            "id=" + getId() +
            ", tripStatus='" + getTripStatus() + "'" +
            "}";
    }
}
