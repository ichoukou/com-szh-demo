package main.java.com.szh.httpClient;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.CoreConnectionPNames;

/**
 * Created by zhihaosong on 16-10-22.
 * <p/>
 * maven引用了最新版本4.3,发现Idea提示DefaultHttpClient等常用的类已经不推荐使用了，
 * 之前在使用4.2.3版本的时候，还没有被deprecated。
 * 去看了下官方文档，确实不推荐使用了，http://hc.apache.org/httpcomponents-client-ga/httpclient/apidocs/org/apache/http/impl/client/DefaultHttpClient.html。
 * <p/>
 * DefaultHttpClient —> CloseableHttpClient
 * HttpResponse —> CloseableHttpResponse
 */
public class HttpClientOldTest {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    HttpClient httpClient = new DefaultHttpClient();

    public void getResponse() {
        try {
            // 设置连接超时时间(单位毫秒)
            httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 4000);
            // 设置读数据超时时间(单位毫秒)
            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 4000);
            //该值就是连接不够用的时候等待超时时间ms
            httpClient.getParams().setLongParameter(ClientPNames.CONN_MANAGER_TIMEOUT, 500L);
            HttpGet method = new HttpGet(
                    "http://www.dajie.com");
            HttpResponse responses = httpClient.execute(method);
            System.out.println(responses);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new HttpClientOldTest().getResponse();
    }

}
