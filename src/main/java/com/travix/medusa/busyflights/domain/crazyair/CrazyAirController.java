package com.travix.medusa.busyflights.domain.crazyair;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CrazyAirController {

    //TODO validate the rest of params, see if with annotations this can be achieved
    @PostMapping("/search-crazy-air-flights")
    public ResponseEntity<?> searchCrazyAirFlights(@RequestBody CrazyAirRequest crazyAirRequest){
        List<CrazyAirResponse> crazyAirResponses = getCrazyAirResponses(crazyAirRequest);
        if (crazyAirResponses.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("NO flights found with the params");
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(crazyAirResponses);
        }

    }

    // sample data created to use, assuming they are from db and matched by request
    private List<CrazyAirResponse> getCrazyAirResponses(CrazyAirRequest crazyAirRequest) {
        CrazyAirResponse crazyAirResponse = new CrazyAirResponse("suk", 23.1, "Economy", "KIV", "LHR",
                "2022-05-03T00:25:00.000", "2022-05-03T02:25:00.000");
        CrazyAirResponse crazyAirResponse1 = new CrazyAirResponse("gih", 25, "Economy", "STN", "IST",
                "2022-05-03T02:35:00.000", "2022-05-03T04:40:00.000");
        List<CrazyAirResponse> crazyAirResponses = new ArrayList<>(Arrays.asList(crazyAirResponse, crazyAirResponse1));
        return crazyAirResponses.stream()
                .filter(response -> response.getDepartureAirportCode().equals(crazyAirRequest.getOrigin())
                        && response.getDestinationAirportCode().equals(crazyAirRequest.getDestination()))
                .collect(Collectors.toList());
    }

}
