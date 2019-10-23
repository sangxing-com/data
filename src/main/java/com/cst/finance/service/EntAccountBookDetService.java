package com.cst.finance.service;

import com.cst.finance.entity.EntAccountBookDet;

import java.util.List;

public interface EntAccountBookDetService {

    EntAccountBookDet addEntAccountBookDet(EntAccountBookDet entAccountBookDet);

    int delEntAccountBookDet(String sysEntAccountBookDetID);

    int delAllEntAccountBookDet(String sysEntAccountBookDetID);

    EntAccountBookDet findEntAccountBookDetBySysEntAccountBookDetID(String sysEntAccountBookDetID);

    List<EntAccountBookDet> findEntAccountBookDet();

}
