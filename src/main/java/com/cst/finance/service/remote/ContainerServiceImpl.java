package com.cst.finance.service.remote;

import com.cst.finance.entity.remote.Container;
import com.cst.finance.entity.remote.ServerConfig;
import com.cst.finance.module.RemoteConnect;
import com.cst.finance.utils.LogUtils;
import com.cst.finance.utils.RemoteCommandUtil;
import com.cst.finance.utils.remote.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContainerServiceImpl implements ContainerService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    ServerConfigService serverConfigService;

    Logger log = LogUtils.getExceptionLogger();

    /**
     * 保存docker镜像文件
     * @param container
     * @return
     */
    @Override
    public Container addContainer(Container container) {
        try{
            container=mongoTemplate.insert(container);
            log.info("===========================================>addContainer class add Container success");
            return container;
        }catch (Exception ce){
            log.info("===========================================>addContainer class add Container faile :"+ce.toString());
            return null;
        }
    }

    /**
     * 删除docker镜像文件 by ContainerID
     * @param ContainerID
     * @return
     */
    @Override
    public int delContainer(String ContainerID) {
        try {
            Query query=new Query();
            Criteria criteria=new Criteria();
            criteria.and("ContainerID").is(ContainerID);
            query.addCriteria(criteria);
            mongoTemplate.remove(query,Container.class);
            log.info("===========================================>delContainer class del Container success");
            return 1;
        }catch (Exception ce){
            log.info("===========================================>delContainer class del Container faile :"+ce.toString());
            return 0;
        }
    }

    /**
     * 批量添加docker镜像文件
     * @param remoteConnect
     * @param remoteCommand
     * @return
     */
    @Override
    public List<Container> addContainerList(RemoteConnect remoteConnect,String remoteCommand) {
        try{
            List<Container> containerList=remoteContainer(remoteConnect,remoteCommand);
            for(Container container:containerList){
                delContainer(container.getContainerID());
                addContainer(container);
            }
            log.info("===========================================>addContainerList class add ContainerList success");
            return containerList;
        }catch (Exception ce){
            log.info("===========================================>addContainerList class add ContainerList faile : "+ce.toString());
            return null;
        }
    }

    /**
     * 连接服务器获取docker镜像文件
     * @param remoteConnect
     * @param remoteCommand
     * @return
     */
    @Override
    public List<Container> remoteContainer(RemoteConnect remoteConnect,String remoteCommand) {
        List<Container> containerList=new ArrayList<>();
        File keyfile = new File(remoteConnect.getFilePath());
        RemoteCommandUtil.loginByFileKey(remoteConnect,keyfile,null);
        String result=RemoteCommandUtil.execute(remoteCommand);
        String[] results=result.split("\n");
        for(int i=0;i<results.length-1;i++){
            int m=0;
            Container container=new Container();
            String strDeal=results[i+1];
            List<String> ContainerStrs= StringUtils.StringSplit(strDeal);
            for(String str:ContainerStrs){
                if(m==0){
                    container.setContainerID(str);
                    m++;
                }else if(m==1){
                    container.setImage(str);
                    m++;
                }else if(m==2){
                    container.setCommand(str);
                    m++;
                }else if(m==3){
                    container.setCreated(str);
                    m++;
                }else if(m==4){
                    container.setStatus(str);
                    if(str.indexOf("Exited")==1){
                        m++;
                    }
                    m++;
                }else if(m==5){
                    container.setPorts(str);
                    m++;
                }else if(m==6){
                    container.setNames(str);
                    m++;
                }else{

                }
            }
            containerList.add(container);
        }
        return containerList;
    }


    /**
     * 服务器连接 保存连接配置
     * @param remoteConnect
     * @return
     */
    @Override
    public Boolean ContainerServer(RemoteConnect remoteConnect){
        try {
            String path = ResourceUtils.getURL("classpath:").getPath();
            System.out.println(path);
            path= path+remoteConnect.getFilePath();
            remoteConnect.setFilePath(path);
            if(RemoteCommandUtil.loginByFileKey(remoteConnect,null)){
                ServerConfig serverConfig=new ServerConfig();
                serverConfig.setServerIp(remoteConnect.getIp());
                serverConfig.setUserName(remoteConnect.getUserName());
                serverConfig.setPassWord(remoteConnect.getPassWord());
                serverConfig.setFilePath(remoteConnect.getFilePath());
                serverConfigService.addServerConfig(serverConfig);
                log.info("===========================================>ContainerServer class  ContainerServer success");
                return true;
            }else{
                log.info("===========================================>ContainerServer class  ContainerServer error");
                return false;
            }
        }catch (Exception ce){
            log.info("===========================================>ContainerServer class  ContainerServer faile : "+ce.toString());
            return false;
        }
    }

    /**
     * 查询docker镜像
     * @param container
     * @return
     */
    @Override
    public List<Container> findContainer(Container container) {
        Query query=new Query();
        Criteria criteria=new Criteria();
        query.addCriteria(criteria);
        return mongoTemplate.find(query,Container.class);
    }
}
