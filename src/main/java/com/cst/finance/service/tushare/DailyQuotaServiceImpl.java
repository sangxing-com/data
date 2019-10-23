package com.cst.finance.service.tushare;

import com.cst.finance.entity.tushare.DailyQuota;
import com.cst.finance.entity.tushare.StockBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyQuotaServiceImpl implements DailyQuotaService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public int addDailyQuota(DailyQuota dailyQuota) {
        try {
            mongoTemplate.insert(dailyQuota);
            return 1;
        }catch (Exception ce){
            return 0;
        }
    }

    @Override
    public int delDailyQuota(DailyQuota dailyQuota) {
        try{
            Query query=new Query();
            Criteria criteria=new Criteria();
            criteria.and("TsCode").is(dailyQuota.getTsCode());
            criteria.and("TradeDate").is(dailyQuota.getTradeDate());
            query.addCriteria(criteria);
            mongoTemplate.remove(query,DailyQuota.class);
            return 1;
        }catch (Exception ce){
            return 0;
        }
    }
}
