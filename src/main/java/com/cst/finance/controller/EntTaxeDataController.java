package com.cst.finance.controller;

import com.alibaba.fastjson.JSONArray;
import com.cst.finance.entity.EntTaxeData;
import com.cst.finance.module.ParametersMod;
import com.cst.finance.service.EntTaxeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/enttaxedata")
public class EntTaxeDataController {

    @Autowired
    EntTaxeDataService entTaxeDataService;

    @PostMapping("/create")
    private int create(ParametersMod param){
        List<EntTaxeData> entTaxeDatas= JSONArray.parseArray(param.getDataJson(),EntTaxeData.class);
        return entTaxeDataService.addEntTaxeDatas(entTaxeDatas);
    }

    @PostMapping("/findall")
    private List<EntTaxeData> findall(@RequestBody String param){
        List<EntTaxeData> entTaxeDatas=JSONArray.parseArray(param,EntTaxeData.class);
        return entTaxeDataService.findEntTaxeDataBySysEntAccountBookDetIDAndMonthNo(entTaxeDatas.get(0));
    }
}
