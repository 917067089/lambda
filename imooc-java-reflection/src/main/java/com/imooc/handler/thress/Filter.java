package com.imooc.handler.thress;

/**
 * 定义抽象处理这接口，过滤字符串功能
 */
public interface Filter {
    void doFilter(Request request, Response response, FilterChain filterChain);
}
