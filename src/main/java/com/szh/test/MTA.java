package com.szh.test;

/**
 * Created by yunbinan on 16-4-25.
 */
public class MTA implements Cloneable {
    private int id;
    private String host;
    private String ip;
    private long lastSendTime;

    public MTA() {
    }

    public MTA(Integer id, String host, String ip) {
        this.id = id;
        this.host = host;
        this.ip = ip;
    }

    public MTA clone() {
        MTA mta = null;
        try {
            mta = (MTA) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return mta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public long getLastSendTime() {
        return lastSendTime;
    }

    public void setLastSendTime(long lastSendTime) {
        this.lastSendTime = lastSendTime;
    }

    @Override
    public String toString() {
        return "MTA{" +
                "id=" + id +
                ", host='" + host + '\'' +
                ", ip='" + ip + '\'' +
                ", lastSendTime=" + lastSendTime +
                '}';
    }
}
