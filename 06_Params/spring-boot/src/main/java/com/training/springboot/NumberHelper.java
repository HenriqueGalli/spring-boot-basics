package com.training.springboot;

public class NumberHelper {

    public static Double convertToDouble(String number) {
        if (number == null) return 0D;
        String convertedNumber = number.replaceAll(",", ".");
        if (isNumeric(convertedNumber)) return Double.parseDouble(convertedNumber);
        return 0D;
    }

    public static boolean isNumeric(String number) {
        if (number == null) return false;
        String convertedNumber = number.replaceAll(",", ".");
        return convertedNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
