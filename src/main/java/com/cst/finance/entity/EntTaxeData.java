package com.cst.finance.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "EntTaxeData")
public class EntTaxeData implements Serializable {

    @Id
    private String id;
    @Field("SysEntAccountBookDetID")
    private String SysEntAccountBookDetID;
    @Field("YearNo")
    private String YearNo;
    @Field("MonthNo")
    public String MonthNo;
    @Field("fCode")
    public String fCode;
    @Field("fName")
    public String fName;
    @Field("Amount")
    public String Amount;
    @Field("fAmount")
    public String fAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSysEntAccountBookDetID() {
        return SysEntAccountBookDetID;
    }

    public void setSysEntAccountBookDetID(String sysEntAccountBookDetID) {
        SysEntAccountBookDetID = sysEntAccountBookDetID;
    }

    public String getYearNo() {
        return YearNo;
    }

    public void setYearNo(String yearNo) {
        YearNo = yearNo;
    }

    public String getMonthNo() {
        return MonthNo;
    }

    public void setMonthNo(String monthNo) {
        MonthNo = monthNo;
    }

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getfAmount() {
        return fAmount;
    }

    public void setfAmount(String fAmount) {
        this.fAmount = fAmount;
    }
}
