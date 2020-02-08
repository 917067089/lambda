package com.imooc.reflection;

import java.io.FileInputStream;
import java.util.Properties;

public class Demo07 {
    public static void main(String [] args) throws Exception {
        Properties properties = new Properties();
        properties.loadFromXML(new FileInputStream("D:/IdeaWorkspace/lambda/imooc-java-reflection.txt/src/main/resouce/msg.xml"));//用loadformxml 代替load()方法
        String cname = properties.getProperty("func");
        IMsg iMsg = (IMsg)Class.forName(cname).newInstance();
        iMsg.process("hellowworld ");
    }
}
