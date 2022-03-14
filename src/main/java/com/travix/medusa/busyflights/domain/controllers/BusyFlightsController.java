package com.travix.medusa.busyflights.domain.controllers;

import com.travix.medusa.busyflights.domain.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.components.BusyFlightsProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class BusyFlightsController {

    private final BusyFlightsProcessor BusyFlightsProcessor;

    @Autowired
    public BusyFlightsController(com.travix.medusa.busyflights.domain.components.BusyFlightsProcessor busyFlightsProcessor) {
        BusyFlightsProcessor = busyFlightsProcessor;
    }

    //TODO validate the rest of params, see if with annotations this can be achieved
    @GetMapping("/search-flights")
    public ResponseEntity<?> searchFlights(String origin, String destination,
                                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate,
                                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate returnDate,
                                           int numberOfPassengers){
        BusyFlightsRequest busyFlightsRequest = new BusyFlightsRequest(origin, destination, departureDate.toString(),
                returnDate.toString(), numberOfPassengers);
        List<BusyFlightsResponse> busyFlightsResponses = BusyFlightsProcessor.searchFlights(busyFlightsRequest);
        if (!busyFlightsResponses.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("NO flights found with the params");
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(busyFlightsResponses);
        }

    }


}
