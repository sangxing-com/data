package com.cst.finance.service;

import com.cst.finance.entity.EntAccountBookDet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class EntAccountBookDetServiceImpl implements EntAccountBookDetService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public EntAccountBookDet addEntAccountBookDet(EntAccountBookDet entAccountBookDet) {
        delEntAccountBookDet(entAccountBookDet.getSysEntAccountBookDetID());
        return mongoTemplate.save(entAccountBookDet);
    }

    @Override
    public int delEntAccountBookDet(String sysEntAccountBookDetID) {
        Query query=new Query();
        Criteria criteria=new Criteria();
        criteria.and("SysEntAccountBookDetID").is(sysEntAccountBookDetID);
        query.addCriteria(criteria);
        mongoTemplate.remove(query,EntAccountBookDet.class);
        return 1;
    }

    @Override
    public EntAccountBookDet findEntAccountBookDetBySysEntAccountBookDetID(String sysEntAccountBookDetID) {
        Query query=new Query();
        Criteria criteria=new Criteria();
        criteria.and("SysEntAccountBookDetID").is(sysEntAccountBookDetID);
        query.addCriteria(criteria);
        return mongoTemplate.findOne(query,EntAccountBookDet.class);
    }

}
