package com.imooc.handler.one;
/**
 * 具体处理类-主任
 */
public class ZhuRen extends Handler {
    static int limt =2;
    @Override
    public boolean hadler(Request request) {
        if(request.day<=2){
            System.out.println("zuren agress the request");
            return true;
        }
        return getNext().hadler(request);
    }
}
