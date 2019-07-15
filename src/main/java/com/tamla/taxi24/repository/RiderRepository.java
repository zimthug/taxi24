package com.tamla.taxi24.repository;

import com.tamla.taxi24.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiderRepository extends JpaRepository<Rider, Long> {

    Rider findRiderByRiderId(Long riderId);
}
