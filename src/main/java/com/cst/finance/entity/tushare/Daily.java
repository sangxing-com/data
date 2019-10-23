package com.cst.finance.entity.tushare;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "Daily")
public class Daily implements Serializable {

    @Id
    private String id;
    @Field("TsCode")  //TS代码
    private String TsCode;
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
    @Field("PreClose")
    private double PreClose;
    @Field("Change")
    private double Change;
    @Field("PctChg")
    private double PctChg;
    @Field("Vol")
    private double Vol;
    @Field("Amount")
    private double Amount;

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

    public double getPreClose() {
        return PreClose;
    }

    public void setPreClose(double preClose) {
        PreClose = preClose;
    }

    public double getChange() {
        return Change;
    }

    public void setChange(double change) {
        Change = change;
    }

    public double getPctChg() {
        return PctChg;
    }

    public void setPctChg(double pctChg) {
        PctChg = pctChg;
    }

    public double getVol() {
        return Vol;
    }

    public void setVol(double vol) {
        Vol = vol;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }
}
