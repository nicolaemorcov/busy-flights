package com.travix.medusa.busyflights.domain.components;

import com.travix.medusa.busyflights.domain.*;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class BusyFlightsProcessorImpl implements BusyFlightsProcessor {

    private static final Logger logger = LoggerFactory.getLogger(BusyFlightsProcessorImpl.class);

    private final RestTemplate restTemplate;

    private final ResponseHandler responseHandler;

    public BusyFlightsProcessorImpl(ResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<BusyFlightsResponse> searchFlights(BusyFlightsRequest busyFlightsRequest) {
        List<BaseResponse> baseResponses = new ArrayList<>();
        for (FlightSupplier flightSupplier : FlightSupplier.values()) {
            BaseRequest baseRequest = RequestBuilder.convert(busyFlightsRequest, flightSupplier);
            try {
                List<BaseResponse> responseFlights = getFlightResponse(baseRequest, flightSupplier.getUrl(), flightSupplier);
                baseResponses.addAll(responseFlights);
            }catch (Exception e){
                logger.error("Failed to get the Response from {} :: exception={}", flightSupplier.name(), e);
            }
        }
        return responseHandler.filterFlights(baseResponses);
    }

    //TODO this method is not a good implementation, I would replace it with the commented method.
    //TODO I was planning to use the commented method below in a loop for each flight supplier
    //TODO but needed more time to play around with annotations as abstract class needs more details on their child classes
    private List<BaseResponse> getFlightResponse(BaseRequest baseRequest, String url, FlightSupplier flightSupplier){
        switch (flightSupplier){
            case CRAZY_AIR: {
                ResponseEntity<CrazyAirResponse[]> crazyResponse = restTemplate.postForEntity( url, baseRequest , CrazyAirResponse[].class );
                if (crazyResponse.getBody() != null){
                    return Arrays.asList(crazyResponse.getBody());
                }
            }
            case TOUGH_JET: {
                ResponseEntity<ToughJetResponse[]> toughJetResponse = restTemplate.postForEntity( url, baseRequest , ToughJetResponse[].class );
                if (toughJetResponse.getBody() != null){
                    return Arrays.asList(toughJetResponse.getBody());
                }
            }
        }
        return Collections.emptyList();
    }


    //TODO Need more time to play with spring annotations in order to use this. As an abstract class cannot be sent unless given more info on child classes
//    private List<BaseResponse> getFlightResponse(BaseRequest baseRequest, String url) throws JsonProcessingException {
//        ResponseEntity<BaseResponse[]> response = restTemplate.postForEntity( url, baseRequest , BaseResponse[].class );
//        if (response.getBody() != null){
//            return Arrays.asList(response.getBody());
//        }
//        return Collections.emptyList();
//    }


}
