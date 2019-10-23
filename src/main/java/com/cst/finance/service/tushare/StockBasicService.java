package com.cst.finance.service.tushare;

import com.cst.finance.entity.tushare.StockBasic;

import java.util.List;

public interface StockBasicService {

    List<StockBasic> findStockBasic();

    List<StockBasic> addStockBasic();

    int delStockBasic();
}
