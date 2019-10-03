package com.cst.finance.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "EntAccountBookDet")
public class EntAccountBookDet implements Serializable {

    @Id
    private String id;
    @Field("SysEntAccountBookDetID")
    private String SysEntAccountBookDetID;
    @Field("AccountYear")
    private String AccountYear;
    @Field("EntCode")
    private String EntCode;
    @Field("EntName")
    private  String EntName;
    @Field("AccountName")
    private String AccountName;

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

    public String getAccountYear() {
        return AccountYear;
    }

    public void setAccountYear(String accountYear) {
        AccountYear = accountYear;
    }

    public String getEntCode() {
        return EntCode;
    }

    public void setEntCode(String entCode) {
        EntCode = entCode;
    }

    public String getEntName() {
        return EntName;
    }

    public void setEntName(String entName) {
        EntName = entName;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }
}
