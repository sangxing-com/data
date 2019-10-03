package com.cst.finance.service;

import com.cst.finance.entity.EntAccountBookDet;

public interface EntAccountBookDetService {

    EntAccountBookDet addEntAccountBookDet(EntAccountBookDet entAccountBookDet);

    int delEntAccountBookDet(String sysEntAccountBookDetID);

}
