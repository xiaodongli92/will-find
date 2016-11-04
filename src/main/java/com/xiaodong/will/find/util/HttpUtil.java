package com.xiaodong.will.find.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description: http公用方法
 * @Author: lixiaodong@souyidai.com
 * @CreateDate: 2016/6/7
 */
public class HttpUtil {

    //上传文件时 每个post请求参数之间的分隔
    private static final String BOUNDARY = "------WebKitFormBoundary";

    private static final int MAX_TOTAL = 100;
    private static final int DEFAULT_MAX_PER_ROUTE = 200;
    private static final int CONNECT_TIME_OUT = 60000;
    private static final int SOCKET_TIME_OUT = 60000;

    private static CloseableHttpClient httpClient;

    static {
        PoolingHttpClientConnectionManager http = new PoolingHttpClientConnectionManager();
        http.setMaxTotal(MAX_TOTAL);
        http.setDefaultMaxPerRoute(DEFAULT_MAX_PER_ROUTE);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIME_OUT)
                .setSocketTimeout(SOCKET_TIME_OUT).build();
        httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig)
                .setConnectionManager(http).build();
    }

    private HttpUtil(){

    }

    /**
     * 带文件的post请求
     * @param url
     * @param paramMap
     * @param fileMap
     * @return
     * @throws IOException
     */
    public static String post(String url, Map<String,String> paramMap, Map<String,byte[]> fileMap)
            throws IOException {
        HttpPost post = new HttpPost(url);
        post.addHeader("Content-Type", "multipart/form-data;charset=utf-8;boundary="+BOUNDARY);
        MultipartEntityBuilder builder = setParam(paramMap, fileMap);
        post.setEntity(builder.build());
        HttpResponse response = httpClient.execute(post);
        return EntityUtils.toString(response.getEntity(), "UTF-8");
    }

    /**
     * 带文件的post 塞参数
     * @param paramMap
     * @param fileMap
     */
    private static MultipartEntityBuilder setParam(Map<String,String> paramMap, Map<String,byte[]> fileMap) {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setBoundary(BOUNDARY);
        if (null != paramMap && !paramMap.isEmpty()) {
            for (Map.Entry<String,String> entry:paramMap.entrySet()) {
                builder.addTextBody(entry.getKey(), entry.getValue());
            }
        }
        if (null != fileMap && !fileMap.isEmpty()) {
            for (Map.Entry<String,byte[]> entry:fileMap.entrySet()) {
                //在上传文件的时候必须得加上ContentType
                builder.addBinaryBody(entry.getKey(),entry.getValue(), ContentType.MULTIPART_FORM_DATA, "");
            }
        }
        return builder;
    }

    /**
     * post json 请求
     * @param url
     * @param jsonStr
     * @return
     * @throws IOException
     */
    public static String postJson(String url, String jsonStr) throws IOException {
        if (StringUtils.isBlank(url)) {
            return "url不能为空";
        }
        HttpPost post = new HttpPost(url);
        post.addHeader("Content-type", "application/json");
        HttpEntity httpEntity = new StringEntity(jsonStr, "UTF-8");
        post.setEntity(httpEntity);
        HttpResponse response = httpClient.execute(post);
        return EntityUtils.toString(response.getEntity());
    }

    /**
     * post 请求
     * @param url
     * @param paramMap
     * @return
     * @throws IOException
     */
    public static String post(String url, Map<String,String> paramMap) throws IOException {
        if (StringUtils.isBlank(url)) {
            return "url不能为空";
        }
        HttpPost post = new HttpPost(url);
        post.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        if (null != paramMap && !paramMap.isEmpty()) {
            List<NameValuePair> params = getNameValuePair(paramMap);
            post.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));
        }
        HttpResponse response = httpClient.execute(post);
        return EntityUtils.toString(response.getEntity());
    }

    public static String get(String url){
        try {
            if (StringUtils.isBlank(url)) {
                return "url不能为空";
            }
            HttpGet get = new HttpGet(url);
            get.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36");
            HttpResponse response = httpClient.execute(get);
            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 参数转换 Map<String,String> ==》List<NameValuePair>
     * @param paramMap
     * @return
     */
    private static List<NameValuePair> getNameValuePair(Map<String,String> paramMap) {
        List<NameValuePair> params = new ArrayList<>();
        for (Map.Entry<String,String> entry:paramMap.entrySet()) {
            params.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
        }
        return params;
    }

    public static String buildQuery(Map<String,String> params) {
        if (null == params || params.isEmpty()) {
            return null;
        }
        StringBuilder query = new StringBuilder();
        boolean hasParam = false;
        Set<Map.Entry<String,String>> entries = params.entrySet();
        for (Map.Entry<String,String> entry:entries) {
            String name = entry.getKey();
            String value = entry.getValue();
            if (StringUtils.isNoneBlank(name, value)) {
                if (hasParam) {
                    query.append("&");
                } else {
                    hasParam = true;
                }
                query.append(name).append("=").append(value);
            }
        }
        return query.toString();
    }
}
