package com.szh.test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private  static AtomicInteger count = new AtomicInteger(0);
    Semaphore semaphore =new Semaphore(1);
    private synchronized static void inc(){
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count.getAndIncrement();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(new Thread(new Runnable() {
                @Override
                public void run() {
                    Counter.count.getAndIncrement();
                }
            })).start();

        }
        //怎么能让输出1000呢？
        System.out.println(Counter.count.get());


    }
}