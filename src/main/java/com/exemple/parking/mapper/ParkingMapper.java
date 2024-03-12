package com.exemple.parking.mapper;

import com.exemple.parking.dto.ParkingDTO;
import com.exemple.parking.model.Parking;
import org.springframework.stereotype.Component;

@Component
public class ParkingMapper {
    public ParkingDTO mappertodto(Parking parking){
        ParkingDTO dto = new ParkingDTO();
        dto.setId(parking.getId());
        dto.setName(parking.getName());
        return  dto;
    }
    public Parking mapperfromDto(ParkingDTO dto){
        Parking parking = new Parking();
        parking.setId(dto.getId());
        parking.setName(dto.getName());
        return parking;
    }
}
