package com.cst.finance.controller.tushare;

import com.cst.finance.entity.tushare.Daily;
import com.cst.finance.service.tushare.DailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tushare/daily")
public class DailyController {

    @Autowired
    DailyService dailyService;

    @PostMapping("/create")
    private int addDaily(){
        return dailyService.addAllDaily();
    }
}
