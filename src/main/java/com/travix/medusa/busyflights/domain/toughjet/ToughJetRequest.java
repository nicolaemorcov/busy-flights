package com.travix.medusa.busyflights.domain.toughjet;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.travix.medusa.busyflights.domain.BaseRequest;

import java.io.Serializable;

public class ToughJetRequest extends BaseRequest implements Serializable {

    private String from;
    private String to;
    private String outboundDate;
    private String inboundDate;
    private Integer numberOfAdults;

    public ToughJetRequest(String from, String to, String outboundDate, String inboundDate, Integer numberOfAdults) {
        this.from = from;
        this.to = to;
        this.outboundDate = outboundDate;
        this.inboundDate = inboundDate;
        this.numberOfAdults = numberOfAdults;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(final String to) {
        this.to = to;
    }

    public String getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(final String outboundDate) {
        this.outboundDate = outboundDate;
    }

    public String getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(final String inboundDate) {
        this.inboundDate = inboundDate;
    }

    public Integer getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(final int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }
}
