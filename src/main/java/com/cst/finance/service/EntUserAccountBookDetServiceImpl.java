package com.cst.finance.service;

import com.cst.finance.dao.EntUserAccountBookDetDao;
import com.cst.finance.entity.EntUserAccountBookDet;
import com.cst.finance.utils.LogUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;

@Service
public class EntUserAccountBookDetServiceImpl implements EntUserAccountBookDetService {

    @Autowired
    EntUserAccountBookDetDao entUserAccountBookDetDao;

    @Autowired
    MongoTemplate mongoTemplate;

    Logger log = LogUtils.getExceptionLogger();

    @Override
    public EntUserAccountBookDet addEntUserAccountBookDet(EntUserAccountBookDet entUserAccountBookDet) {
        return mongoTemplate.save(entUserAccountBookDet,"EntUserAccountBookDet");
    }

    @Override
    public int delEntUserAccountBookDet(String SysEntAccountBookDetID) {
        try {
            Query query=new Query();
            Criteria criteria=new Criteria();
            criteria.and("SysEntAccountBookDetID").is(SysEntAccountBookDetID);
            query.addCriteria(criteria);
            mongoTemplate.remove(query,EntUserAccountBookDet.class);
            log.info("===========================================>delEntUserAccountBookDet class EntUserAccountBookDet delete success");
            return 1;
        }catch (Exception ce){
            log.info("===========================================>delEntUserAccountBookDet class EntUserAccountBookDet delete faile:"+ce.toString());
            return 0;
        }

    }

    @Override
    public int delEntUserAccountBookDetBySysEntAccountBookDetIDAndUserId(String UserId, String SysEntAccountBookDetID) {
        try {
            Query query=new Query();
            Criteria criteria=new Criteria();
            criteria.and("SysEntAccountBookDetID").is(SysEntAccountBookDetID);
            criteria.and("UserId").is(UserId);
            query.addCriteria(criteria);
            mongoTemplate.remove(query,EntUserAccountBookDet.class);
            log.info("===========================================>delEntUserAccountBookDetBySysEntAccountBookDetIDAndUserId class EntUserAccountBookDet delete success");
            return 1;
        }catch (Exception ce){
            log.info("===========================================>delEntUserAccountBookDetBySysEntAccountBookDetIDAndUserId class EntUserAccountBookDet delete fail :"+ce.toString());
            return 0;
        }
    }

    @Override
    public List<EntUserAccountBookDet> findEntUserAccountBookDetByUserId(String userId) {
        Query query=new Query();
        Criteria criteria=new Criteria();
        criteria.and("UserId").is(userId);
        query.addCriteria(criteria);
        return mongoTemplate.find(query,EntUserAccountBookDet.class);
    }
}
