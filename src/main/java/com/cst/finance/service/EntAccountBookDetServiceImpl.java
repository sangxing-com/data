package com.cst.finance.service;

import com.cst.finance.entity.EntAccountBookDet;
import com.cst.finance.entity.EntFinaData;
import com.cst.finance.utils.LogUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntAccountBookDetServiceImpl implements EntAccountBookDetService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    EntUserAccountBookDetService entUserAccountBookDetService;

    @Autowired
    EntBalanceService entBalanceService;

    @Autowired
    EntProfitService entProfitService;

    @Autowired
    EntImportDataService entImportDataService;

    @Autowired
    EntTaxeDataService entTaxeDataService;

    @Autowired
    EntFinaDataService entFinaDataService;

    Logger log = LogUtils.getExceptionLogger();

    @Override
    public int delAllEntAccountBookDet(String sysEntAccountBookDetID) {
        delEntAccountBookDet(sysEntAccountBookDetID);
        entUserAccountBookDetService.delEntUserAccountBookDet(sysEntAccountBookDetID);
        entBalanceService.delEntBalances(sysEntAccountBookDetID);
        entProfitService.delEntProfits(sysEntAccountBookDetID);
        entImportDataService.delEntImportDatas(sysEntAccountBookDetID);
        entTaxeDataService.delEntTaxeDatas(sysEntAccountBookDetID);
        entFinaDataService.delEntFinaDatas(sysEntAccountBookDetID);
        return 1;
    }

    @Override
    public EntAccountBookDet addEntAccountBookDet(EntAccountBookDet entAccountBookDet) {
        delEntAccountBookDet(entAccountBookDet.getSysEntAccountBookDetID());
        return mongoTemplate.save(entAccountBookDet);
    }

    @Override
    public int delEntAccountBookDet(String sysEntAccountBookDetID) {
        try {
            Query query=new Query();
            Criteria criteria=new Criteria();
            criteria.and("SysEntAccountBookDetID").is(sysEntAccountBookDetID);
            query.addCriteria(criteria);
            mongoTemplate.remove(query,EntAccountBookDet.class);
            log.info("===========================================>delEntAccountBookDet class EntAccountBookDet delete success");
            return 1;
        }catch (Exception ce){
            log.info("===========================================>delEntAccountBookDet class EntAccountBookDet delete fail:"+ce.toString());
            return 0;
        }
    }

    @Override
    public EntAccountBookDet findEntAccountBookDetBySysEntAccountBookDetID(String sysEntAccountBookDetID) {
        Query query=new Query();
        Criteria criteria=new Criteria();
        criteria.and("SysEntAccountBookDetID").is(sysEntAccountBookDetID);
        query.addCriteria(criteria);
        return mongoTemplate.findOne(query,EntAccountBookDet.class);
    }

    @Override
    public List<EntAccountBookDet> findEntAccountBookDet() {
        Query query=new Query();
        return mongoTemplate.find(query,EntAccountBookDet.class);
    }

}
