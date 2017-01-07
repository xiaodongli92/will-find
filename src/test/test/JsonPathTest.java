package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.JsonPath;

/**
 * Created by xiaodong on 2017/1/7.
 */
public class JsonPathTest {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        JSONObject data = new JSONObject();
        data.put("name", "hejie");
        jsonObject.put("data", data);
        String jsonStr = JSON.toJSONString(jsonObject);
        System.out.println(jsonStr);
        String name = JsonPath.read(jsonStr, "data.name");
        System.out.println(name);
        String sex = JsonPath.read(jsonStr, "data.sex");
        System.out.println(sex);
    }
}
