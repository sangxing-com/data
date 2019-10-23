package com.cst.finance.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Double类型数据处理类
 * author jeff
 * date 2018-10-10
 */
public class NumberUtil {

    /**
     * 保留两位小数，不进行四舍五入
     * @param d
     * @return
     */
    public static Double saveOneBit(Double d){
        DecimalFormat format = new DecimalFormat("#0.###");
        format.setRoundingMode(RoundingMode.FLOOR);
        String result = format.format(d);
        return Double.parseDouble(result);
    }

    /**
     * 保留一位小数，不进行四舍五入
     * @param d
     * @return
     */
    public static Double saveOneBitOne(Double d){
        BigDecimal bd = new BigDecimal(d);
        Double tem = bd.setScale(1,BigDecimal.ROUND_FLOOR).doubleValue();
        return tem;
    }

    /**
     * 保留一位小数，进行四舍五入（该方法经测试 较为精准）
     * @param d
     * @return
     */
    public static Double saveOneBitOneRound1(Double d){
        String str = String.format("%.1f",d);
        double c = Double.parseDouble(str);
        return c;
    }

    /**
     * 保留一位小数，进行四舍五入
     * @param d
     * @return
     */
    public static Double saveOneBitOneRound(Double d){
        BigDecimal bd = new BigDecimal(d);
        Double tem = bd.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
        return tem;
    }

    /**
     * 保留两位小数,不进行四舍五入
     * @param d
     * @return
     */
    public static Double saveOneBitTwo(Double d){
        BigDecimal bd = new BigDecimal(d);
        Double tem = bd.setScale(2,BigDecimal.ROUND_FLOOR).doubleValue();
        return tem;
    }

    /**
     * 保留两位小数,进行四舍五入
     * @param d
     * @return
     */
    public static Double saveOneBitTwoRound(Double d){
        BigDecimal bd = new BigDecimal(d);
        Double tem = bd.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        return tem;
    }


}
