package com.exemple.parking.repository;

import com.exemple.parking.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ParkingRepository extends JpaRepository<Parking, Long> {
}
