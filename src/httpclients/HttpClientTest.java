package httpclients;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

/**
 * Created by zhihaosong on 16-10-22.
 */
public class HttpClientTest {

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
        new HttpClientTest().getResponse();
    }

}
