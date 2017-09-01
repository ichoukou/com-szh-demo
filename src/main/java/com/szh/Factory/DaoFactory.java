package com.szh.Factory;

public class DaoFactory {

    public static <T> T getDao(Class<T> clazz){
        try{
            T t = clazz.newInstance();
            return t;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}