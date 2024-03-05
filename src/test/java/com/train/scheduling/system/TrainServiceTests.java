package com.train.scheduling.system;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TrainServiceTests {

    @Mock
    private TrainRepository trainRepository;

    @Mock
    private TrainStationRepository trainStationRepository;

    @InjectMocks
    private TrainService trainService;

    @Test
    public void testAddTrain() {
        TrainRequest request = new TrainRequest("123", "Test Train", Arrays.asList("Station A"));
        Train train = new Train();
        train.setNumber(request.getNumber());
        train.setName(request.getName());

        when(trainRepository.save(any())).thenReturn(train);

        trainService.addTrain(request);

        verify(trainRepository).save(any());
    }
}