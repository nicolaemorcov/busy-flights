package com.travix.medusa.busyflights.domain.components;

import com.travix.medusa.busyflights.domain.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.BusyFlightsResponse;

import java.util.List;

public interface BusyFlightsProcessor {


    List<BusyFlightsResponse> searchFlights(BusyFlightsRequest busyFlightsRequest);
}
