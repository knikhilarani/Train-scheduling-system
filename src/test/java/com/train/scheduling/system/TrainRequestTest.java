package com.train.scheduling.system;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TrainRequestTest {

    @Test
    void testGettersAndSetters() {
        // Given
        String number = "123";
        String name = "Test Train";
        List<String> stations = new ArrayList<>();
        stations.add("Station 1");
        stations.add("Station 2");

        // When
        TrainRequest trainRequest = new TrainRequest();
        trainRequest.setNumber(number);
        trainRequest.setName(name);
        trainRequest.setStations(stations);

        // Then
        assertThat(trainRequest.getNumber()).isEqualTo(number);
        assertThat(trainRequest.getName()).isEqualTo(name);
        assertThat(trainRequest.getStations()).isEqualTo(stations);
    }


}
