package com.xiaodong.will.find.service.inter;

import com.xiaodong.will.find.model.PageParam;
import com.xiaodong.will.find.model.SearchParam;
import com.xiaodong.will.find.model.pojo.Record;

import java.util.List;

/**
 * 显示界面列表
 */
public interface ShowDataService {

    List<Record> findAll();

    List<Record> findByParam(SearchParam searchParam, PageParam pageParam);

    long count(SearchParam searchParam);
}
