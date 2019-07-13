package com.tamla.taxi24.repository;

import com.tamla.taxi24.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
}
