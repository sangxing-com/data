package com.cst.finance.service;

import com.cst.finance.dao.EntProfitDao;
import com.cst.finance.entity.EntProfit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntProfitServiceImpl implements EntProfitService {

    @Autowired
    EntProfitDao entProfitDao;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public int addEntProfits(List<EntProfit> entProfits) {
        try{
            if(entProfits.size()>0){
                delEntProfits(entProfits.get(0).getSysEntAccountBookDetID());
            }
            mongoTemplate.insertAll(entProfits);
            return 1;
        }catch (Exception ce){
            return 0;
        }
    }

    @Override
    public int delEntProfits(String SysEntAccountBookDetID) {
        try {
            Query query=new Query();
            Criteria criteria=new Criteria();
            criteria.and("SysEntAccountBookDetID").is(SysEntAccountBookDetID);
            query.addCriteria(criteria);
            mongoTemplate.remove(query,EntProfit.class);
            return 1;
        }catch (Exception ce){
            return 0;
        }
    }
}
