package com.cst.finance.service;

import com.cst.finance.dao.EntImportDataDao;
import com.cst.finance.entity.EntImportData;
import com.cst.finance.utils.LogUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntImportDataServiceImpl implements EntImportDataService {

    @Autowired
    EntImportDataDao entImportDataDao;

    @Autowired
    MongoTemplate mongoTemplate;

    Logger log = LogUtils.getExceptionLogger();

    @Override
    public int addEntImportDatas(List<EntImportData> entImportDatas) {
        try{
            if(entImportDatas.size()>0){
                delEntImportDatas(entImportDatas.get(0).getSysEntAccountBookDetID());
            }
            mongoTemplate.insertAll(entImportDatas);
            return 1;
        }catch (Exception ce){
            return 0;
        }
    }

    @Override
    public int delEntImportDatas(String SysEntAccountBookDetID) {
        try{
            Query query=new Query();
            Criteria criteria=new Criteria();
            criteria.and("SysEntAccountBookDetID").is(SysEntAccountBookDetID);
            query.addCriteria(criteria);
            mongoTemplate.remove(query,EntImportData.class);
            log.info("===========================================>delEntImportDatas class EntImportDatas delete success");
            return 1;
        }catch (Exception ce){
            log.info("===========================================>delEntImportDatas class EntImportDatas delete faile:"+ce.toString());
            return 0;
        }
    }

    @Override
    public List<EntImportData> findEntImportDataBySysEntAccountBookDetIDAndMonthNo(EntImportData entImportData) {
        Query query=new Query();
        Criteria criteria=new Criteria();
        criteria.and("SysEntAccountBookDetID").is(entImportData.getSysEntAccountBookDetID());
        criteria.and("MonthNo").is(entImportData.getMonthNo());
        query.addCriteria(criteria);
        return mongoTemplate.find(query,EntImportData.class);
    }
}
