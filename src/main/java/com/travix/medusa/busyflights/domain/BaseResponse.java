package com.travix.medusa.busyflights.domain;

public abstract class BaseResponse {

    public static double roundToTwoDecimal(double value){
        return Math.round(value*100.0)/100.0;
    }



}
