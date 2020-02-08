package com.imooc.handler;

import com.imooc.handler.one.MyChain2;
import com.imooc.handler.one.Request;
import com.imooc.handler.two.*;

public class Test {
    @org.junit.Test
    public void test1()throws Exception{
        Request request = new Request(2);//定义请假1天的对象
        MyChain2 mc = new MyChain2();
        mc.createChain();;//创建责任链
        mc.hadler(request);//将请求对象放入链中
    }

    /**
     * 回调技术，就是类对象方法间互相调用技术
     * 利用回调技术也能实现责任链模式功能代码
     */
    @org.junit.Test
    public void test2(){
        new A().fA();
    }
    /**
     * 利用回调技术也能实现责任链模式功能代码
     *
     * 对英文字符串数据进行如下功能处理：
     * 1全部变成大写字母；
     * 2去掉所有空格
     * 例如：若初始字符串“I am student” 经过处理后 “IAMSTUDENT”
     */
    @org.junit.Test
    public void test3(){
        com.imooc.handler.two.Request req = new com.imooc.handler.two.Request("i am a student");//请求对象
        Response res = new Response("");//响应对象
        Filter one = new OneFilter();//定义过滤器1
        Filter two = new TwoFilter();//定义过滤器1
        FilterChain fc = new FilterChain();//定义过滤器容器对象
        fc.addFilter(one);//添加过滤器1对象
        fc.addFilter(two);//添加过滤器2对象
        fc.doFilter(req,res,fc);
        System.out.println(res.getRes());
    }

    @org.junit.Test
    public void test4(){
        com.imooc.handler.thress.Request request = new com.imooc.handler.thress.Request("i am a student");
        com.imooc.handler.thress.Response res = new com.imooc.handler.thress.Response("");
        com.imooc.handler.thress.Filter one = new com.imooc.handler.thress.OneFilter();
        com.imooc.handler.thress.Filter two = new com.imooc.handler.thress.TwoFilter();
        com.imooc.handler.thress.FilterChain fc = new com.imooc.handler.thress.FilterChain();
        fc.addFilter(one);
        fc.addFilter(two);
        fc.doFilter(request,res,fc);
        System.out.println(res.getRes());
    }

}
