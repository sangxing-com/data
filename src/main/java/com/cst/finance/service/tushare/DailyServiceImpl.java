package com.cst.finance.service.tushare;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cst.finance.entity.tushare.Daily;
import com.cst.finance.entity.tushare.DailyQuota;
import com.cst.finance.entity.tushare.StockBasic;
import com.cst.finance.utils.DateTimeUtils;
import com.cst.finance.utils.LogUtils;
import com.cst.finance.utils.NumberUtil;
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
public class DailyServiceImpl implements DailyService {

    @Value("${tushare.serverurl}")
    private String tushareServerUrl;

    @Value("${tushare.token}")
    private String tushareToken;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    StockBasicService stockBasicService;

    @Autowired
    DailyQuotaService dailyQuotaService;

    Logger log = LogUtils.getExceptionLogger();


    @Override
    public int addAllDaily() {
        try{
            List<StockBasic> stockBasicList=stockBasicService.findStockBasic();
            for (StockBasic s:stockBasicList
            ) {
                log.info("=================================> add tscode :"+s.getTsCode());
                addDaily(s.getTsCode(),s.getName(),"20190701", DateTimeUtils.getDateNow1());
                Thread.sleep(5 * 1000L);
            }
            return 1;
        }catch (Exception ce){
            return 0;
        }
    }

    @Override
    public List<Daily> addDaily(String TsCode,String TsName, String StartDate, String EndDate) {

        List<Daily> results=new ArrayList<>();
        try{
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("ts_code",TsCode);
            jsonObject.put("start_date",StartDate);
            jsonObject.put("end_date",EndDate);

            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("api_name", "daily");
            jsonObject1.put("token", tushareToken);
            jsonObject1.put("params",jsonObject);
            jsonObject1.put("fields","ts_code,trade_date,open,high,low,close,pre_close,change,pct_chg,vol,amount");

            String ans=  this.restTemplate.postForObject(tushareServerUrl,jsonObject1,String.class);

            JSONObject jsonObject2=JSONObject.parseObject(ans);
            JSONObject jsonObject3=JSONObject.parseObject(jsonObject2.getString("data"));
            JSONArray jsonArray=JSONObject.parseArray(jsonObject3.getString("items"));

            List<Daily> dailies=new ArrayList<>();

            for(int i=0;i<jsonArray.size();i++){
                JSONArray o = (JSONArray) jsonArray.get(i);
                Daily daily=new Daily();
                if(o.get(0)!=null)
                    daily.setTsCode(o.get(0).toString());
                if(o.get(1)!=null)
                    daily.setTradeDate(o.get(1).toString());
                if(o.get(2)!=null)
                    daily.setOpen(Double.parseDouble(o.get(2).toString()));
                if(o.get(3)!=null)
                    daily.setHigh(Double.parseDouble(o.get(3).toString()));
                if(o.get(4)!=null)
                    daily.setLow(Double.parseDouble(o.get(4).toString()));
                if(o.get(5)!=null)
                    daily.setClose(Double.parseDouble(o.get(5).toString()));
                if(o.get(6)!=null)
                    daily.setPreClose(Double.parseDouble(o.get(6).toString()));
                if(o.get(7)!=null)
                    daily.setChange(Double.parseDouble(o.get(7).toString()));
                if(o.get(8)!=null)
                    daily.setPctChg(Double.parseDouble(o.get(8).toString()));
                if(o.get(9)!=null)
                    daily.setVol(Double.parseDouble(o.get(9).toString()));
                if(o.get(10)!=null)
                    daily.setAmount(Double.parseDouble(o.get(10).toString()));

                dailies.add(daily);
            }

            if(dailies.size()<31){
                return null;
            }

            DailyQuota dailyQuota=new DailyQuota();
            double PreMASum=0;
            double VolMASum=0;

            for(int i=0;i<31;i++){
                Daily daily=dailies.get(i);

                PreMASum+=daily.getClose();
                VolMASum+=daily.getVol();

                if(i==0){
                    dailyQuota.setTsCode(daily.getTsCode());
                    dailyQuota.setName(TsName);
                    dailyQuota.setTradeDate(daily.getTradeDate());
                    dailyQuota.setHigh(daily.getHigh());
                    dailyQuota.setClose(daily.getClose());
                    dailyQuota.setOpen(daily.getOpen());
                    dailyQuota.setClose(daily.getClose());
                    dailyQuota.setLow(daily.getLow());
                    dailyQuota.setVol(NumberUtil.saveOneBitTwoRound(daily.getVol()/10000));
                }else if(i==4){
                    dailyQuota.setPreMA5(NumberUtil.saveOneBitTwoRound(PreMASum/5));
                    dailyQuota.setVolMA5(NumberUtil.saveOneBitTwoRound(VolMASum/5/10000));
                }else if(i==9){
                    dailyQuota.setPreMA10(NumberUtil.saveOneBitTwoRound(PreMASum/10));
                    dailyQuota.setVolMA10(NumberUtil.saveOneBitTwoRound(VolMASum/10/10000));
                }else if(i==19){
                    dailyQuota.setPreMA20(NumberUtil.saveOneBitTwoRound(PreMASum/20));
                }else if (i==29){
                    dailyQuota.setPreMA30(NumberUtil.saveOneBitTwoRound(PreMASum/30));
                }else {}

            }

            if(dailyQuota.getLow()<dailyQuota.getPreMA30() && dailyQuota.getLow()<dailyQuota.getPreMA20() && dailyQuota.getLow()<dailyQuota.getPreMA10() && dailyQuota.getLow()<dailyQuota.getPreMA5()){
                if(dailyQuota.getVol()<dailyQuota.getVolMA5() && dailyQuota.getVol()<dailyQuota.getVolMA10()){
                    log.info("==================================>   add DailyQuota :"+dailyQuota.getTsCode());
                    dailyQuotaService.delDailyQuota(dailyQuota);
                    dailyQuotaService.addDailyQuota(dailyQuota);
                }
            }

            log.info("================================================>  add Daily size:"+results.size());
            return results;
        }catch (Exception ce){
            log.error("================================================>  add Daily Exeption :"+ce);
            return results;
        }
    }

    @Override
    public int delDaily(String TsCode) {
        try{
            Query query=new Query();
            Criteria criteria=new Criteria();
            criteria.and("TsCode").is(TsCode);
            query.addCriteria(criteria);
            mongoTemplate.remove(query,Daily.class);
            return 1;
        }catch(Exception ce ){
            return 0;
        }
    }
}
