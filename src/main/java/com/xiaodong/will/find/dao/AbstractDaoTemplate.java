package com.xiaodong.will.find.dao;

import com.xiaodong.will.find.model.MyException;
import com.xiaodong.will.find.util.SQLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by xiaodong on 2016/11/4.
 */
public abstract class AbstractDaoTemplate <T> implements AbstractDaoInter<T> {

    @Autowired
    protected JdbcTemplate template;

    @Override
    public void save(T t) throws MyException {
        String sql = SQLUtil.buildInsertSql(t);
        template.update(sql);
    }

    @Override
    public <V> V findOne(long id, Class<V> clazz) {
//        String sql =
        return template.queryForObject("", clazz);
    }
}
