package com.travix.medusa.busyflights.domain;

public class BusyFlightsResponse extends BaseResponse{

    private final String airline;
    private final String supplier;
    private final double fare;
    private final String departureAirportCode;
    private final String destinationAirportCode;
    private final String departureDate;
    private final String arrivalDate;

    public BusyFlightsResponse(String airline, String supplier, double fare, String departureAirportCode,
                               String destinationAirportCode, String departureDate, String arrivalDate) {
        this.airline = airline;
        this.supplier = supplier;
        this.fare = fare;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public String getAirline() {
        return airline;
    }

    public String getSupplier() {
        return supplier;
    }

    public double getFare() {
        return fare;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }
}
