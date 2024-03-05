package com.train.scheduling.system;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {
   Train findByNumber(String number);
   @Query("SELECT DISTINCT t FROM Train t " +
           "JOIN t.stations s1 " +
           "JOIN t.stations s2 " +
           "WHERE s1.stationName = :source " +
           "AND s2.stationName = :destination " +
           "AND s1.stationId < s2.stationId")
   List<Train> findTrainsByStations_StationName(String source, String destination);
}

