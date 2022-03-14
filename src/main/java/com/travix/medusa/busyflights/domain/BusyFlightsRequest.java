package com.travix.medusa.busyflights.domain;

import com.travix.medusa.busyflights.BusinessValidator;

public class BusyFlightsRequest extends BaseRequest{

    private String origin;
    private String destination;
    private String departureDate;
    private String returnDate;
    private int numberOfPassengers;

    public BusyFlightsRequest(String origin, String destination, String departureDate, String returnDate, int numberOfPassengers) {
        this.origin = BusinessValidator.isNotNullAndFixedLength(origin, 3, "must not be null and value length of 3");
        this.destination = BusinessValidator.isNotNullAndFixedLength(destination, 3, "must not be null and value length of 3");
        this.departureDate = BusinessValidator.isNotNull(departureDate, " must not be null");
        this.returnDate = BusinessValidator.isNotNull(returnDate, "must not be null");
        this.numberOfPassengers = BusinessValidator.checkMinAndMaxValue(numberOfPassengers, 1, 4, " value should be withing min and max");
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(final String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(final String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(final String returnDate) {
        this.returnDate = returnDate;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(final int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}
