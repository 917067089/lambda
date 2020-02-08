package com.imooc.reflection;

public class ConsoleMsg  implements IMsg {//仅是仿真保存到文件
    @Override
    public void process(String s) {
        System.out.println(s);
    }
}
