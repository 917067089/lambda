package com.imooc.singleton;

import java.io.FileInputStream;
import java.util.*;

/**
 * 编制配置文件信息单例信息类
 * 配置文件是应用程序经常采用的技术，它的内容为整个应用程序所共享，具有唯一性，因此利用单例对象读取配置文件时可取得。
 */

public class MyConfig {
    private Map<String,String> map = new HashMap();//保持配置文件键-值对
    private MyConfig(){
        try{
            FileInputStream in = new FileInputStream("D:\\IdeaWorkspace\\lambda\\imooc-java-reflection\\src\\main\\resouce\\config.txt");
            Properties properties = new Properties();
            properties.load(in);
            Set<Object> keys = properties.keySet();
            Iterator it = keys.iterator();
            while (it.hasNext()){
                String key = (String)it.next();
                String value = properties.getProperty(key);
                map.put(key,value);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static class My{
        private static final MyConfig single=new MyConfig();
    }
    public  static MyConfig getInstance(){
        return My.single;
    }
    public String getInfo(String key){
        return map.get(key);
    }
}
