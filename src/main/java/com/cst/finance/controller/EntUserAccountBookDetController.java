package com.cst.finance.controller;

import com.alibaba.fastjson.JSONArray;
import com.cst.finance.entity.EntAccountBookDet;
import com.cst.finance.entity.EntUserAccountBookDet;
import com.cst.finance.module.ParametersMod;
import com.cst.finance.service.EntAccountBookDetService;
import com.cst.finance.service.EntUserAccountBookDetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/entuseraccountbookdet")
public class EntUserAccountBookDetController {

    @Autowired
    EntUserAccountBookDetService entUserAccountBookDetService;

    @Autowired
    EntAccountBookDetService entAccountBookDetService;

    @PostMapping("/create")
    private EntUserAccountBookDet create(@RequestBody String param){
        EntUserAccountBookDet entUserAccountBookDet= JSONArray.parseObject(param,EntUserAccountBookDet.class);
        return entUserAccountBookDetService.addEntUserAccountBookDet(entUserAccountBookDet);
    }

    @PostMapping("/findall")
    private List<EntAccountBookDet> findall(@RequestBody String param){
        List<EntUserAccountBookDet> entUserAccountBookDets0=JSONArray.parseArray(param,EntUserAccountBookDet.class);
        List<EntUserAccountBookDet> entUserAccountBookDets= entUserAccountBookDetService.findEntUserAccountBookDetByUserId(entUserAccountBookDets0.get(0).getUserId());
        List<EntAccountBookDet> entAccountBookDets=new ArrayList<EntAccountBookDet>();  ;
        for (EntUserAccountBookDet entUserAccountBookDet1:entUserAccountBookDets
             ) {
            EntAccountBookDet entAccountBookDet= entAccountBookDetService.findEntAccountBookDetBySysEntAccountBookDetID(entUserAccountBookDet1.getSysEntAccountBookDetID());
            entAccountBookDets.add(entAccountBookDet);
        }
        return  entAccountBookDets;
    }

}
