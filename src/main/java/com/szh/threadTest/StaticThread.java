package com.szh.threadTest;

public class StaticThread implements Runnable {
    public void run() {
        StaticAction.print();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new StaticThread()).start();
        }
    }
}

class StaticAction {
    public static int i = 0;

    public static void print() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            System.out.print("step " + i + " is running.");
            sum += i;
        }
        if (sum != 45) {
            System.out.println("Thread error!");
            System.exit(0);
        }
        System.out.println("sum is " + sum);
    }
}