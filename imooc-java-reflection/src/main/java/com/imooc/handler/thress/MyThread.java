package com.imooc.handler.thress;

public class MyThread extends Thread {
    Request request;
    Response response;
    Filter filter;
    FilterChain filterChain;

    public MyThread(Request request, Response response, Filter filter, FilterChain filterChain) {
        this.request = request;
        this.response = response;
        this.filter = filter;
        this.filterChain = filterChain;
    }
    @Override
    public void run(){
        filter.doFilter(request,response,filterChain);
    }
}
