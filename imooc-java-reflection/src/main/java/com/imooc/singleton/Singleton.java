package com.imooc.singleton;

/**
 * 单例模式仅有一个实例的核心思想是构造化私有化，，即不允许外部调用该类的构造方法，基于此思想。，实现单例模式。
 * 实现单例模式的方法：
 * 1 直接实例化
 * 2 -
 */
public class Singleton {
    private Singleton(){}//私有的构造方法，别人无法直接访问
    //私有的直接产生单实例
    private static final Singleton single = new Singleton();
    //提供单实例对象方法
    public static Singleton getInstance(){
        return single;
    }
}