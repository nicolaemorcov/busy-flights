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
        BusyFlightsRequest busyFlightsRequest = buildRequestWithDifferentOrigin();
        List<BusyFlightsResponse> busyFlightsResponses = busyFlightsProcessor.searchFlights(busyFlightsRequest);
        assertTrue(busyFlightsResponses.isEmpty());
    }

    private BusyFlightsRequest buildRequest() {
        return new BusyFlightsRequest("KIV", "LHR", "2022-02-12",
                "2022-02-12", 3);
    }

    private BusyFlightsRequest buildRequestWithDifferentOrigin() {
        return new BusyFlightsRequest("IST", "LHR", "2022-02-12",
                "2022-02-12", 3);
    }


}
