package com.imooc.handler.one;

/**
 * 具体处理类-组长
 */
public class ZuZhang extends Handler {
    static int limt=1;
    @Override
    public boolean hadler(Request request) {
        if(request.day<=limt){
            System.out.println("zuzhang agress the request");
            return true;
        }
        return getNext().hadler(request);
    }
}
