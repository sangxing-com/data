package com.cst.finance.service.tushare;

import com.cst.finance.entity.tushare.Daily;

import java.util.List;

public interface DailyService {

    int addAllDaily();

    List<Daily> addDaily(String TsCode,String TsName,String StartDate,String EndDate);

    int delDaily(String TsCode);
}
