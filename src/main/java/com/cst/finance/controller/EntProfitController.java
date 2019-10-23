package com.cst.finance.controller;

import com.alibaba.fastjson.JSONArray;
import com.cst.finance.entity.EntProfit;
import com.cst.finance.module.ParametersMod;
import com.cst.finance.service.EntProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entprofit")
public class EntProfitController {

    @Autowired
    EntProfitService entProfitService;

    @PostMapping("/create")
    private int create(ParametersMod param){
        List<EntProfit> entProfits= JSONArray.parseArray(param.getDataJson(),EntProfit.class);
        return entProfitService.addEntProfits(entProfits);
    }

    @PostMapping("/findall")
    private List<EntProfit> findall(@RequestBody String param){
        List<EntProfit> entProfits=JSONArray.parseArray(param,EntProfit.class);
        return entProfitService.findEntProfitBySysEntAccountBookDetIDAndMonthNo(entProfits.get(0));
    }

}
