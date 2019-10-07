package com.cst.finance.controller;

import com.alibaba.fastjson.JSONArray;
import com.cst.finance.entity.EntFinaData;
import com.cst.finance.module.ParametersMod;
import com.cst.finance.service.EntFinaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entfinadata")
public class EntFinaDataController {

    @Autowired
    EntFinaDataService entFinaDataService;

    @PostMapping("/create")
    private int create(ParametersMod param){
        List<EntFinaData> entFinaData= JSONArray.parseArray(param.getDataJson(),EntFinaData.class);
        return entFinaDataService.addEntFinaDatas(entFinaData);
    }
}
