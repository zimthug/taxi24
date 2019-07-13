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
 * A DriverStatus.
 */
@Entity
@Table(name = "driver_status")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class DriverStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "driver_status_id")
    private Long id;

    @Column(name = "status_desc")
    private String statusDesc;

    @OneToMany(mappedBy = "driverStatus")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Driver> driverStatuses = new HashSet<>();
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public DriverStatus statusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
        return this;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public Set<Driver> getDriverStatuses() {
        return driverStatuses;
    }

    public DriverStatus driverStatuses(Set<Driver> drivers) {
        this.driverStatuses = drivers;
        return this;
    }

    public DriverStatus addDriverStatus(Driver driver) {
        this.driverStatuses.add(driver);
        driver.setDriverStatus(this);
        return this;
    }

    public DriverStatus removeDriverStatus(Driver driver) {
        this.driverStatuses.remove(driver);
        driver.setDriverStatus(null);
        return this;
    }

    public void setDriverStatuses(Set<Driver> drivers) {
        this.driverStatuses = drivers;
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
        DriverStatus driverStatus = (DriverStatus) o;
        if (driverStatus.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), driverStatus.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DriverStatus{" +
            "id=" + getId() +
            ", statusDesc='" + getStatusDesc() + "'" +
            "}";
    }
}
