package com.xiaodong.will.find.service.inter;

import com.xiaodong.will.find.model.json.Period;

import java.util.List;

/**
 * 采集数据
 */
public interface CollectDataService {

    List<Period> getAllRecode(String period);

    void before();

    void deal();

    void after();
}
