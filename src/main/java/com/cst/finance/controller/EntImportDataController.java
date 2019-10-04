package com.cst.finance.controller;

import com.alibaba.fastjson.JSONArray;
import com.cst.finance.entity.EntImportData;
import com.cst.finance.module.ParametersMod;
import com.cst.finance.service.EntImportDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entimportdata")
public class EntImportDataController {

    @Autowired
    EntImportDataService entImportDataService;

    @PostMapping("/create")
    private int create(ParametersMod param){
        List<EntImportData> entImportDatas= JSONArray.parseArray(param.getDataJson(),EntImportData.class);
        return entImportDataService.addEntImportDatas(entImportDatas);
    }
}
