package com.cst.finance.service;

import com.cst.finance.dao.EntBalanceDao;
import com.cst.finance.entity.EntBalance;
import com.cst.finance.utils.LogUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntBalanceServiceImpl implements EntBalanceService {

    @Autowired
    EntBalanceDao entBalanceDao;

    @Autowired
    MongoTemplate mongoTemplate;

    Logger log = LogUtils.getExceptionLogger();

    @Override
    public int addEntBalances(List<EntBalance> entBalances) {
        try {
            if(entBalances.size()>0){
                delEntBalances(entBalances.get(0).getSysEntAccountBookDetID());
            }
            mongoTemplate.insertAll(entBalances);
            return 1;
        }catch (Exception ce){
            return 0;
        }
    }

    @Override
    public int delEntBalances(String SysEntAccountBookDetID) {
        try{
            Query query=new Query();
            Criteria criteria=new Criteria();
            criteria.and("SysEntAccountBookDetID").is(SysEntAccountBookDetID);
            query.addCriteria(criteria);
            mongoTemplate.remove(query,EntBalance.class);
            log.info("===========================================>delEntBalances class EntBalances delete success");
            return 1;
        }catch (Exception ce){
            log.info("===========================================>delEntBalances class EntBalances delete faile :"+ce.toString());
            return 0;
        }
    }

    @Override
    public List<EntBalance> findEntBalanceBySysEntAccountBookDetIDAndMonthNo(EntBalance entBalance) {
        Query query=new Query();
        Criteria criteria=new Criteria();
        criteria.and("SysEntAccountBookDetID").is(entBalance.getSysEntAccountBookDetID());
        criteria.and("MonthNo").is(entBalance.getMonthNo());
        query.addCriteria(criteria);
        List<EntBalance> entBalances= mongoTemplate.find(query,EntBalance.class);
        return mongoTemplate.find(query,EntBalance.class);
    }

}
