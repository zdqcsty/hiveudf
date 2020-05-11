package com.example.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MonthBetweenUdf extends UDF {

    public Integer evaluate(String date1, String date2) {
        if (date1 == null || date2 == null) return null;

        Date d1 = parseDate(date1);
        Date d2 = parseDate(date2);
        if (d1 == null || d2 == null) {
            return null;
        }
        Calendar bef = Calendar.getInstance();
        Calendar aft = Calendar.getInstance();
        bef.setTime(d1);
        aft.setTime(d2);
        int result = aft.get(2) - bef.get(2);
        int month = (aft.get(1) - bef.get(1)) * 12;
        return Integer.valueOf(month + result);
    }

    public Date parseDate(String date) {
        Date resultDate = null;

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf6 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf7 = new SimpleDateFormat("yyyyMM");

        try {
            resultDate = sdf1.parse(date);
        } catch (ParseException parseException) {}


        if (resultDate == null) {
            try {
                resultDate = sdf2.parse(date);
            } catch (ParseException parseException) {}
        } else {

            return resultDate;
        }

        if (resultDate == null) {
            try {
                resultDate = sdf3.parse(date);
            } catch (ParseException parseException) {}
        } else {

            return resultDate;
        }

        if (resultDate == null) {
            try {
                resultDate = sdf4.parse(date);
            } catch (ParseException parseException) {}
        } else {

            return resultDate;
        }

        if (resultDate == null) {
            try {
                resultDate = sdf5.parse(date);
            } catch (ParseException parseException) {}
        } else {

            return resultDate;
        }

        if (resultDate == null) {
            try {
                resultDate = sdf6.parse(date);
            } catch (ParseException parseException) {}
        } else {

            return resultDate;
        }

        if (resultDate == null) {
            try {
                resultDate = sdf7.parse(date);
            } catch (ParseException parseException) {}
        } else {

            return resultDate;
        }

        return resultDate;
    }

    public static void main(String[] args) {
        Integer integer = (new MonthBetweenUdf()).evaluate("201512", "201510");
        System.out.println(integer);
    }
}
