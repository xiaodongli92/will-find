package com.xiaodong.will.find.model.json;

/**
 * 返回结果
 */
public class Periods {

    private int code;

    private Result result;

    @Override
    public String toString() {
        return "Periods{" +
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
