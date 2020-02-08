package com.imooc.reflection;

public class FileMsg implements IMsg{

    @Override
    public void process(String s) {//仅是保存到文件
        System.out.println("save msg to file"+s);
    }
}
