package com.example.Parking.Controller;

import com.example.Parking.DTO.ParkingDTO;
import com.example.Parking.Exception.ParkingNotFoundException;
import com.example.Parking.Mapper.ParkingMapper;
import com.example.Parking.Model.Parking;
import com.example.Parking.Service.ParkingService;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequestMapping(value = "parkings")
public class ParkingController {
    @Autowired
    private ParkingService parkingService ;
    private ParkingMapper mapper;
    @PostMapping
    public ResponseEntity<ParkingDTO> saveParking(@RequestBody ParkingDTO parkingDTO) {
        log.debug("Received request to save parking" ,parkingDTO);
        ParkingDTO savedParkingDTO = parkingService.saveParking(parkingDTO);
        log.debug("Parking saved: "  , savedParkingDTO);
        return new ResponseEntity<>(savedParkingDTO, HttpStatus.CREATED);
    }


    @GetMapping
    public List<Parking> getAllParkings(){
        log.debug("Received request to get all  parking" );
        return parkingService.getAllParkings();
    }
    @GetMapping("{id}")
    public Parking getParkingById(@PathVariable String id) {
        if (id == null || "null".equals(id)) {
            log.warn("Received request with null or 'null' ID");
            throw new IllegalArgumentException("ID cannot be null");
        }
        Long parkingId = Long.parseLong(id);
        log.debug("Received request to Get parking By Id: ", parkingId);
        Parking parking = parkingService.getParkingById(parkingId);
        if (parking == null) {
            log.warn("Parking not found with id: {}", parkingId);
            throw new ParkingNotFoundException("Parking not found with id: " , parkingId);
        }
        return parking;
    }
    @PutMapping("{id}")
    public Parking updateParking(@PathVariable Integer id , @RequestBody Parking parking){
        log.info("Receive  Request to update Parking By  " + id + ": "+parking );
        parking.setId(id);
        return parkingService.updateParking(parking);
    }
    @DeleteMapping("{id}")
    public void DeleteParking(@PathVariable Long id){
        log.info("Receive Request to delete Parking by Id " + id);
        parkingService.DeleteParking(id);
    }
}
