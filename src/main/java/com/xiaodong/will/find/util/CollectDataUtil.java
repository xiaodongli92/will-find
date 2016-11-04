package com.xiaodong.will.find.util;

import com.alibaba.fastjson.JSON;
import com.xiaodong.will.find.model.json.Period;
import com.xiaodong.will.find.model.json.Periods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 采集数据
 */
public class CollectDataUtil {

    private static final String URL = "http://1.163.com/record/getDuobaoRecord.do";
    private static final int PAGE_SIZE = 50;
    private static final Logger LOG = LoggerFactory.getLogger(CollectDataUtil.class);

    /**
     * 得到当前期号所有的数据
     * @param period 期号
     * @return 数据
     */
    public static List<Period> getAllRecode(String period) {
        int totalCnt = getTotalCnt(period);
        int pageCount = (totalCnt + PAGE_SIZE - 1 ) / PAGE_SIZE;
        List<Period> list = new ArrayList<>();
        for (int i=1; i<=pageCount; i++) {
            Periods periods = getOneNetease(i, period);
            list.addAll(periods.getResult().getList());
        }
        List<Period> periods = new ArrayList<>();
        for (Period period1:list) {
            period1.setPeriod(period);
            period1.setUid(period1.getUser().getUid());
            periods.add(period1);
        }
        return periods;
    }

    /**
     * 得到一页数据
     * @param pageNum 页数
     * @param period 期号
     * @return 结果
     */
    private static Periods getOneNetease(int pageNum, String period) {
        String result = HttpUtil.get(getUrl(pageNum, PAGE_SIZE, period));
        LOG.info("=====================================================");
        LOG.info("result = {}", result);
        LOG.info("=====================================================");
        return JSON.parseObject(result, Periods.class);
    }

    /**
     * 得到总大小
     * @param period
     * @return
     */
    private static int getTotalCnt(String period) {
        String result = HttpUtil.get(getUrl(1, PAGE_SIZE, period));
        Periods periods = JSON.parseObject(result, Periods.class);
        return periods.getResult().getTotalCnt();
    }

    /**
     * 拼URL
     * @param pageNum 页数
     * @param pageSize 页面条数
     * @param period 期号
     * @return URL
     */
    private static String getUrl(int pageNum, int pageSize, String period) {
        return URL + "?" + HttpUtil.buildQuery(getParam(pageNum, pageSize, period));
    }

    /**
     * 参数
     * @param pageNum 页数
     * @param pageSize 页面条数
     * @param period 期号
     * @return 参数
     */
    private static Map<String,String> getParam(int pageNum, int pageSize, String period) {
        Map<String,String> map = getInitParam();
        map.put("period", period);
        map.put("pageNum", String.valueOf(pageNum));
        map.put("pageSize", String.valueOf(pageSize));
        return map;
    }

    /**
     * 初始参数
     * @return 参数
     */
    private static Map<String,String> getInitParam() {
        Map<String,String> map = new HashMap<>();
        map.put("totalCnt", "0");
        map.put("gid", "2491");
        map.put("token", "df0e61be-5c87-480b-98cb-0f73f79eb120");
        return map;
    }
}
