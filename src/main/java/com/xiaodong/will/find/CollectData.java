package com.xiaodong.will.find;

import com.alibaba.fastjson.JSON;
import com.xiaodong.will.find.model.Netease;
import com.xiaodong.will.find.model.Recode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 采集数据
 */
public class CollectData {

    private static final String URL = "http://1.163.com/record/getDuobaoRecord.do";
    private static final int PAGE_SIZE = 50;


    public static void main(String[] args) throws Exception {
        List<Recode> list = getAllRecode("310240407");
        System.out.println(list);
        System.out.println(list.size());
    }

    private static List<Recode> getAllRecode(String period) {
        int totalCnt = getTotalCnt(period);
        int pageCount = (totalCnt + PAGE_SIZE - 1 ) / PAGE_SIZE;
        List<Recode> list = new ArrayList<>();
        for (int i=1; i<=pageCount; i++) {
            Netease netease = getOneNetease(i, period);
            list.addAll(netease.getResult().getList());
        }
        return list;
    }

    private static Netease getOneNetease(int pageNum, String period) {
        String result = HttpUtil.get(getUrl(pageNum, PAGE_SIZE, period));
        return JSON.parseObject(result, Netease.class);
    }

    private static int getTotalCnt(String period) {
        String result = HttpUtil.get(getUrl(1, PAGE_SIZE, period));
        Netease netease = JSON.parseObject(result, Netease.class);
        return netease.getResult().getTotalCnt();
    }

    private static String getUrl(int pageNum, int pageSize, String period) {
        return URL + "?" + HttpUtil.buildQuery(getParam(pageNum, pageSize, period));
    }

    private static Map<String,String> getParam(int pageNum, int pageSize, String period) {
        Map<String,String> map = getInitParam();
        map.put("period", period);
        map.put("pageNum", String.valueOf(pageNum));
        map.put("pageSize", String.valueOf(pageSize));
        return map;
    }

    private static Map<String,String> getInitParam() {
        Map<String,String> map = new HashMap<>();
        map.put("totalCnt", "0");
        map.put("gid", "2491");
        map.put("token", "4407078c-398a-4bef-9037-f4ce4944b568");
        return map;
    }
}
