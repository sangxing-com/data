package com.cst.finance.dao;

import com.cst.finance.entity.EntImportData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntImportDataDao extends MongoRepository<EntImportData,String> {
}
