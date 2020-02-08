package com.imooc.proxy.one;

/**
 * 定义实际主题：买电视的过程
 */
public class Buyer implements ITV {
    @Override
    public void buyTV() {
        System.out.println("i have bought the TV by buyer proxy");
    }
}
