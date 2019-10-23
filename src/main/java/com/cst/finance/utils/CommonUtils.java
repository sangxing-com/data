package com.cst.finance.utils;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {

    /**
     * NULL和空判断
     * @param value
     * @return
     */
    public static Boolean NullOrEmpty(String value){
        if (value==null){
            return true;
        }else if("".equals(value)){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 获取UUID
     * @return
     */
    public static String getUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    /**
     * Unicode转 汉字字符串
     *
     * @param str \u6728  \u5e73\u5b89\u94f6\u884c
     * @return '木' 26408
     */
    public static String unicodeToString(String str) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(str);
        char ch;
        while (matcher.find()) {
            //group 6728
            String group = matcher.group(2);
            //ch:'木' 26408
            ch = (char) Integer.parseInt(group, 16);
            //group1 \u6728
            String group1 = matcher.group(1);
            str = str.replace(group1, ch + "");
        }
        return str;
    }

}

