package com.cst.finance.dao;

import com.cst.finance.entity.EntUserAccountBookDet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntUserAccountBookDetDao extends MongoRepository<EntUserAccountBookDet,String> {
}
