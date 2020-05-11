package com.example.udf;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.hive.serde2.io.HiveDecimalWritable;

import java.math.BigDecimal;

public class DataMaxUdf extends UDF {

    public Long evaluate(Long a, Long  b) {
        if (a == null || b == null) return null;
        return (a.longValue() > b.longValue()) ? a : b;
    }

/*    public HiveDecimalWritable evaluate(HiveDecimalWritable a, HiveDecimalWritable b) {
        if (a == null || b == null) return null;
        int i = a.compareTo(b);
        if (i>1){
            return b;
        }
        return a;
    }*/

    public BigDecimal evaluate(BigDecimal a, BigDecimal b) {
        if (a == null || b == null) return null;
        int i = a.compareTo(b);
        if (i>1){
            return b;
        }
        return a;
    }


}
