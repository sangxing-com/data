package com.cst.finance.entity.tushare;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "DailyQuota")
public class DailyQuota implements Serializable {

    @Id
    private String id;
    @Field("TsCode")  //TS代码
    private String TsCode;
    @Field("Name")
    private String Name;
    @Field("TradeDate")
    private String TradeDate;
    @Field("Open")
    private double Open;
    @Field("High")
    private double High;
    @Field("Low")
    private double Low;
    @Field("Close")
    private double Close;
    @Field("PreMA5")
    private double PreMA5;
    @Field("PreMA10")
    private double PreMA10;
    @Field("PreMA20")
    private double PreMA20;
    @Field("PreMA30")
    private double PreMA30;
    @Field("Vol")
    private double Vol;
    @Field("VolMA5")
    private double VolMA5;
    @Field("VolMA10")
    private double VolMA10;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTsCode() {
        return TsCode;
    }

    public void setTsCode(String tsCode) {
        TsCode = tsCode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTradeDate() {
        return TradeDate;
    }

    public void setTradeDate(String tradeDate) {
        TradeDate = tradeDate;
    }

    public double getOpen() {
        return Open;
    }

    public void setOpen(double open) {
        Open = open;
    }

    public double getHigh() {
        return High;
    }

    public void setHigh(double high) {
        High = high;
    }

    public double getLow() {
        return Low;
    }

    public void setLow(double low) {
        Low = low;
    }

    public double getClose() {
        return Close;
    }

    public void setClose(double close) {
        Close = close;
    }

    public double getPreMA5() {
        return PreMA5;
    }

    public void setPreMA5(double preMA5) {
        PreMA5 = preMA5;
    }

    public double getPreMA10() {
        return PreMA10;
    }

    public void setPreMA10(double preMA10) {
        PreMA10 = preMA10;
    }

    public double getPreMA20() {
        return PreMA20;
    }

    public void setPreMA20(double preMA20) {
        PreMA20 = preMA20;
    }

    public double getPreMA30() {
        return PreMA30;
    }

    public void setPreMA30(double preMA30) {
        PreMA30 = preMA30;
    }

    public double getVol() {
        return Vol;
    }

    public void setVol(double vol) {
        Vol = vol;
    }

    public double getVolMA5() {
        return VolMA5;
    }

    public void setVolMA5(double volMA5) {
        VolMA5 = volMA5;
    }

    public double getVolMA10() {
        return VolMA10;
    }

    public void setVolMA10(double volMA10) {
        VolMA10 = volMA10;
    }
}
