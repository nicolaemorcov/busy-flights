package com.travix.medusa.busyflights.domain;

public enum FlightSupplier {

    CRAZY_AIR("http://localhost:8080/crazy_url"),
    TOUGH_JET("http://localhost:8080/tough_jet_url");

    private final String url;

    FlightSupplier(String value) {
        this.url = value;
    }

    public String getUrl() {
        return url;
    }

}
