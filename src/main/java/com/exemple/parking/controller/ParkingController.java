package com.exemple.parking.controller;
import com.exemple.parking.dto.ParkingDTO;
import com.exemple.parking.exception.ParkingNotFoundException;
import com.exemple.parking.mapper.ParkingMapper;
import com.exemple.parking.model.Parking;
import com.exemple.parking.service.ParkingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Log4j2
@RequestMapping(value = "parkings")
public class ParkingController {

    private ParkingService parkingService ;
    @Autowired
    public ParkingController(ParkingService parkingService, ParkingMapper mapper) {
        this.parkingService = parkingService;
    }

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
    public Parking getParkingById(@PathVariable Integer id) {
        if (id == null || "null".equals(id)) {
            log.warn("Received request with null or 'null' ID");
            throw new NullPointerException("ID cannot be null");
        }

        log.debug("Received request to Get parking By Id: " );
        Parking parking = parkingService.getParkingById(Long.valueOf(id));
        if (parking == null) {
            log.warn("Parking not found with id: {}");
            throw new ParkingNotFoundException("Parking not found with id: " +id  );
        }
        return parking;
    }
    @PutMapping("{id}")
    public Parking updateParking(@PathVariable Integer id , @RequestBody Parking parking){
        log.info("Receive  Request to update Parking By  "  , id , ": "+parking );
        parking.setId(id);
        return parkingService.updateParking(parking);
    }
    @DeleteMapping("{id}")
    public void deleteParking(@PathVariable Long id){
        log.info("Receive Request to delete Parking by Id " , id);
        parkingService.deleteParking(id);
    }
}
