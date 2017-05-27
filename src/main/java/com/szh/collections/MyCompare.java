package com.szh.collections;

import java.util.Comparator;

public class MyCompare implements Comparator {
    //用来比较传入的两个对象
    public int compare(Object obj1, Object obj2) {
        if (!(obj1 instanceof Student) || !(obj2 instanceof Student)) {
            throw new RuntimeException("传值不正确");
        }
        Student s1 = (Student) obj1;
        Student s2 = (Student) obj2;
        int num = s1.getName().compareTo(s2.getName());
        if (num == 0)//不能判断为1或-1  因为相同时返回0  大于返回正数小于返回一个负数
        {
            //判断一下age
            return new Integer(s1.getAge()).compareTo(s2.getAge());
        }
        return num;
    }
}