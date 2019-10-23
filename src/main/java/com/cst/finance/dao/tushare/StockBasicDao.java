package com.cst.finance.dao.tushare;

import com.cst.finance.entity.tushare.StockBasic;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockBasicDao extends MongoRepository<StockBasic,String> {
}
