package com.cst.finance.service.remote;

import com.cst.finance.dao.remote.ServerConfigDao;
import com.cst.finance.entity.remote.ServerConfig;
import com.cst.finance.module.RemoteConnect;
import com.cst.finance.utils.LogUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class ServerConfigServiceImpl implements ServerConfigService {

    @Autowired
    ServerConfigDao serverConfigDao;

    @Autowired
    MongoTemplate mongoTemplate;

    Logger log = LogUtils.getExceptionLogger();

    @Override
    public ServerConfig addServerConfig(ServerConfig serverConfig) {
        try {
            delServerConfig(serverConfig);
            serverConfig=mongoTemplate.insert(serverConfig);
            log.info("===========================================>addServerConfig class add ServerConfigdelete success");
            return serverConfig;
        }catch (Exception ce){
            log.info("===========================================>addServerConfig class add ServerConfig faile :"+ce.toString());
            return null;
        }
    }

    @Override
    public int delServerConfig(ServerConfig serverConfig) {
        try{
            Query query=new Query();
            Criteria criteria=new Criteria();
            criteria.and("ServerIp").is(serverConfig.getServerIp());
            criteria.and("UserName").is(serverConfig.getUserName());
            query.addCriteria(criteria);
            mongoTemplate.remove(query,ServerConfig.class);
            log.info("===========================================>delServerConfig class del ServerConfig delete success");
            return 1;
        }catch (Exception ce){
            log.info("===========================================>delServerConfig class del ServerConfig delete faile: "+ce.toString());
            return 0;
        }
    }

}
