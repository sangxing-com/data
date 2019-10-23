package com.cst.finance.dao.remote;

import com.cst.finance.entity.remote.ServerConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServerConfigDao extends MongoRepository<ServerConfig,String> {
}
