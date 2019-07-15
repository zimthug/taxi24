package com.tamla.taxi24.repository;

import com.tamla.taxi24.model.Driver;
import com.tamla.taxi24.model.enumeration.DriverStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    List<Driver> findAllByDriverStatus(DriverStatusEnum driverStatus);

    @Query(value = "SELECT * FROM (\n" +
            "SELECT *,(((acos(sin((:latitude*pi()/180)) * sin((dest.latitude*pi()/180))+cos((:latitude*pi()/180))*cos((dest.latitude*pi()/180))*\n" +
            "cos(((:longitude-dest.longitude)*pi()/180))))*180/pi())*60*1.1515*1609.344) as distance \n" +
            "FROM drivers AS dest ) tab\n" +
            "WHERE distance < :radius * 1000 ORDER BY distance", nativeQuery=true)
    List<Driver> findDriversNear(@Param("longitude") double longitude, @Param("latitude") double latitude, @Param("radius") Integer radius);

    //List<Driver> findAllByDriverStatus()

    @Query(value = "SELECT * FROM (\n" +
            "SELECT *,(((acos(sin((:latitude*pi()/180)) * sin((dest.latitude*pi()/180))+cos((:latitude*pi()/180))*cos((dest.latitude*pi()/180))*\n" +
            "cos(((:longitude-dest.longitude)*pi()/180))))*180/pi())*60*1.1515*1609.344) as distance \n" +
            "FROM drivers AS dest WHERE driver_status =  'AVAILABLE')  tab\n" +
            " ORDER BY distance LIMIT 1", nativeQuery=true)
    Driver findNearestAvailableDriver(@Param("longitude") double longitude, @Param("latitude") double latitude);


}
