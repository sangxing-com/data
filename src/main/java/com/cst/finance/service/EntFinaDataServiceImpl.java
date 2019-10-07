package com.cst.finance.service;

import com.cst.finance.dao.EntFinaDataDao;
import com.cst.finance.entity.EntFinaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntFinaDataServiceImpl implements EntFinaDataService {

    @Autowired
    EntFinaDataDao entFinaDataDao;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public int addEntFinaDatas(List<EntFinaData> entFinaDatas) {
        try {
            if(entFinaDatas.size()>0){
                delEntFinaDatas(entFinaDatas.get(0).getSysEntAccountBookDetID());
            }
            mongoTemplate.insertAll(entFinaDatas);
        }catch (Exception ce){
            return 0;
        }

        return 0;
    }

    @Override
    public int delEntFinaDatas(String SysEntAccountBookDetID) {
        try{
            Query query=new Query();
            Criteria criteria=new Criteria();
            criteria.and("SysEntAccountBookDetID").is(SysEntAccountBookDetID);
            query.addCriteria(criteria);
            mongoTemplate.remove(query, EntFinaData.class);
        }catch (Exception ce){
            return 0;
        }
        return 0;
    }
}
