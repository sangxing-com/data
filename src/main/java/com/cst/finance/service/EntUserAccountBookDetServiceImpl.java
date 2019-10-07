package com.cst.finance.service;

import com.cst.finance.dao.EntUserAccountBookDetDao;
import com.cst.finance.entity.EntUserAccountBookDet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntUserAccountBookDetServiceImpl implements EntUserAccountBookDetService {

    @Autowired
    EntUserAccountBookDetDao entUserAccountBookDetDao;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public EntUserAccountBookDet addEntUserAccountBookDet(EntUserAccountBookDet entUserAccountBookDet) {
        return mongoTemplate.save(entUserAccountBookDet,"EntUserAccountBookDet");
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
