package com.cst.finance.dao;

import com.cst.finance.entity.EntTaxeData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntTaxeDataDao extends MongoRepository<EntTaxeData,String> {
}
