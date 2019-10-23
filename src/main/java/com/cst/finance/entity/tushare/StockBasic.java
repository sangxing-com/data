package com.cst.finance.entity.tushare;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "StockBasic")
public class StockBasic implements Serializable {
    @Id
    private String id;
    @Field("TsCode")  //TS代码
    private String TsCode;
    @Field("Symbol")  //股票代码
    private String Symbol;
    @Field("Name")   //股票名称
    private String Name;
    @Field("Area")   //所在地域
    private String Area;
    @Field("Industry")  //所属行业
    private String Industry;
    @Field("FullName")  //股票全称
    private String FullName;
    @Field("EnName")   //英文全称
    private String EnName;
    @Field("Market")   //市场类型 （主板/中小板/创业板/科创板）
    private String Market;
    @Field("Exchange")  //交易所代码
    private String Exchange;
    @Field("CurrType")  //交易货币
    private String CurrType;
    @Field("ListStatus")  //上市状态： L上市 D退市 P暂停上市
    private String ListStatus;
    @Field("ListDate")   //上市日期
    private String ListDate;
    @Field("DelistDate")  //退市日期
    private String DelistDate;
    @Field("IsHs")  //是否沪深港通标的，N否 H沪股通 S深股通
    private String IsHs;

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

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getIndustry() {
        return Industry;
    }

    public void setIndustry(String industry) {
        Industry = industry;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getEnName() {
        return EnName;
    }

    public void setEnName(String enName) {
        EnName = enName;
    }

    public String getMarket() {
        return Market;
    }

    public void setMarket(String market) {
        Market = market;
    }

    public String getExchange() {
        return Exchange;
    }

    public void setExchange(String exchange) {
        Exchange = exchange;
    }

    public String getCurrType() {
        return CurrType;
    }

    public void setCurrType(String currType) {
        CurrType = currType;
    }

    public String getListStatus() {
        return ListStatus;
    }

    public void setListStatus(String listStatus) {
        ListStatus = listStatus;
    }

    public String getListDate() {
        return ListDate;
    }

    public void setListDate(String listDate) {
        ListDate = listDate;
    }

    public String getDelistDate() {
        return DelistDate;
    }

    public void setDelistDate(String delistDate) {
        DelistDate = delistDate;
    }

    public String getIsHs() {
        return IsHs;
    }

    public void setIsHs(String isHs) {
        IsHs = isHs;
    }
}
