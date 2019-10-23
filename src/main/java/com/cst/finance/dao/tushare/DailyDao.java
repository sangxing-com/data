package com.cst.finance.dao.tushare;

import com.cst.finance.entity.tushare.Daily;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DailyDao extends MongoRepository<Daily,String> {
}
