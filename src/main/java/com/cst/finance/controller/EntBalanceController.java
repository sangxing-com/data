package com.cst.finance.controller;

import com.alibaba.fastjson.JSONArray;
import com.cst.finance.entity.EntAccountBookDet;
import com.cst.finance.entity.EntBalance;
import com.cst.finance.module.ParametersMod;
import com.cst.finance.service.EntBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entbalance")
public class EntBalanceController {

    @Autowired
    EntBalanceService entBalanceService;

    @PostMapping("/create")
    private int create(ParametersMod param){
        List<EntBalance> entBalances=JSONArray.parseArray(param.getDataJson(),EntBalance.class);
        return entBalanceService.addEntBalances(entBalances);
    }
}
