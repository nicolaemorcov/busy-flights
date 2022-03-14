package com.travix.medusa.busyflights.domain;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResponseHandlerImpl implements ResponseHandler{

    @Override
    public List<BusyFlightsResponse> filterFlights(List<BaseResponse> baseResponses) {
        List<BusyFlightsResponse> responseFlights = new ArrayList<>();
        baseResponses.forEach(baseResponse -> {
            if (baseResponse instanceof CrazyAirResponse) {
                CrazyAirResponse crazyAirResponse = (CrazyAirResponse) baseResponse;
                responseFlights.add(new BusyFlightsResponse(crazyAirResponse.getAirline(), FlightSupplier.CRAZY_AIR.name(),
                        BaseResponse.roundToTwoDecimal(crazyAirResponse.getPrice()), crazyAirResponse.getDepartureAirportCode(), crazyAirResponse.getDestinationAirportCode(),
                        crazyAirResponse.getDepartureDate(), crazyAirResponse.getArrivalDate()));
            } else if (baseResponse instanceof ToughJetResponse) {
                ToughJetResponse toughJetResponse = (ToughJetResponse) baseResponse;
                responseFlights.add(new BusyFlightsResponse(toughJetResponse.getCarrier(), FlightSupplier.TOUGH_JET.name(),
                        BaseResponse.roundToTwoDecimal(toughJetResponse.getBasePrice()), toughJetResponse.getDepartureAirportName(), toughJetResponse.getArrivalAirportName(),
                        toughJetResponse.getOutboundDateTime(), toughJetResponse.getInboundDateTime()));
            }
        });
        return responseFlights.stream()
                .sorted(Comparator.comparingDouble(BusyFlightsResponse::getFare))
                .collect(Collectors.toList());
    }


}
