package com.travix.medusa.busyflights;

public final class BusinessValidator {

    // object validation
    public static <T> T isNotNull(T obj, String message) {
        if (obj == null)
            throw new IllegalArgumentException(message);
        return obj;
    }

    // String validation
    public static String isNotNullAndFixedLength(String value, int fixedLength, String message) {
        isNotNull(value, message);
        if (value.length() != 3)
            throw new IllegalArgumentException(message);
        return value;
    }

    // int Validations
    public static int checkMinValue(int value, int min, String message) {
        if (value >= min) {
            return value;
        } else {
            throw new IllegalArgumentException(message);
        }
    }

    // int Validations
    public static int checkMinAndMaxValue(int value, int min, int max, String message) {
        if (value >= min && value <= max) {
            return value;
        } else {
            throw new IllegalArgumentException(message);
        }
    }

}
