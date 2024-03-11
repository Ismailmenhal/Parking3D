package com.example.Parking.Controller;

import com.example.Parking.DTO.ParkingDTO;
import com.example.Parking.Mapper.ParkingMapper;
import com.example.Parking.Model.Parking;
import com.example.Parking.Service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "parkings")
public class ParkingController {
    @Autowired
    private ParkingService parkingService ;
    private ParkingMapper parkingMapper ;
    @PostMapping
    public ResponseEntity<ParkingDTO> saveParking(@RequestBody ParkingDTO parkingDTO) {
        ParkingDTO savedParkingDTO = parkingService.saveParking(parkingDTO);
        return new ResponseEntity<>(savedParkingDTO, HttpStatus.CREATED);
    }


    @GetMapping
    public List<Parking> getAllParkings(){
        return parkingService.getAllParkings();
    }
    @GetMapping("{id}")
    public Parking getParkingById(@PathVariable Long id){
        return parkingService.getParkingById(id);
    }
    @PutMapping("{id}")
    public Parking updateParking(@PathVariable Integer id , @RequestBody Parking parking){
        parking.setId(id);
        return parkingService.updateParking(parking);
    }
    @DeleteMapping("{id}")
    public void DeleteParking(@PathVariable Long id){
        parkingService.DeleteParking(id);
    }
}
