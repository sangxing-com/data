package com.cst.finance.service;

import com.cst.finance.entity.EntTaxeData;

import java.util.List;

public interface EntTaxeDataService {

    int addEntTaxeDatas(List<EntTaxeData> entTaxeDatas);

    int delEntTaxeDatas(String SysEntAccountBookDetID);
}
