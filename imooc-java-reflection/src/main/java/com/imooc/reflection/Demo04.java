package com.imooc.reflection;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 一个通用方法
 * 分析：只要知道类名字符串、方法名字符串、方法参数值，运用反射机制就能执行该方法，
 */
public class Demo04 {
    boolean Precess(String className,String funcName,Object[] para) throws Exception {
        //获取类信息对像
        Class classInfo = Class.forName(className);
        //形成函数参数序列
        Class c [] = new Class[para.length];
        for(int i=0;i<para.length;i++){
            c[i] = para[i].getClass();
        }
        //调用无参构造函数
        Constructor ct = classInfo.getConstructor();
        Object obj = ct.newInstance();
        //获得函数方法信息
        Method mt =classInfo.getMethod(funcName,c);
        mt.invoke(obj,para);
        return true;
    }


}

