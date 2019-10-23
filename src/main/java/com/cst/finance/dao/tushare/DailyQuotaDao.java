package com.cst.finance.dao.tushare;

import com.cst.finance.entity.tushare.DailyQuota;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DailyQuotaDao extends MongoRepository<DailyQuota,String> {
}
