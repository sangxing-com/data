package com.cst.finance.controller;

import com.alibaba.fastjson.JSONArray;
import com.cst.finance.entity.SysUser;
import com.cst.finance.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sysuser")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

    @PostMapping("/create")
    private SysUser create(@RequestBody String param){
        SysUser sysUser= JSONArray.parseObject(param,SysUser.class);
        return sysUserService.addSysUser(sysUser);
    }

}
