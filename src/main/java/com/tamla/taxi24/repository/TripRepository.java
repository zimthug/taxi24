package com.tamla.taxi24.repository;

import com.tamla.taxi24.model.Trip;
import com.tamla.taxi24.model.enumeration.TripStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TripRepository extends JpaRepository<Trip, Long> {

    @Query(value = "SELECT round(distance) / 1000 as distance FROM (\n" +
            "SELECT *,(((acos(sin((:latitude*pi()/180)) * sin((dest.latitude_start*pi()/180))+cos((:latitude*pi()/180))*cos((dest.latitude_start*pi()/180))*\n" +
            "cos(((:longitude-dest.longitude_start)*pi()/180))))*180/pi())*60*1.1515*1609.344) as distance \n" +
            "FROM trips AS dest WHERE trip_id =  :tripId)  tab\n", nativeQuery=true)
    Integer findDistanceCovered(@Param("tripId") Long tripId, @Param("longitude") double longitude, @Param("latitude") double latitude);

    List<Trip> findAllByTripStatus(TripStatusEnum tripStatus);
}
