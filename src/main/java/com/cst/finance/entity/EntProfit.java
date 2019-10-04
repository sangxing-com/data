package com.cst.finance.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "EntProfit")
public class EntProfit implements Serializable {

    @Id
    private String id;
    @Field("SysEntAccountBookDetID")
    private String SysEntAccountBookDetID;
    @Field("YearNo")
    private String YearNo;
    @Field("MonthNo")
    public String MonthNo;
    @Field("ReportItem")
    public String ReportItem;
    @Field("RowNo")
    public String RowNo;
    @Field("CurrentAmount")
    public String CurrentAmount;
    @Field("CurrentYearAmount")
    public String CurrentYearAmount;
    @Field("PreviousAmount")
    public String PreviousAmount;

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

    public String getReportItem() {
        return ReportItem;
    }

    public void setReportItem(String reportItem) {
        ReportItem = reportItem;
    }

    public String getRowNo() {
        return RowNo;
    }

    public void setRowNo(String rowNo) {
        RowNo = rowNo;
    }

    public String getCurrentAmount() {
        return CurrentAmount;
    }

    public void setCurrentAmount(String currentAmount) {
        CurrentAmount = currentAmount;
    }

    public String getCurrentYearAmount() {
        return CurrentYearAmount;
    }

    public void setCurrentYearAmount(String currentYearAmount) {
        CurrentYearAmount = currentYearAmount;
    }

    public String getPreviousAmount() {
        return PreviousAmount;
    }

    public void setPreviousAmount(String previousAmount) {
        PreviousAmount = previousAmount;
    }
}
