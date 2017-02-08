package com.szh.practice;

/**
 * Created by zhihaosong on 16-6-27.
 */
public class CompareInteger {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf("126") == Integer.valueOf("126"));
        System.out.println(Integer.valueOf("128") == Integer.valueOf("128"));
        System.out.println(Integer.valueOf("129") == Integer.valueOf("129"));
        System.out.println(Integer.parseInt("128") == Integer.valueOf("128"));
        System.out.println(Integer.valueOf("125") == Integer.valueOf("125"));
        System.out.println("=========");
        Integer a1 = new Integer(125);
        Integer a2 = new Integer(125);
        Integer b1 = 125;
        Integer b2 = 125;
        Double.valueOf(123);
        System.out.println(a1 == a2);
        System.out.println(b1 == b2);
        System.out.println("=========");
        Integer x1 = new Integer(129);
        Integer x2 = new Integer(129);
        Integer d1 = 2;
        Integer d2 = null;
        try {
            d2 = 2;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(x1 == x2);
        System.out.println(d1 == 129);
        System.out.println(129 == d2);
        System.out.println(d1 == x1);
    }
}
