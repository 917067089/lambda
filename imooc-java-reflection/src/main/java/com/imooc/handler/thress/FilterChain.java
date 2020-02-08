package com.imooc.handler.thress;

import java.util.ArrayList;

/**
 * 是过滤容器类，其对象作为具体处理者必备的回调参数。
 * 一是生成了过滤集合对象；
 * 二实现了异步回调功能
 *
 * ArrayList 类型成员变量ary 是各具体过滤器的集合对象 其添加顺序就是各过滤器对象的执行顺序。addFilter完成了具体过滤器对象的添加
 *
 * 成员变量 index 与 doFilter()方法一起决定当前执行顺序焦点那一个具体过滤器对象。
 * 当 index=0时，则从ary 中获得第一个过滤器对象 f,同时使用index 加1，为执行下一个过滤器做准备，然后运行f 中的doFilter()方法。当运行完成后，在回调执行filterchain 类中的doFilter()方法。
 * 当index与ary 容器元素长度一致值， 表明所有过滤器对象都已执行完毕
 * 同步回调。应该要实现异步回调
 */
public class FilterChain implements Filter {
    ArrayList<Filter> ary = new ArrayList();
    int index=0;
    public void addFilter(Filter f){
        ary.add(f);
    }
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        if(index == ary.size())
            return;
        Filter f = ary.get(index);
        index ++;
       MyThread th = new MyThread(request,response,f,filterChain);
       th.run();
    }
}
