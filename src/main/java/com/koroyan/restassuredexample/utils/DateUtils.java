package com.koroyan.restassuredexample.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {


    public static Date stringToDate(String stringDate) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
    }
}
