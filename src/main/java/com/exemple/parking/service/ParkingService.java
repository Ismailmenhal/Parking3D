package com.exemple.parking.service;

import com.exemple.parking.dto.ParkingDTO;
import com.exemple.parking.mapper.ParkingMapper;
import com.exemple.parking.model.Parking;
import com.exemple.parking.repository.ParkingRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Log4j2
public class ParkingService {


    private ParkingRepository parkingRepository ;

    private    ParkingMapper mapper;
    @Autowired
    public ParkingService(ParkingRepository parkingRepository, ParkingMapper mapper) {
        this.parkingRepository = parkingRepository;
        this.mapper = mapper;
    }


    public ParkingDTO saveParking(ParkingDTO parkingDTO){
        Parking parking = mapper.mapperfromDto(parkingDTO);
        log.info("Mapping DTO to Entity " , parking);

        Parking savedParking = parkingRepository.save(parking);
        log.info("saved Parking"  , savedParking);

        ParkingDTO savedParkingDTO =  mapper.mappertodto(savedParking);
        log.info("mapped Entity To DTO "  , savedParkingDTO);
        return savedParkingDTO ;
    }
    public List<Parking> getAllParkings(){
        log.info("Getting All Parkings" );
        return parkingRepository.findAll();
    }
    public Parking getParkingById(Long id){
        log.info("Getting Parkings By Id"  , id);
        return parkingRepository.findById(id).orElse(null);
    }
    public Parking updateParking(Parking parking){
        Parking saved = parkingRepository.save(parking);
        log.info(saved.getName());
        return saved;
    }
    public void deleteParking(Long id){
        log.info("Delete Parking by Id"  , id);
        parkingRepository.deleteById(id);
    }
}
