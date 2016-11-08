package test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        final int num = 20;
        TestRun testRun = new TestRun();
        for (int i=0; i<num; i++) {
            new Thread(testRun).start();
        }
    }

    private static class TestRun implements Runnable {
        final String url = "http://wap.wecash.net/platform/creditReport/getOperatorReport";
        @Override
        public void run() {
            String result = HttpUtil.post(url, param());
            System.out.println("current: " + new Date().getTime() + ";result = " + result);
        }
    }

    private static Map<String,String> param() {
        Map<String,String> map = new HashMap<>();
        map.put("idcardNum", "370112199011011051");
        return map;
    }
}
