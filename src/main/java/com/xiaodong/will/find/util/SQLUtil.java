package com.xiaodong.will.find.util;

import com.xiaodong.will.find.model.MyException;
import com.xiaodong.will.find.model.pojo.User;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

/**
 * Created by xiaodong on 2016/11/4.
 */
public class SQLUtil {

    private SQLUtil() {}

    public static void main(String[] args) throws MyException {
        User user = new User();
        user.setAvatarName("name");
        System.out.println(buildInsertSql(user));
    }

    private static final char CHAR_UNDERLINE = '_';
    private static final char CHAR_COMMA = ',';
    private static final char CHAR_SINGLE_QUOTE = '\'';
    private static final String ID_NAME = "id";

    public static <T> String buildSelectSql(T t) throws MyException {
        try {
            String[] columns = getColumns(t);
            return new StringBuilder("INSERT INTO ")
                    .append(up2Underline(t.getClass().getSimpleName()))
                    .append(" (")
                    .append(columns[0])
                    .append(") VALUES (")
                    .append(columns[1])
                    .append(")").toString();
        } catch (IllegalAccessException e) {
            throw new MyException(e);
        }
    }

    public static <T> String buildInsertSql(T t) throws MyException {
        try {
            String[] columns = getColumns(t);
            return new StringBuilder("INSERT INTO ")
                    .append(up2Underline(t.getClass().getSimpleName()))
                    .append(" (")
                    .append(columns[0])
                    .append(") VALUES (")
                    .append(columns[1])
                    .append(")").toString();
        } catch (IllegalAccessException e) {
            throw new MyException(e);
        }
    }

    private static <T> String[] getColumns(T t) throws IllegalAccessException {
        if (null == t) {
            return null;
        }
        StringBuilder nameBuilder = new StringBuilder();
        StringBuilder valueBuilder = new StringBuilder();
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field:fields) {
            field.setAccessible(true);
            String name = field.getName();
            String value = obj2String(field.get(t));
            if (ID_NAME.equals(name) || null == value) {
                continue;
            }
            nameBuilder.append(up2Underline(name)).append(CHAR_COMMA);
            if (field.getType() == String.class) {
                valueBuilder.append(CHAR_SINGLE_QUOTE).append(value).append(CHAR_SINGLE_QUOTE).append(CHAR_COMMA);
                continue;
            }
            valueBuilder.append(value).append(CHAR_COMMA);
        }
        String names = nameBuilder.toString();
        String values = valueBuilder.toString();
        return new String[]{names.substring(0, names.length()-1), values.substring(0, values.length()-1)};
    }

    private static String obj2String(Object obj) {
        return null == obj ? null : obj.toString();
    }

    private static String up2Underline(String pojoName) {
        if (StringUtils.isBlank(pojoName)) {
            return "";
        }
        char[] chars = pojoName.toCharArray();
        int length = pojoName.length();
        StringBuilder builder = new StringBuilder(length);
        boolean flag = Boolean.FALSE;
        for (char c:chars) {
            if (Character.isUpperCase(c) && flag) {
                builder.append(CHAR_UNDERLINE).append(Character.toLowerCase(c));
                continue;
            }
            if (Character.isUpperCase(c)  && !flag) {
                builder.append(Character.toLowerCase(c));
                continue;
            }
            builder.append(c);
            flag = Boolean.TRUE;
        }
        return builder.toString();
    }
}
