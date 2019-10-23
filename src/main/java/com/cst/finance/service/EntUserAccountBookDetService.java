package com.cst.finance.service;

import com.cst.finance.entity.EntUserAccountBookDet;

import java.util.List;

public interface EntUserAccountBookDetService {

    EntUserAccountBookDet addEntUserAccountBookDet(EntUserAccountBookDet entUserAccountBookDet);

    int delEntUserAccountBookDet(String SysEntAccountBookDetID);

    int delEntUserAccountBookDetBySysEntAccountBookDetIDAndUserId(String UserId,String SysEntAccountBookDetID);

    List<EntUserAccountBookDet> findEntUserAccountBookDetByUserId(String userId);


}
