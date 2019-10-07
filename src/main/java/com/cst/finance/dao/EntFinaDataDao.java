package com.cst.finance.dao;

import com.cst.finance.entity.EntFinaData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntFinaDataDao extends MongoRepository<EntFinaData,String> {
}
