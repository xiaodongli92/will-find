package test;


import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpUtil {

    private static final String PROTOCOL_TLS = "TLSv1.2";

    private static final int MAX_TOTAL = 100;
    private static final int DEFAULT_MAX_PER_ROUTE = 200;
    private static final int CONNECT_TIME_OUT = 60000;
    private static final int SOCKET_TIME_OUT = 60000;

    private static RequestConfig requestConfig;
    private static PoolingHttpClientConnectionManager http;
    private static CloseableHttpClient httpClient;

    static {
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("https", new SSLConnectionSocketFactory(createSSLContextTLS()))
                .build();
        http = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        http.setMaxTotal(MAX_TOTAL);
        http.setDefaultMaxPerRoute(DEFAULT_MAX_PER_ROUTE);
        requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIME_OUT)
                .setSocketTimeout(SOCKET_TIME_OUT).build();
        httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig)
                .setConnectionManager(http).build();
    }

    private HttpUtil() {}

    private static String response(HttpUriRequest request) {
        HttpResponse response;
        String result = null;
        try {
            response = httpClient.execute(request);
            result = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }
    }

    public static String post(final String url,Map<String,String> paramMap) {
        HttpPost post = new HttpPost(url);
        post.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        if (null != paramMap && !paramMap.isEmpty()) {
            List<NameValuePair> params = getNameValuePair(paramMap);
            post.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));
        }
        return response(post);
    }

    private static List<NameValuePair> getNameValuePair(Map<String,String> paramMap) {
        List<NameValuePair> params = new ArrayList<>();
        for (Map.Entry<String,String> entry:paramMap.entrySet()) {
            params.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
        }
        return params;
    }

    private static SSLContext createSSLContextTLS() {
        return createSSLContext(PROTOCOL_TLS);
    }

    private static SSLContext createSSLContext(String protocol) {
        SSLContext context = null;
        try {
            context = SSLContext.getInstance(protocol);
            context.init(null, new TrustManager[]{getTrustManager()}, null);
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
        return context;
    }

    private static X509TrustManager getTrustManager() {
        return new X509TrustManager() {
            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
    }

}