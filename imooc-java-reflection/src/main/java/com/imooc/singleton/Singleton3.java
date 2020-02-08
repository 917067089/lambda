package com.imooc.singleton;

/**
 * 静态内部资源类最大的不同在于Singleton3类中，无synchromized 关键字，因而提供了java 虚拟机的维护效率。她是通过静态内部类My 来实现单例对象，而且对象MY.single 是线程安全的。为了更安全理解静态内部单例对戏那个的特点。
 */
public class Singleton3 {
    private static class My{
        private static final Singleton3 single = new Singleton3();
    }
    private Singleton3(){
        System.out.println("this is new Singleton");//做出测试输出用例
    }
    public static final Singleton3 getInstance(){
        return My.single;
    }
}
