package com.travix.medusa.busyflights.domain;

import java.util.List;

public interface ResponseHandler {
    List<BusyFlightsResponse> filterFlights(List<BaseResponse> baseResponses);
}
