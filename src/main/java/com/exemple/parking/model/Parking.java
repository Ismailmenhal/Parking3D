package com.exemple.parking.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data

public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @Column(name = "Parking_name")
    private String name ;

    @Column
    private Integer capacity ;

}
