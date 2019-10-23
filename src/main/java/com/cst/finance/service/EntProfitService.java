package com.cst.finance.service;

import com.cst.finance.entity.EntProfit;

import java.util.List;

public interface EntProfitService {

    int addEntProfits(List<EntProfit> entProfits);

    int delEntProfits(String SysEntAccountBookDetID);

    List<EntProfit> findEntProfitBySysEntAccountBookDetIDAndMonthNo(EntProfit entProfit);
}
