package com.xiaodong.will.find.service.impl;

import com.xiaodong.will.find.dao.RecordDao;
import com.xiaodong.will.find.dao.UserDao;
import com.xiaodong.will.find.model.json.Period;
import com.xiaodong.will.find.model.pojo.Record;
import com.xiaodong.will.find.model.pojo.User;
import com.xiaodong.will.find.service.inter.CollectDataService;
import com.xiaodong.will.find.util.CollectDataUtil;
import com.xiaodong.will.find.util.DataUtil;
import com.xiaodong.will.find.util.ReflexUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 采集数据实现类
 */
@Service
public class CollectDataServiceImpl implements CollectDataService {

    private static final Logger LOG = LoggerFactory.getLogger(CollectDataServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private RecordDao recordDao;

    @Override
    public List<Period> getAllRecode(String period) {
        List<Period> list = CollectDataUtil.getAllRecode(period);
        try {
            List<Record> records = ReflexUtil.convertList(list, Record.class);
            List<User> users = DataUtil.userList(list);
            userDao.save(users);
            recordDao.save(records);
        } catch (Exception e) {
            LOG.error("",e);
        }
        return list;
    }

    @Override
    public void before() {

    }

    @Override
    public void deal() {

    }

    @Override
    public void after() {

    }
}
