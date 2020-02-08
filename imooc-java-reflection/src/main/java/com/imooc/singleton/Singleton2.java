package com.imooc.singleton;

/**
 * 延迟实例化
 * 首先将对象初始化为null,然后在他的getInstance 内部里面进行延迟实例化
 */
public class Singleton2 {
    private Singleton2(){}
    private static Singleton2 single = null;
    //完全同步方法
    public static synchronized Singleton2  getInstance(){//这种存在线程安全的问题。但是加一个synchronized 加一个锁
        if(single==null){
            single = new Singleton2();
        }
        return single;
    }
    //部分同步方法
    public static Singleton2 getInstance2(){
        if(single == null){
            synchronized (Singleton2.class){
                if(single == null){
                    single = new Singleton2();
                }
            }
        }
        return  single;
    }
}
