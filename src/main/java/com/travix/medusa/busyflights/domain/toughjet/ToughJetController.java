package com.travix.medusa.busyflights.domain.toughjet;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ToughJetController {

    //TODO validate the rest of params, see if with annotations this can be achieved
    @PostMapping("/search-tough-jet-flights")
    public ResponseEntity<?> searchToughJetFlights(ToughJetRequest toughJetRequest){
        List<ToughJetResponse> toughJetResponses = getToughJetResponses(toughJetRequest);
        if (toughJetResponses.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("NO flights found with the params");
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(toughJetResponses);
        }

    }

    // sample data created to use, assuming they are from db
    private List<ToughJetResponse> getToughJetResponses(ToughJetRequest toughJetRequest) {
        ToughJetResponse toughJetResponse = new ToughJetResponse("suk", 27.1, 2.1, 3, "KIV", "LHR",
                "2022-05-03T00:25:00.000", "2022-05-03T02:25:00.000");
        ToughJetResponse toughJetResponse1 = new ToughJetResponse("suk", 25.1, 2.1, 3, "KIV", "LHR",
                "2022-05-03T00:25:00.000", "2022-05-03T02:25:00.000");
        List<ToughJetResponse> toughJetResponses = new ArrayList<>(Arrays.asList(toughJetResponse, toughJetResponse1));
        return toughJetResponses.stream()
                .filter(response -> response.getDepartureAirportName().equals(toughJetRequest.getFrom())
                        && response.getArrivalAirportName().equals(toughJetRequest.getTo()))
                .collect(Collectors.toList());
    }

}
