package com.szh.threadTest;

public class C {
    /**
     * hello方法会不会有多线程安全问题呢？没有！
     * 静态方法如果没有使用静态变量，则没有线程安全问题。
     * 为什么呢？因为静态方法内声明的变量，每个线程调用时，都会新创建一份，而不会共用一个存储单元。比如这里的tmp,每个线程都会创建自己的一份，因此不会有线程安全问题。
     * 注意:静态变量，由于是在类加载时占用一个存储区，每个线程都是共用这个存储区的，所以如果在静态方法里使用了静态变量，这就会有线程安全问题！
     *
     * @param str
     * @return
     */
    public static String hello(String str) {
        String tmp = "";
        tmp = tmp + str;
        return tmp;
    }

    public static void test(String[] value) throws InterruptedException {
        Thread.sleep(5000);

        System.out.println(Thread.currentThread().getId());
        for (String v : value) {
            System.out.println(v);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            public void run() {
                try {
                    C.test(new String[]{"A", "B", "C"});
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                try {
                    C.test(new String[]{"D", "E", "F"});
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
} 