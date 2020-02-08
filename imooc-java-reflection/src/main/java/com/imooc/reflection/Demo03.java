package com.imooc.reflection;

import java.lang.reflect.Method;

/**
 * 统一形式调用成员方法示例
 */
public class Demo03 {
    public void func1(){
        System.out.println("this is demo");
    }
    public void func2(Integer m){
        System.out.println("this is demo:"+m);
    }
    public void func3(String s,Integer m){
        System.out.println(s+" this is demo:"+m);
    }
    public static void main(String [] args) throws Exception {
    Class classInfo = Demo03.class;
    //调用无参构造函数，生成新的实例对象
        Object obj = classInfo.getConstructor().newInstance();
        //调用无惨成员函数func1
        Method mt1 = classInfo.getMethod("func1");
        mt1.invoke(obj);
        //调用1个参数成员函数 func2
        Method mt2 = classInfo.getMethod("func2", Integer.class);
        mt2.invoke(obj,new Object[]{10});
        //调用2个参数成员函数 func3
        Method mt3 = classInfo.getMethod("func3", String.class, Integer.class);
        mt3.invoke(obj,new Object[]{"hello",2020});
    }
}
