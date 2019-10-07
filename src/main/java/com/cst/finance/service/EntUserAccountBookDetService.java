package com.cst.finance.service;

import com.cst.finance.entity.EntUserAccountBookDet;

import java.util.List;

public interface EntUserAccountBookDetService {

    EntUserAccountBookDet addEntUserAccountBookDet(EntUserAccountBookDet entUserAccountBookDet);

    List<EntUserAccountBookDet> findEntUserAccountBookDetByUserId(String userId);
}
