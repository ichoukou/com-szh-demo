package com.szh.httpClient;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.HttpClientError;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.ControllerThreadSocketFactory;
import org.apache.commons.httpclient.protocol.SecureProtocolSocketFactory;
public class MySecureProtocolSocketFactory implements SecureProtocolSocketFactory {
    private SSLContext sslContext = null;

    public MySecureProtocolSocketFactory() {
    }

    private static SSLContext createEasySSLContext() {
        try {
            SSLContext e = SSLContext.getInstance("SSL");
            e.init((KeyManager[])null, new TrustManager[]{new MyX509TrustManager()}, (SecureRandom)null);
            return e;
        } catch (Exception var1) {
            throw new HttpClientError(var1.toString());
        }
    }

    private SSLContext getSSLContext() {
        if(this.sslContext == null) {
            this.sslContext = createEasySSLContext();
        }

        return this.sslContext;
    }

    public Socket createSocket(String host, int port, InetAddress clientHost, int clientPort) throws IOException, UnknownHostException {
        return this.getSSLContext().getSocketFactory().createSocket(host, port, clientHost, clientPort);
    }

    public Socket createSocket(String host, int port, InetAddress localAddress, int localPort, HttpConnectionParams params) throws IOException, UnknownHostException, ConnectTimeoutException {
        if(params == null) {
            throw new IllegalArgumentException("Parameters may not be null");
        } else {
            int timeout = params.getConnectionTimeout();
            return timeout == 0?this.createSocket(host, port, localAddress, localPort):ControllerThreadSocketFactory.createSocket(this, host, port, localAddress, localPort, timeout);
        }
    }

    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        return this.getSSLContext().getSocketFactory().createSocket(host, port);
    }

    public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws IOException, UnknownHostException {
        return this.getSSLContext().getSocketFactory().createSocket(socket, host, port, autoClose);
    }
}
