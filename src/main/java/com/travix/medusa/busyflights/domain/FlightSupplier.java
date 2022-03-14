package com.travix.medusa.busyflights.domain;

public enum FlightSupplier {

    CRAZY_AIR("http://localhost:8080/search-crazy-air-flights"),
    TOUGH_JET("http://localhost:8080/search-tough-jet-flights");

    private final String url;

    FlightSupplier(String value) {
        this.url = value;
    }

    public String getUrl() {
        return url;
    }

}
