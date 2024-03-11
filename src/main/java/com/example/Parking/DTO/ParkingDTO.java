package com.example.Parking.DTO;


public class ParkingDTO {
    public Integer id ;
    public  String name ;

    public ParkingDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public ParkingDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
