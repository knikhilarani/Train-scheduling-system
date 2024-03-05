package com.train.scheduling.system;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "train")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "number", nullable = false, unique = true)
    private String number;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    private List<TrainStation> stations;

    // Constructors, getters, and setters

    // Constructor with parameters
    public Train(String name, String number, List<TrainStation> stations) {
        this.name = name;
        this.number = number;
        this.stations = stations;
    }

    // Getters and setters
    // Constructor with parameters
    public Train(String name, Long id, List<TrainStation> stations) {
        this.name = name;
        this.id = id;
        this.stations = stations;
    }
}

