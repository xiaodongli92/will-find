package com.xiaodong.will.find.dao;

import com.xiaodong.will.find.model.MyException;

/**
 * Created by xiaodong on 2016/11/4.
 */
public interface AbstractDaoInter <T> {

    void save(T t) throws MyException;

    <V> V findOne(long id, Class<V> clazz);
}
