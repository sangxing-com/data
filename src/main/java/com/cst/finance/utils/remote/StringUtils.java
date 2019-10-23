package com.cst.finance.utils.remote;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {

    public static List<String> StringSplit(String strDeal){

        List<String> listTemp=new ArrayList<>();
        String strTemp="";
        int m=0;

        for(int i=0;i<strDeal.length();i++) {
            char c=strDeal.charAt(i);
            if(c!=' '){
                strTemp+=c;
                if(i==strDeal.length()-1) {
                    listTemp.add(strTemp);
                    strTemp="";
                }
            }else if(c==' '&& i<strDeal.length()-1){
                char c1=strDeal.charAt(i+1);
                if(c1!=' '){
                    strTemp+=c;
                }else{
                    if(strTemp.length()>1){
                        listTemp.add(strTemp);
                        strTemp="";
                    }
                }
            }
        }
        return listTemp;
    }
}
