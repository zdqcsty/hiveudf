package com.example.udf;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.hive.serde2.io.HiveDecimalWritable;

public class DataMinUdf extends UDF {

    public Long evaluate(Long a, Long b) {
        if (a == null || b == null) return null;
        return (a.longValue() > b.longValue()) ? b : a;
    }

    public HiveDecimalWritable evaluate(HiveDecimalWritable a, HiveDecimalWritable b) {
        if (a == null || b == null) return null;
        int i = a.compareTo(b);
        if (i > 1) {
            return a;
        }
        return b;
    }
}
