package com.example.Parking.Service;

import com.example.Parking.DTO.ParkingDTO;
import com.example.Parking.Mapper.ParkingMapper;
import com.example.Parking.Model.Parking;
import com.example.Parking.Repository.ParkingRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Log4j2
public class ParkingService {

    @Autowired
    private ParkingRepository parkingRepository ;


    public     ParkingMapper mapper;

    public ParkingDTO saveParking(ParkingDTO parkingDTO){
        Parking parking = mapper.MapperfromDto(parkingDTO);
        log.info("Mapping DTO to Entity " , parking);

        Parking savedParking = parkingRepository.save(parking);
        log.info("saved Parking"  , savedParking);

        ParkingDTO savedParkingDTO =  mapper.MapperToDto(savedParking);
        log.info("mapped Entity To DTO "  , savedParkingDTO);
        return savedParkingDTO ;
    }
    public List<Parking> getAllParkings(){
        log.info("Getting All PArkings" );
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
    public void DeleteParking(Long id){
        log.info("Delete Parking by Id"  , id);
        parkingRepository.deleteById(id);
    }
}
