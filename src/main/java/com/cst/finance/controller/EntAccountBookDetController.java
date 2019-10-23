package com.cst.finance.controller;

import com.alibaba.fastjson.JSONArray;
import com.cst.finance.entity.EntAccountBookDet;
import com.cst.finance.module.ParametersMod;
import com.cst.finance.service.EntAccountBookDetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entaccountbookdet")
public class EntAccountBookDetController {

    @Autowired
    EntAccountBookDetService entAccountBookDetService;

    @PostMapping("/create")
    private EntAccountBookDet create(ParametersMod param){
        EntAccountBookDet entAccountBookDet= JSONArray.parseObject(param.getDataJson(),EntAccountBookDet.class);
        return entAccountBookDetService.addEntAccountBookDet(entAccountBookDet);
    }

    @PostMapping("/delall")
    private int delall(ParametersMod param){
        EntAccountBookDet entAccountBookDet= JSONArray.parseObject(param.getDataJson(),EntAccountBookDet.class);
        return entAccountBookDetService.delAllEntAccountBookDet(entAccountBookDet.getSysEntAccountBookDetID());
    }

}
