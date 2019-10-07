package com.cst.finance.entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;
import java.util.PrimitiveIterator;

@Document(collection = "SysUser")
public class SysUser implements Serializable {

    @Id
    private String id;
    @Field("UserId")
    private String UserId;
    @Field("UserName")
    private String UserName;
    @Field("UserPwd")
    private String UserPwd;
    @Field("UserTel")
    private String UserTel;
    @Field("RegisterTime")
    private Date RegisterTime;

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

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPwd() {
        return UserPwd;
    }

    public void setUserPwd(String userPwd) {
        UserPwd = userPwd;
    }

    public String getUserTel() {
        return UserTel;
    }

    public void setUserTel(String userTel) {
        UserTel = userTel;
    }

    public Date getRegisterTime() {
        return RegisterTime;
    }

    public void setRegisterTime(Date registerTime) {
        RegisterTime = registerTime;
    }
}
