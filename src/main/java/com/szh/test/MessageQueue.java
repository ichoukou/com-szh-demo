package com.szh.test;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by zhihaosong on 16-8-25.
 */
public class MessageQueue {
    private Queue<Map<String, String>> queue = new LinkedList();

    public synchronized void pushSendData(Map<String, String> map) {
        if (queue.size() % 1000 == 0) {
            System.out.println("pushSendData --> sendDate size:" + queue.size());
        }
        queue.add(map);
    }

    public synchronized Map<String, String> getSendData() {
        Map<String, String> map = queue.poll();
        return map;
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }

    public int getSize() {
        return queue.size();
    }

    public Queue<Map<String, String>> getQueue() {
        return queue;
    }
}
