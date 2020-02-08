package com.imooc.handler.one;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * MyChain 类可以看出，所形成的责任是刚性的，若需求发生变化，链中需要增加或减少节点，我们在必须要修改MyChain的代码。
 * 配置+反射的，技术不需要修改
 *
 * 成员变量handler[] 定义是通过数组形式，代表个具体责任链节点对象
 * chain=one.ZuZhang,one.ZhuRen,one.JingLi
 * D:\IdeaWorkspace\lambda\imooc-java-reflection\src\main\resouce\myconfig.txt
 */
public class MyChain2 {
    private Handler handler[];
    public void createChain() throws Exception{
        String path = this.getClass().getResource("/").getPath();
        FileInputStream in = new FileInputStream("D:\\IdeaWorkspace\\lambda\\imooc-java-reflection\\src\\main\\resouce\\myconfig.txt");//读配置文件
        Properties p = new Properties();
        p.load(in);
        String s = p.getProperty("chain");//读取责任链总串
        String unit [] = s.split(",");//按，分割获得各责任链
        handler = new Handler[unit.length];//共用n个处理者
        for(int i=0;i<unit.length;i++){
            //通过反射技术加载各责任链类对象
            handler[i] = (Handler)Class.forName(unit[i]).newInstance();
        }
        for(int i=0;i<unit.length-1;i++){
            handler[i].setNext(handler[i+1]);//设置节点前后关联关系 数组，是在组长里面放主任。在主任里面放经理，然后通过getNext().hadler(request); 得到下一级 第一次是0 ，就给 handler[0] 赋值，第二次是1 就是handler[1] 赋值
        }
        in.close();
    }
    public void hadler(Request request){
        handler[0].hadler(request);
    }
}
