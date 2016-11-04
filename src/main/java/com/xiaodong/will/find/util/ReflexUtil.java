package com.xiaodong.will.find.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Id;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射工具类
 */
public class ReflexUtil {

    private static final Logger LOG = LoggerFactory.getLogger(ReflexUtil.class);

    private ReflexUtil() {}

    public static <T, V> List<T> convertList(List<V> objList, Class<T> clazz) {
        List<T> list = new ArrayList<>(objList.size());
        for (Object obj:objList) {
            list.add(convert(obj, clazz));
        }
        return list;
    }

    public static <T> T convert(Object obj, Class<T> clazz) {
        try {
            T t = clazz.newInstance();
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field:fields) {
                field.setAccessible(true);
                String name = field.getName();
                Field[] newFields = clazz.getDeclaredFields();
                for (Field newField:newFields) {
                    String newName = newField.getName();
                    if (!newField.isAnnotationPresent(Id.class) && name.equals(newName)) {
                        newField.setAccessible(true);
                        newField.set(t, field.get(obj));
                    }
                }
            }
            return t;
        } catch (IllegalAccessException | InstantiationException e) {
            LOG.error("",e);
        }
        return null;
    }
}
