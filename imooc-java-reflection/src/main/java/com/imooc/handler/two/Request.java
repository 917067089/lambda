package com.imooc.handler.two;

/**
 * request 代表请求类，包含对字符串的原生封装；
 */
public class Request {
    String req;

    public Request(String req) {
        this.req = req;
    }

    public String getReq() {
        return req;
    }

    public void setReq(String req) {
        this.req = req;
    }
}
