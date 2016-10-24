package com.xiaodong.will.find.model;

/**
 * 返回结果
 */
public class Netease {

    private int code;

    private Result result;

    @Override
    public String toString() {
        return "Netease{" +
                "code=" + code +
                ", result=" + result +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
