package com.imooc.singleton;

/**
 * 应用服务器单例技术仿真
 * 为了提高应用服务器的运行效率，许多对象都是单例的。例如在web编程中，jsp、servlet等在内存中只有一个实例对象，为广大用户所共享。
 */
public interface IFunc {
    public int service(int one,int two);
}
