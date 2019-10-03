package com.cst.finance.dao;

import com.cst.finance.entity.EntAccountBookDet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntAccountBookDetDao extends MongoRepository<EntAccountBookDet,String> {

}
