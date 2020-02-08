package com.imooc.handler;

public class A {
    void fA(){
        System.out.println("this is A::fA()");
        B obj = new B();//A类里面new B 类 然后 调B类方法是（this）传A 类 对象  ，然后B类 在去调A类的另一个方法
        obj.fB(this);
    }

    public void fA2() {
        System.out.println("this ia A::fA2()");
    }
}
