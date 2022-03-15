package com.travix.medusa.busyflights.domain.crazyair;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.travix.medusa.busyflights.domain.BaseRequest;

import java.io.Serializable;

public class CrazyAirRequest extends BaseRequest implements Serializable {

    private String origin;
    private String destination;
    private String departureDate;
    private String returnDate;
    private Integer passengerCount;

    public CrazyAirRequest(@JsonProperty String origin, @JsonProperty String destination, @JsonProperty String departureDate,
                           @JsonProperty String returnDate, @JsonProperty Integer passengerCount) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.passengerCount = passengerCount;
    }

    public CrazyAirRequest() {
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

    public Integer getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(final int passengerCount) {
        this.passengerCount = passengerCount;
    }

    @Override
    public String toString() {
        return "CrazyAirRequest{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", passengerCount=" + passengerCount +
                '}';
    }
}
