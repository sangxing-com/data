package com.cst.finance.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "EntUserAccountBookDet")
public class EntUserAccountBookDet implements Serializable {

    @Id
    private String id;
    @Field("UserId")
    private String UserId;
    @Field("SysEntAccountBookDetID")
    private String SysEntAccountBookDetID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getSysEntAccountBookDetID() {
        return SysEntAccountBookDetID;
    }

    public void setSysEntAccountBookDetID(String sysEntAccountBookDetID) {
        SysEntAccountBookDetID = sysEntAccountBookDetID;
    }
}
