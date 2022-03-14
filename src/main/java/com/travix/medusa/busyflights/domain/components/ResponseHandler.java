package com.travix.medusa.busyflights.domain.components;

import com.travix.medusa.busyflights.domain.BaseResponse;
import com.travix.medusa.busyflights.domain.BusyFlightsResponse;

import java.util.List;

public interface ResponseHandler {
    List<BusyFlightsResponse> filterFlights(List<BaseResponse> baseResponses);
}
