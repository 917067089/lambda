package com.imooc.reflection;

import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 */
public class Demo06 {
    public static void main(String [] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\IdeaWorkspace\\lambda\\imooc-java-reflection.txt\\src\\main\\resouce\\operties"));//装在配置文件
        String cname = properties.getProperty("func");
        Class.forName(cname);
        IMsg iMsg = (IMsg) Class.forName(cname).newInstance();
        iMsg.process("hello world");
    }
}
