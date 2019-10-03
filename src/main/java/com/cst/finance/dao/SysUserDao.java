package com.cst.finance.dao;

import com.cst.finance.entity.SysUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface SysUserDao extends MongoRepository<SysUser,String> {

}
