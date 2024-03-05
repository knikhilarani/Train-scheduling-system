package com.train.scheduling.system;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "train_stations")
public class TrainStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stationId;

    @ManyToOne
    @JoinColumn(name = "train_id", referencedColumnName = "id")
    @JsonIgnore
    private Train train;

    @Column(name = "station_name", nullable = false)
    private String stationName;




}



