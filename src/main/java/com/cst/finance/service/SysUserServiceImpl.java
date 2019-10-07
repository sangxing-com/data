package com.cst.finance.service;

import com.cst.finance.dao.SysUserDao;
import com.cst.finance.entity.SysUser;
import com.cst.finance.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserDao sysUserDao;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public SysUser addSysUser(SysUser sysUser) {
        if(sysUser.getUserId()==null)
            sysUser.setUserId(CommonUtils.getUUID());
        return mongoTemplate.save(sysUser,"SysUser");
    }

    @Override
    public int delSysUser(String id) {
        Query query=new Query();
        Criteria criteria=new Criteria();
        criteria.and("_id").is(id);
        query.addCriteria(criteria);
        mongoTemplate.remove(query,SysUser.class);
        return 0;
    }

    @Override
    public int updateSysUser(String id, String UserName, String UserPwd) {
        Query query=new Query();
        Criteria criteria=new Criteria();
        criteria.and("_id").is(id);

        Update update=new Update();
        update.set("UserName",UserName);
        update.set("UserPwd",UserPwd);
        mongoTemplate.updateFirst(query,update,SysUser.class);
        return 0;
    }


    @Override
    public List<SysUser> findSysUserByName(String userName) {
        //Query query=new Query(Criteria.where("UserName").is(userName).and("UserPwd").is("100527"));
      //  return sysUserDao.findByUsernameLike(userName);
        Query query=new Query();
        Criteria criteria=new Criteria();
        criteria.and("UserName").regex(userName);
        query.addCriteria(criteria);
        return mongoTemplate.find(query,SysUser.class);
    }

    @Override
    public List<SysUser> findSysUserByUserNameAndUserPwd(SysUser sysUser) {
        Query query=new Query();
        Criteria criteria=new Criteria();
        criteria.and("UserTel").is(sysUser.getUserTel());
        criteria.and("UserPwd").is(sysUser.getUserPwd());
        query.addCriteria(criteria);
        return mongoTemplate.find(query,SysUser.class);
    }
}
