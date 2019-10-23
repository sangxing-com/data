package com.cst.finance.service.tushare;

import com.cst.finance.entity.tushare.Daily;
import com.cst.finance.entity.tushare.DailyQuota;

public interface DailyQuotaService {

    int addDailyQuota(DailyQuota dailyQuota);

    int delDailyQuota(DailyQuota dailyQuota);

}
