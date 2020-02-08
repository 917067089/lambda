package com.imooc.handler.one;
/**
 * 具体处理类-经理
 */
public class JingLi extends Handler {
    static int limt =2;
    @Override
    public boolean hadler(Request request) {
        System.out.println("jingli agress the request");
        return true;
    }
}
