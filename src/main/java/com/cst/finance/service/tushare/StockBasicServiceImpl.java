package com.cst.finance.service.tushare;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cst.finance.entity.tushare.StockBasic;
import com.cst.finance.utils.LogUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockBasicServiceImpl implements StockBasicService {

    @Value("${tushare.serverurl}")
    private String tushareServerUrl;

    @Value("${tushare.token}")
    private String tushareToken;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MongoTemplate mongoTemplate;

    Logger log = LogUtils.getExceptionLogger();

    @Override
    public List<StockBasic> findStockBasic() {
        Query query=new Query();
        Criteria criteria=new Criteria();
        criteria.and("ListStatus").is("L");
        query.addCriteria(criteria);
        return mongoTemplate.find(query,StockBasic.class);
    }

    @Override
    public List<StockBasic> addStockBasic() {
        List<StockBasic> results=new ArrayList<>();
        try{
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("list_status", "L");

            JSONObject jsonObject2 = new JSONObject();
            jsonObject2.put("api_name", "stock_basic");
            jsonObject2.put("token", tushareToken);
            jsonObject2.put("params",jsonObject1);
            jsonObject2.put("fields","ts_code,symbol,name,area,industry,fullname,enname,market,exchange,curr_type,list_status,list_date,delist_date,is_hs");

            String ans=  this.restTemplate.postForObject(tushareServerUrl,jsonObject2,String.class);

            JSONObject jsonObject=JSONObject.parseObject(ans);
            JSONObject jsonObject3=JSONObject.parseObject(jsonObject.getString("data"));
            JSONArray jsonArray=JSONObject.parseArray(jsonObject3.getString("items"));

            List<StockBasic> stockBasics=new ArrayList<StockBasic>();
            for (int i=0;i<jsonArray.size();i++){
                JSONArray o = (JSONArray) jsonArray.get(i);
                StockBasic stockBasic=new StockBasic();
                if(o.get(0)!=null)
                    stockBasic.setTsCode(o.get(0).toString());
                if(o.get(1)!=null)
                    stockBasic.setSymbol(o.get(1).toString());
                if(o.get(2)!=null)
                    stockBasic.setName(o.get(2).toString());
                if(o.get(3)!=null)
                    stockBasic.setArea(o.get(3).toString());
                if(o.get(4)!=null)
                    stockBasic.setIndustry(o.get(4).toString());
                if(o.get(5)!=null)
                    stockBasic.setFullName(o.get(5).toString());
                if(o.get(6)!=null)
                    stockBasic.setEnName(o.get(6).toString());
                if(o.get(7)!=null)
                    stockBasic.setMarket(o.get(7).toString());
                if(o.get(8)!=null)
                    stockBasic.setExchange(o.get(8).toString());
                if(o.get(9)!=null)
                    stockBasic.setCurrType(o.get(9).toString());
                if(o.get(10)!=null)
                    stockBasic.setListStatus(o.get(10).toString());
                if(o.get(11)!=null)
                    stockBasic.setListDate(o.get(11).toString());
                if(o.get(12)!=null)
                    stockBasic.setIsHs(o.get(12).toString());
                stockBasics.add(stockBasic);
            }
            delStockBasic();
            results=(ArrayList<StockBasic>) mongoTemplate.insertAll(stockBasics);
            log.info("================================================>  add StockBasic size:"+results.size());
            return results;
        }catch (Exception ce){
            log.error("================================================>  add StockBasic Exeption :"+ce);
            return results;
        }
    }

    @Override
    public int delStockBasic() {
        mongoTemplate.dropCollection(StockBasic.class);
        return 1;
    }

}
