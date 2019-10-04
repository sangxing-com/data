package com.cst.finance.dao;

import com.cst.finance.entity.EntProfit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntProfitDao extends MongoRepository<EntProfit,String> {
}
