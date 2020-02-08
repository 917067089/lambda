package com.imooc.reflection;

import java.lang.reflect.Constructor;

/**
 * 统一形式掉调用构造方法示例
 */
public class Demo02 {

    public Demo02() {
        System.out.println("this is demo");
    }
    public Demo02(Integer m){
        System.out.println("this is:"+m);
    }
    public Demo02(String s,Integer m){
        System.out.println(s+":"+m);
    }

    public static  void main(String [] args) throws Exception{
      Class classInfo =   Demo02.class;
        //第1种方法
        Constructor [] constructors = classInfo.getConstructors();
        //调用第一个无惨构造
        System.out.println(constructors[2].newInstance());
        //调用第二个1个参数构造函数
        System.out.println(constructors[1].newInstance(new Object[]{10}));
        //调用第三个2个参数构造函数
        System.out.println(constructors[0].newInstance(new Object[]{"Hello",2020}));

        //第2中方法
        //调用无参构造函数
        Constructor constructor = classInfo.getConstructor();
        System.out.println(constructor.newInstance());
        //调用1个参数构造方法
        constructor = classInfo.getConstructor(new Class[]{Integer.class});
        System.out.println(constructor.newInstance(new Object[]{10}));
        //调用2个参数构造方法
        constructor = classInfo.getConstructor(new Class[]{String.class,Integer.class});
        constructor.newInstance(new Object[]{"hello",2020});
    }
}
