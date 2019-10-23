package com.cst.finance.controller.remote;

import com.alibaba.fastjson.JSONArray;
import com.cst.finance.entity.remote.Container;
import com.cst.finance.entity.remote.ServerConfig;
import com.cst.finance.module.RemoteConnect;
import com.cst.finance.service.remote.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/remote/remoteconnect")
public class RemoteConnectController {

    @Autowired
    ContainerService containerService;

    @PostMapping("/conn")
    private Boolean conn(@RequestBody String param) throws FileNotFoundException {
        RemoteConnect remoteConnect= JSONArray.parseObject(param,RemoteConnect.class);
        return containerService.ContainerServer(remoteConnect);
    }

    @PostMapping("/find")
    private List<Container> find(@RequestBody String param){
        Container container=JSONArray.parseObject(param,Container.class);
        return containerService.findContainer(container);
    }
}
