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
    private ParkingMapper parkingMapper ;

    public ParkingDTO saveParking(ParkingDTO parkingDTO){
        Parking parking = parkingMapper.fromDto(parkingDTO);
        Parking savedParking = parkingRepository.save(parking);
        return parkingMapper.toDto(savedParking);
    }
    public List<Parking> getAllParkings(){
        return parkingRepository.findAll();
    }
    public Parking getParkingById(Long id){
        return parkingRepository.findById(id).orElse(null);
    }
    public Parking updateParking(Parking parking){
        Parking saved = parkingRepository.save(parking);
        log.info(saved.getName());
        return saved;
    }
    public void DeleteParking(Long id){
        parkingRepository.deleteById(id);
    }
}
