package com.imooc.test;

public class Demo01 {
    public static void main( String[] args ){
        //1.传统模式下线程的创建
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threading 线程编号"+Thread.currentThread().getId());
            }
        }).start();
        //2.jdk8 新特性 ，lambda表达式优化线程模式
        new Thread(() ->{
            System.out.println("lambda threading 线程编号"+Thread.currentThread().getId());
        }).start();

    }
}
