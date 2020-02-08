package com.imooc.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 统一形式解析类的构造方法，成员变量，成员方法
 */
public class Demo01 {
    int m;
    public Demo01( ) {
    }
    public Demo01(int m) {
        this.m = m;
    }
    private void func1(){}
    public void func2(){}
    public static void main(String [] args) throws Exception {
        /**
         * Class 代表一个类
         * Constructor 代表类的构造方法
         * Field 代表类的成员变量（成员变量也称为类的属性）
         * Method 代表类的方法
         */
        System.out.println(Demo01.class.getName());
        System.out.println(Demo01.class);
        //加载并初始化指定的类A
//        Class classInfo = Class.forName("Demo01"); forName 里面必须输入类全路径负责无法找到
        Class classInfo = Demo01.class;//这个和上面的是等同的
        //获得类的构造器函数
        System.out.println("类的构造函数如下所示：");
        Constructor[] constructors1= Demo01.class.getConstructors();
//        Constructor[] constructors = classInfo.getConstructors();
        for (int i=0;i<constructors1.length;i++){
            System.out.println(constructors1[i].toString());
        }
        //获得类的所有变量
        System.out.println("类的变量如下所示");
        Field[] fields =  Demo01.class.getDeclaredFields();
        for (int i=0;i<fields.length;i++){
            System.out.println(fields[i]);
        }
        //获取类的所有方法
        System.out.println("类的方法如下所示");
        Method [] methods = Demo01.class.getDeclaredMethods();
        for (int i=0;i<methods.length;i++){
            System.out.println(methods[i]);
        }
    }
}
