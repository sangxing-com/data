package com.cst.finance.service;

import com.cst.finance.entity.EntImportData;

import java.util.List;

public interface EntImportDataService {

    int addEntImportDatas(List<EntImportData> entImportDatas);

    int delEntImportDatas(String SysEntAccountBookDetID);
}
