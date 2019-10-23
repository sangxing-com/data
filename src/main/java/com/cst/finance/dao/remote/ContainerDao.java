package com.cst.finance.dao.remote;

import com.cst.finance.entity.remote.Container;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContainerDao extends MongoRepository<Container,String> {
}
