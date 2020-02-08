package com.imooc.handler.thress;

/**
 * Response 代表响应类，包含对处理后的结果字符串的封装；
 */
public class Response {
    String res;

    public Response(String res) {
        this.res = res;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }
}
