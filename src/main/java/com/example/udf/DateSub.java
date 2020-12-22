package com.example.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateSub extends UDF {
    public String evaluate(String date, Integer interval, String flag) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date d1 = sdf.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(d1);
            if ("y".equalsIgnoreCase(flag)) {
                cal.add(1, interval.intValue());
            } else if ("m".equalsIgnoreCase(flag)) {
                cal.add(2, interval.intValue());
            } else if ("d".equalsIgnoreCase(flag)) {
                cal.add(5, interval.intValue());
            } else {
                return null;
            }
            String format = sdf.format(cal.getTime());
            return format;
        } catch (ParseException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        String y = (new DateSub()).evaluate("2019-05-23 11:22:33", Integer.valueOf(5), "d");
        System.out.println(y);
    }
}
