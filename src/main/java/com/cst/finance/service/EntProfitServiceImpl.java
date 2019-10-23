package com.cst.finance.service;

import com.cst.finance.dao.EntProfitDao;
import com.cst.finance.entity.EntProfit;
import com.cst.finance.utils.LogUtils;
import org.slf4j.Logger;
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

    Logger log = LogUtils.getExceptionLogger();

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
            log.info("===========================================>delEntProfits class EntProfits delete success");
            return 1;
        }catch (Exception ce){
            log.info("===========================================>delEntProfits class EntProfits delete faile:"+ce.toString());
            return 0;
        }
    }

    @Override
    public List<EntProfit> findEntProfitBySysEntAccountBookDetIDAndMonthNo(EntProfit entProfit) {
        Query query=new Query();
        Criteria criteria=new Criteria();
        criteria.and("SysEntAccountBookDetID").is(entProfit.getSysEntAccountBookDetID());
        criteria.and("MonthNo").is(entProfit.getMonthNo());
        query.addCriteria(criteria);
        return mongoTemplate.find(query,EntProfit.class);
    }
}
