package com.travix.medusa.busyflights.domain.components;

import com.travix.medusa.busyflights.domain.BaseRequest;
import com.travix.medusa.busyflights.domain.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.FlightSupplier;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;

public final class RequestBuilder {

    public static BaseRequest convert(BusyFlightsRequest busyFlightsRequest, FlightSupplier flightSupplier){
        if (flightSupplier.equals(FlightSupplier.CRAZY_AIR)){
            return new CrazyAirRequest(busyFlightsRequest.getOrigin(), busyFlightsRequest.getDestination(),
                    busyFlightsRequest.getDepartureDate(), busyFlightsRequest.getReturnDate(), busyFlightsRequest.getNumberOfPassengers());
        }else {
            return new ToughJetRequest(busyFlightsRequest.getOrigin(), busyFlightsRequest.getDestination(),
                    busyFlightsRequest.getDepartureDate(), busyFlightsRequest.getReturnDate(), busyFlightsRequest.getNumberOfPassengers());
        }
    }

}
