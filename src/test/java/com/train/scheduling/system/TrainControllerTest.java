package com.train.scheduling.system;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TrainControllerTest {

    @Mock
    private TrainService trainService;

    @InjectMocks
    private TrainController trainController;

    public TrainControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void updateTrain_ValidRequest_ShouldReturnOkResponse() {
        // Given
        TrainRequest request = new TrainRequest();
        request.setNumber("123");
        request.setName("Updated Test Train");
        List<String> stations = new ArrayList<>();
        stations.add("Station 1");
        stations.add("Station 2");
        request.setStations(stations);

        // When
        ResponseEntity<String> responseEntity = trainController.updateTrain(request);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(trainService, times(1)).updateTrain(request);
    }

    @Test
    void findTrains_ValidSourceAndDestination_ShouldReturnOkResponse() {
        // Given
        String source = "Source Station";
        String destination = "Destination Station";
        List<Train> trains = new ArrayList<>();
        // Add some dummy trains to the list

        when(trainService.findTrains(source, destination)).thenReturn(trains);

        // When
        ResponseEntity<List<Train>> responseEntity = trainController.findTrains(source, destination);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(trains, responseEntity.getBody());
        verify(trainService, times(1)).findTrains(source, destination);
    }
    
}
