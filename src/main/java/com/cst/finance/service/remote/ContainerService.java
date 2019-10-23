package com.cst.finance.service.remote;

import com.cst.finance.entity.remote.Container;
import com.cst.finance.module.RemoteConnect;

import java.io.FileNotFoundException;
import java.util.List;

public interface ContainerService {

    Container addContainer(Container container);

    int delContainer(String ContainerID);

    List<Container> addContainerList(RemoteConnect remoteConnect,String remoteCommand);

    List<Container> remoteContainer(RemoteConnect remoteConnect,String remoteCommand);

    List<Container> findContainer(Container container);

    Boolean ContainerServer(RemoteConnect remoteConnect) throws FileNotFoundException;
}
