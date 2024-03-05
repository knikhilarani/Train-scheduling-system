package com.train.scheduling.system;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    // Add Train API
    @PostMapping("/add")
    public ResponseEntity<String> addTrain(@RequestBody TrainRequest request) {
        trainService.addTrain(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Train added successfully.");
    }

    // Remove Train API
    @DeleteMapping("/remove")
    public ResponseEntity<String> removeTrain(@RequestParam("number") String trainNumber) {
        trainService.deleteTrain(trainNumber);
        return ResponseEntity.status(HttpStatus.OK).body("Train removed successfully.");
    }

    // Update Train API
    @PutMapping("/update")
    public ResponseEntity<String> updateTrain(@RequestBody TrainRequest request) {
        trainService.updateTrain(request);
        return ResponseEntity.status(HttpStatus.OK).body("Train updated successfully.");
    }

    // Find Trains API
    @GetMapping ("/find")
    public ResponseEntity<List<Train>> findTrains(@RequestParam String source, @RequestParam String destination) {

        List<Train> trains = trainService.findTrains(source, destination);
        return ResponseEntity.status(HttpStatus.OK).body(trains);
    }
}
