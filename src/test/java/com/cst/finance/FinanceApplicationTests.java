package com.cst.finance;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cst.finance.entity.EntAccountBookDet;
import com.cst.finance.entity.EntUserAccountBookDet;
import com.cst.finance.entity.SysUser;
import com.cst.finance.entity.remote.Container;
import com.cst.finance.module.RemoteConnect;
import com.cst.finance.service.EntAccountBookDetService;
import com.cst.finance.service.EntUserAccountBookDetService;
import com.cst.finance.service.SysUserService;
import com.cst.finance.service.remote.ContainerService;
import com.cst.finance.service.tushare.DailyService;
import com.cst.finance.service.tushare.StockBasicService;
import com.cst.finance.utils.DateTimeUtils;
import com.cst.finance.utils.LogUtils;
import com.cst.finance.utils.RemoteCommandUtil;
import com.cst.finance.utils.remote.StringUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FinanceApplicationTests {

    @Autowired
    DailyService dailyService;

    @Autowired
    SysUserService sysUserService;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    StockBasicService stockBasicService;

    @Autowired
    ContainerService containerService;

    @Autowired
    EntAccountBookDetService entAccountBookDetService;

    @Autowired
    EntUserAccountBookDetService entUserAccountBookDetService;


    public void contextLoads() {

        List<SysUser> sysUserList= sysUserService.findSysUser();

        for(SysUser sysUser:sysUserList){
        //    System.out.println(sysUser.getUserName());
        //    entUserAccountBookDetService.delEntUserAccountBookDetBySysEntAccountBookDetIDAndUserId()
            List<EntAccountBookDet> entAccountBookDetList=entAccountBookDetService.findEntAccountBookDet();
            for (EntAccountBookDet entAccountBookDet:entAccountBookDetList){
                entUserAccountBookDetService.delEntUserAccountBookDetBySysEntAccountBookDetIDAndUserId(sysUser.getUserId(),entAccountBookDet.getSysEntAccountBookDetID());
                EntUserAccountBookDet entUserAccountBookDet=new EntUserAccountBookDet();
                entUserAccountBookDet.setUserId(sysUser.getUserId());
                entUserAccountBookDet.setSysEntAccountBookDetID(entAccountBookDet.getSysEntAccountBookDetID());
                entUserAccountBookDetService.addEntUserAccountBookDet(entUserAccountBookDet);
            }
        }
    }




    public void sshTest()throws IOException {
        RemoteConnect remoteConnect=new RemoteConnect();
        remoteConnect.setIp("134.175.199.68");
        remoteConnect.setUserName("root");
        remoteConnect.setFilePath("C:\\ycx100527");

       // if(RemoteCommandUtil.loginByFileKey(remoteConnect,null)){
           // RemoteCommandUtil.execute("echo -e \"FROM java:8\\nVOLUME /tmp\\nADD finance-0.0.1-SNAPSHOT.jar app.jar\\nRUN sh -c 'touch /app.jar'\\nENV JAVA_OPTS=\"\"\\nENTRYPOINT [\"java\",\"-Djava.security.egd=file:/dev/./urandom\",\"-jar\",\"/app.jar\"]\" >> /usr/local/project/server3/Dockerfile");
       // }

        if(RemoteCommandUtil.loginByFileKey(remoteConnect,null)){
            RemoteCommandUtil.execute("docker build -t finance13 /usr/local/project/server3/");
        }

        //docker run --name finance13 -d -p 8080:8080 finance13

      //  containerService.addContainerList(remoteConnect,"docker container ls -a");

      //  echo -e "FROM java:8\nVOLUME /tmp\nADD finance-0.0.1-SNAPSHOT.jar app.jar\nRUN sh -c 'touch /app.jar'\nENV JAVA_OPTS=""\nENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]" >> /usr/local/project/server3/Dockerfile

     // docker build -t finance13 /usr/local/project/server3/

     //   RemoteCommandUtil.scpPut(remoteConnect,"C:\\Project\\GitData\\data\\target\\finance-0.0.1-SNAPSHOT.jar","/usr/local/project/server3/");

     //   docker stop ac9ea8003e98
              //  ac9ea8003e98
//[root@VM_0_14_centos server3]# docker restart ac9ea8003e98
              //  ac9ea8003e98
//[root@VM_0_14_centos server3]# docker stop ac9ea8003e98
               // ac9ea8003e98
//[root@VM_0_14_centos server3]# docker rm -f ac9ea8003e98
                //ac9ea8003e98
//[root@VM_0_14_centos server3]# docker container ls -a

    }

    public void GetDaily(){
      //  dailyService.addDaily("600171.SH","上海贝岭","20190701", DateTimeUtils.getDateNow1());
        dailyService.addAllDaily();
    }

    public void GetTushare1(){
        stockBasicService.addStockBasic();
    }

    public void logTest() {
        Logger log = LogUtils.getExceptionLogger();
        Logger log1 = LogUtils.getBussinessLogger();
        Logger log2 = LogUtils.getDBLogger();

        log.error("getExceptionLogger===日志测试");
        log1.info("getBussinessLogger===日志测试");
        log2.debug("getDBLogger===日志测试");
    }

    public void GetTushare(){

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("list_status", "L");

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("api_name", "stock_basic");
        jsonObject2.put("token", "fb70b6a8db7310a7ef7938a43dbd7b15beb021685cfe21267858f4c5");
        jsonObject2.put("params",jsonObject1);
        jsonObject2.put("fields","");
        System.out.println("jsonObject2：" + jsonObject2);

        String ans=  this.restTemplate.postForObject("http://api.waditu.com",jsonObject2,String.class);
        System.out.println(ans);

        //解析
        JSONObject jsonObject=JSONObject.parseObject(ans);
        JSONObject jsonObject3=JSONObject.parseObject(jsonObject.getString("data"));
        //System.out.println(jsonObject3);
        JSONArray jsonArray=JSONObject.parseArray(jsonObject3.getString("items"));

        for (int i=0;i<jsonArray.size();i++){
            JSONArray o = (JSONArray) jsonArray.get(i);
            System.out.println("data"+o.get(2));
        }
    }


    public void addSysUser(){
        SysUser sysUser=new SysUser();
        sysUser.setUserName("yuan");
        sysUser.setUserPwd("100527");
        sysUser.setRegisterTime(new Date());

        sysUserService.addSysUser(sysUser);
    }

    public void delSysUser(){
        sysUserService.delSysUser("5d9448a72c3af90dcc039684");
    }

    public void updateSysUser(){
        sysUserService.updateSysUser("5d9465e02c3af90a64ff90cd","zhifeng","145623");
    }

    public void findSysUserByName(){
        List<SysUser> sysUserList=sysUserService.findSysUserByName("g");
        for (SysUser i:sysUserList
             ) {
            System.out.println(i.getUserName()+"----"+i.getUserPwd());
        }
    }



}
