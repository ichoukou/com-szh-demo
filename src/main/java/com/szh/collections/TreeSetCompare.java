package com.szh.collections;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetCompare {

    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        //  TreeSet ts=new TreeSet(new MyCompare());
        ts.add(new Student("zhangsan", 23));
        ts.add(new Student("zhangsan2", 22));
        ts.add(new Student("zhangsan2", 25));
        ts.add(new Student("zhangsan3", 22));//他一compareTo发现相同就不存了  解决：判断次要条件
        ts.add(new Student("lisi", 25));
        Iterator it = ts.iterator();
        while (it.hasNext()) {
            Student s = (Student) it.next();
            System.out.println(s.getName() + "----" + s.getAge());
        }
    }
}