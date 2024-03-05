package com.train.scheduling.system;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainStationRepository extends JpaRepository<TrainStation,Long> {
    TrainStation findByStationName(String stationName);
}
