package com.imooc.handler.thress;

/**
 * 把英文字母小写变大写
 */
public class OneFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        String str = request.req;

        response.res = str.toUpperCase();
        filterChain.doFilter(request,response,filterChain);
    }
}
