package com.cst.finance.service;

import com.cst.finance.entity.EntTaxeData;
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
            mongoTemplate.remove(query,EntTaxeData.class);
            return 1;
        }catch (Exception ce){
            return 0;
        }
    }
}
