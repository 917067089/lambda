package com.imooc.handler.two;

/**
 * 去掉所有空格类
 * 初数化StringBuffer sb使其为空，然后遍历原始字符串，当字符串不为空，则将该字符串添加到 sb 的尾部。从而得出最终结果
 */
public class TwoFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        String str = response.res;
        StringBuffer sb  = new StringBuffer();
        for (int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch != ' '){
                sb.append(ch);
            }
        }
        response.res = sb.toString();

        filterChain.doFilter(request,response,filterChain);
    }
}
