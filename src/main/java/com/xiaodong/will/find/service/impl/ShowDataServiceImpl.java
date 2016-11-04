package com.xiaodong.will.find.service.impl;

import com.xiaodong.will.find.dao.RecordDao;
import com.xiaodong.will.find.model.PageParam;
import com.xiaodong.will.find.model.SearchParam;
import com.xiaodong.will.find.model.pojo.Record;
import com.xiaodong.will.find.service.inter.ShowDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 显示service实现类
 */
@Service
public class ShowDataServiceImpl implements ShowDataService {

    @Autowired
    private RecordDao recordDao;

    @Override
    public List<Record> findAll() {
        return recordDao.allRecord();
    }

    @Override
    public List<Record> findByParam(SearchParam searchParam, PageParam pageParam) {
        return recordDao.pageByParam(pageParam.getPageNo(), pageParam.getPageSize());
    }

    @Override
    public long count(SearchParam searchParam) {
        return recordDao.count(searchParam);
    }
}
