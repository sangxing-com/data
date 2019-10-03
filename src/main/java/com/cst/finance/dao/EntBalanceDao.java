package com.cst.finance.dao;

import com.cst.finance.entity.EntBalance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntBalanceDao extends MongoRepository<EntBalance,String> {
}
