package com.train.scheduling.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainService {
    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private TrainStationRepository trainStationRepository;
    public void addTrain(TrainRequest request) {
        if (request.getStations() == null) {


            throw new IllegalArgumentException("Stations list in TrainRequest cannot be null");
        }

        Train train = new Train();
        train.setNumber(request.getNumber());
        train.setName(request.getName());

        // Create TrainStation objects from station names in the request
        List<TrainStation> stations = new ArrayList<>();
        for (String stationName : request.getStations()) {
            TrainStation station = new TrainStation();
            station.setStationName(stationName);
            // Set the train for the station
            station.setTrain(train);
            stations.add(station);
        }

        // Set stations for the train
        train.setStations(stations);

        // Save the train and associated stations
        trainRepository.save(train);
    }



    public void deleteTrain(String number) {
        Train train = trainRepository.findByNumber(number);
        if (train != null) {
            trainRepository.delete(train);
        }
    }


    public void updateTrain(TrainRequest request) {
        Train existingTrain = trainRepository.findByNumber(request.getNumber());
        if (existingTrain != null) {
            existingTrain.setName(request.getName());

            // Clear existing stations and add new ones
            existingTrain.getStations().clear();
            List<TrainStation> stations = new ArrayList<>();
            for (String stationName : request.getStations()) {
                TrainStation station = new TrainStation();
                station.setStationName(stationName);
                stations.add(station);
            }
            existingTrain.setStations(stations);

            trainRepository.save(existingTrain);
        }
    }




    public List<Train> findTrains(String source, String destination) {
        return trainRepository.findTrainsByStations_StationName(source, destination);
        }




    }

