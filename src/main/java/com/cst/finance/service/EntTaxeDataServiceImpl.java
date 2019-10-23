package com.cst.finance.service;

import com.cst.finance.entity.EntTaxeData;
import com.cst.finance.utils.LogUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntTaxeDataServiceImpl implements EntTaxeDataService {

    @Autowired
    EntTaxeDataService entTaxeDataService;

    @Autowired
    MongoTemplate mongoTemplate;

    Logger log = LogUtils.getExceptionLogger();

    @Override
    public int addEntTaxeDatas(List<EntTaxeData> entTaxeDatas) {
        try{
            if(entTaxeDatas.size()>0){
                delEntTaxeDatas(entTaxeDatas.get(0).getSysEntAccountBookDetID());
            }
            mongoTemplate.insertAll(entTaxeDatas);
            return  1;
        }catch (Exception ce){
            return 0;
        }
    }

    @Override
    public int delEntTaxeDatas(String SysEntAccountBookDetID) {
        try{
            Query query=new Query();
            Criteria criteria=new Criteria();
            criteria.and("SysEntAccountBookDetID").is(SysEntAccountBookDetID);
            query.addCriteria(criteria);
            mongoTemplate.remove(query,EntTaxeData.class);
            log.info("===========================================>delEntTaxeDatas class EntTaxeDatas delete success");
            return 1;
        }catch (Exception ce){
            log.info("===========================================>delEntTaxeDatas class EntTaxeDatas delete faile:"+ce.toString());
            return 0;
        }
    }

    @Override
    public List<EntTaxeData> findEntTaxeDataBySysEntAccountBookDetIDAndMonthNo(EntTaxeData entTaxeData) {
        Query query=new Query();
        Criteria criteria=new Criteria();
        criteria.and("SysEntAccountBookDetID").is(entTaxeData.getSysEntAccountBookDetID());
        criteria.and("MonthNo").is(entTaxeData.getMonthNo());
        query.addCriteria(criteria);
        return mongoTemplate.find(query,EntTaxeData.class);
    }
}
