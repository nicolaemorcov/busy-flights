package com.travix.medusa.busyflights.domain;

import java.io.Serializable;


public abstract class BaseResponse implements Serializable {

    public static double roundToTwoDecimal(double value){
        return Math.round(value*100.0)/100.0;
    }



}
