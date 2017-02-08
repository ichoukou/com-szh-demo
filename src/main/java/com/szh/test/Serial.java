package com.szh.test;

/**
 * Created by zhihaosong on 16-9-14.
 */
public class Serial {
    private Integer id;
    private String channel;

    public Serial(Integer id, String channel) {
        this.id = id;
        this.channel = channel;
    }

    @Override
    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(channel);
        return sb.toString().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Serial)
                && (this.id == ((Serial) o).id)
                && (this.channel == ((Serial) o).channel);
    }
}
