package com.cst.finance.task;

import com.cst.finance.utils.DateTimeUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {

   // @Scheduled(fixedRate = 1000)
    public void reportCurrentTime() {
        System.out.println("每隔五秒钟执行一次： " + DateTimeUtils.getDateTimeNow());
    }
}
