package com.cst.finance.controller.tushare;

import com.cst.finance.entity.tushare.StockBasic;
import com.cst.finance.service.tushare.StockBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tushare/stockbasic")
public class StockBasicController {

    @Autowired
    StockBasicService stockBasicService;

    @PostMapping("/create")
    private List<StockBasic> create(@RequestBody String param){
        return stockBasicService.addStockBasic();
    }

}
