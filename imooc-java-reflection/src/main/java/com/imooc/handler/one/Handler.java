package com.imooc.handler.one;

public abstract class Handler {
    private Handler next;//定义后续处理者变量

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }
    //定义抽象子类方法，子类要重写
    public abstract boolean hadler(Request request);
}
