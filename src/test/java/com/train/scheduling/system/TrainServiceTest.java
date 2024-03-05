package com.train.scheduling.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TrainServiceTest {

    @Mock
    private TrainRepository trainRepository;

    @Mock
    private TrainStationRepository trainStationRepository;

    @InjectMocks
    private TrainService trainService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addTrain_ValidRequest_ShouldSaveTrain() {
        // Given
        TrainRequest request = new TrainRequest();
        request.setNumber("123");
        request.setName("Test Train");
        List<String> stations = new ArrayList<>();
        stations.add("Station 1");
        stations.add("Station 2");
        request.setStations(stations);

        Train train = new Train();
        train.setNumber(request.getNumber());
        train.setName(request.getName());

        when(trainRepository.save(any(Train.class))).thenReturn(train);

        // When
        trainService.addTrain(request);

        // Then
        verify(trainRepository, times(1)).save(any(Train.class));
    }

    @Test
    void deleteTrain_ExistingTrainNumber_ShouldDeleteTrain() {
        // Given
        String trainNumber = "123";
        Train train = new Train();
        when(trainRepository.findByNumber(trainNumber)).thenReturn(train);

        // When
        trainService.deleteTrain(trainNumber);

        // Then
        verify(trainRepository, times(1)).delete(train);
    }


}

