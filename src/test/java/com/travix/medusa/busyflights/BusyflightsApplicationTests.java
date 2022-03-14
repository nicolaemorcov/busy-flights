package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.domain.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.components.BusyFlightsProcessor;
import com.travix.medusa.busyflights.domain.components.BusyFlightsProcessorImpl;
import com.travix.medusa.busyflights.domain.components.ResponseHandlerImpl;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirController;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetController;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class BusyflightsApplicationTests {

    @Autowired
    private BusyFlightsProcessor busyFlightsProcessor;

    @Before
    public void setUp(){

        this.busyFlightsProcessor = new BusyFlightsProcessorImpl(new ResponseHandlerImpl());
    }

    @Test
    void testResponseFlightsFound() {
        BusyFlightsRequest busyFlightsRequest = buildRequest();
        List<BusyFlightsResponse> busyFlightsResponses = busyFlightsProcessor.searchFlights(busyFlightsRequest);//there is no valid link to test and return results
        assertFalse(busyFlightsResponses.isEmpty());
    }

    @Test
    void testResponseFlightsNotFound() {
        BusyFlightsRequest busyFlightsRequest = buildRequest();
        List<BusyFlightsResponse> busyFlightsResponses = busyFlightsProcessor.searchFlights(busyFlightsRequest);
        assertTrue(busyFlightsResponses.isEmpty());
    }

    private BusyFlightsRequest buildRequest() {
        return new BusyFlightsRequest("KIV", "LHR", "2022-02-12",
                "2022-02-12", 3);
    }

//    private List<BaseResponse> getCrazyAirResponses() {
//        CrazyAirResponse crazyAirResponse = new CrazyAirResponse("suk", 23.1, "Economy", "KIV", "LHR",
//                "2022-05-03T00:25:00.000", "2022-05-03T02:25:00.000");
//        CrazyAirResponse crazyAirResponse1 = new CrazyAirResponse("gih", 25, "Economy", "KIV", "LHR",
//                "2022-05-03T02:35:00.000", "2022-05-03T04:40:00.000");
//        return new ArrayList<>(Arrays.asList(crazyAirResponse, crazyAirResponse1));
//    }
//
//    private List<BusyFlightsResponse> getFlights(List<BaseResponse> baseResponses) {
//        List<BusyFlightsResponse> responseFlights = new ArrayList<>();
//        baseResponses.forEach(baseResponse -> {
//            CrazyAirResponse crazyAirResponse = (CrazyAirResponse) baseResponse;
//            responseFlights.add(new BusyFlightsResponse(crazyAirResponse.getAirline(), FlightSupplier.CRAZY_AIR.name(),
//                    crazyAirResponse.getPrice(), crazyAirResponse.getDepartureAirportCode(), crazyAirResponse.getDestinationAirportCode(),
//                    crazyAirResponse.getDepartureDate(), crazyAirResponse.getArrivalDate()));
//        });
//        return responseFlights;
//    }


}
