package com.cst.finance;

import com.cst.finance.entity.SysUser;
import com.cst.finance.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FinanceApplicationTests {

    @Autowired
    SysUserService sysUserService;

    @Test
    public void contextLoads() {
    }


    public void addSysUser(){
        SysUser sysUser=new SysUser();
        sysUser.setUsername("yuan");
        sysUser.setUserpwd("100527");
        sysUser.setRegisterTime(new Date());

        sysUserService.addSysUser(sysUser);

    }


    public void delSysUser(){
        sysUserService.delSysUser("5d9448a72c3af90dcc039684");
    }


    public void updateSysUser(){
        sysUserService.updateSysUser("5d9465e02c3af90a64ff90cd","zhifeng","145623");
    }

   @Test
    public void findSysUserByName(){
        List<SysUser> sysUserList=sysUserService.findSysUserByName("g");
        for (SysUser i:sysUserList
             ) {
            System.out.println(i.getUsername()+"----"+i.getUserpwd());
        }
    }



}
