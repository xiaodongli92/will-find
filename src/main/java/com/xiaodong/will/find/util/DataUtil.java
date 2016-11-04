package com.xiaodong.will.find.util;

import com.xiaodong.will.find.model.json.Period;
import com.xiaodong.will.find.model.pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据工具类
 */
public class DataUtil {

    private DataUtil() {}

    public static List<User> userList(List<Period> list) {
        List<User> users = new ArrayList<>();
        for (Period period:list) {
            users.add(period.getUser());
        }
        return users;
    }
}
