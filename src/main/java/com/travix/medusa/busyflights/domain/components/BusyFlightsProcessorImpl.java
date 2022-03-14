package com.travix.medusa.busyflights.domain.components;

import com.travix.medusa.busyflights.domain.FlightSupplier;
import com.travix.medusa.busyflights.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

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
                List<BaseResponse> responseFlights = getFlightResponse(baseRequest, flightSupplier.getUrl());
                baseResponses.addAll(responseFlights);
            }catch (Exception e){
                logger.error("Failed to get the Response from {}", flightSupplier.name());
            }
        }
        return responseHandler.filterFlights(baseResponses);
    }



    private List<BaseResponse> getFlightResponse(BaseRequest baseRequest, String url){
        ResponseEntity<BaseResponse[]> responseEntity =
                restTemplate.postForEntity(url, baseRequest, BaseResponse[].class);
        if (responseEntity.getBody() != null){
            return Arrays.asList(responseEntity.getBody());
        }
        return Collections.emptyList();
    }

}
