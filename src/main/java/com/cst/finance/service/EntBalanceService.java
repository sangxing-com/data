package com.cst.finance.service;

import com.cst.finance.entity.EntBalance;

import java.util.List;

public interface EntBalanceService {

    int addEntBalances(List<EntBalance> entBalances);

    int delEntBalances(String SysEntAccountBookDetID);
}
