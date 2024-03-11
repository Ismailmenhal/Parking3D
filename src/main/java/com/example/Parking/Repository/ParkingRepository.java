package com.example.Parking.Repository;

import com.example.Parking.Model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ParkingRepository extends JpaRepository<Parking, Long> {
}
