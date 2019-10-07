package com.cst.finance.service;

import com.cst.finance.entity.EntFinaData;

import java.util.List;

public interface EntFinaDataService {

    int addEntFinaDatas(List<EntFinaData> entFinaDatas);

    int delEntFinaDatas(String SysEntAccountBookDetID);
}
