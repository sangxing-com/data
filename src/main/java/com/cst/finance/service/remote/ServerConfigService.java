package com.cst.finance.service.remote;

import com.cst.finance.entity.remote.ServerConfig;

public interface ServerConfigService {

    ServerConfig addServerConfig(ServerConfig serverConfig);

    int delServerConfig(ServerConfig serverConfig);

}
