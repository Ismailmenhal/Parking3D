package com.example.Parking.Mapper;

import com.example.Parking.DTO.ParkingDTO;
import com.example.Parking.Model.Parking;

public class ParkingMapper {
    public ParkingDTO toDto (Parking parking){
        ParkingDTO dto = new ParkingDTO();
        dto.setId(parking.getId());
        dto.setName(parking.getName());
        return  dto;
    }
    public Parking fromDto(ParkingDTO dto){
        Parking parking = new Parking();
        parking.setId(dto.getId());
        parking.setName(dto.getName());
        return parking;

    }
}
