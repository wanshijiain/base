package com.czw.algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 最多次出现的子字符串
 * @author ZeviChen ${datetime}
 */
public class MaximumSubString {
    public static void main(String[] args){
        String str = "abbaaaccddddbbcccaabaaccddd";
        System.out.println(cal(str));
    }

    public static String cal(String str){
        Map<String,Integer> strMap = new HashMap<>();
        for(int i = 0 ;i<str.length()-1;i++){
            for(int j = str.length();i+1<j;j--){
                String subStr = str.substring(i,j);
                if(subStr.contains(subStr)){
                    strMap.put(subStr,strMap.get(subStr)+1);
                }else{
                    strMap.put(subStr,0);
                }
            }
        }

        Iterator it = strMap.keySet().iterator();
        int max = 0;
        String maxSubStr = "";
        while (it.hasNext()){
            String k = (String) it.next();
            int v = strMap.get(k);
            if(max < v){
                max = v;
                maxSubStr = k;
            }
        }
        return maxSubStr;
    }
}
