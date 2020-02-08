package com.imooc.singleton;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.*;

public class MyIntegrate {
    private static Map<String,String> mapUrlToName= new HashMap();
    private static Map<String,String> mapNmaeToCalss= new HashMap();
    private static Map<String,IFunc> mapPhysicsClass= new HashMap();

    /**
     * 主要利用Properties类读取配置文件，获得url-name 已经 name -类名 映射变量
     * mapUrlToName \mapNameToClass 另外，初始化单类对象映射变量 mapPhysicsClass 代表 NAME-实际单例对象 间映射 ，由于本示例是动态加载单例对象的，因此mapPhysicsClass 初始化元素为空
     */
    public static void init(){
        try{
            FileInputStream in = new FileInputStream("D:\\IdeaWorkspace\\lambda\\imooc-java-reflection\\src\\main\\resouce\\config.txt");
            Properties p = new Properties();
            p.load(in);
            Set<Object> keys = p.keySet();//获得键的集合
            Iterator it = keys.iterator();
            while (it.hasNext()){//遍历键
                String key = (String) it.next();//获得键值
                String value = p.getProperty(key);//获得属性值
                String [] unit = value.split(",");//按逗号撤分获得name\及类的字符串
                if (unit!=null && unit.length>1){
                    String url = key;
                    String name = unit[0];
                    String classname = unit[1];
                    mapUrlToName.put(url,name);//填入url-name 映射
                    mapNmaeToCalss.put(name,classname);//填入name-类名映射
                }
            }
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 根据输入url 判断所需的单例对象是否存在，若不存在，则通过反射技术动态加载单例对象。最终调用service() 方法完成所需功能。
     * @throws Exception
     */
    public static void run()throws Exception{
        Scanner s = new Scanner(System.in);
        while (true){
            System.out.println("pless input url:");// plusurl 3 5
            String strurls = s.nextLine();
            String [] unit = strurls.split(" ");//按空格撤分
            String url = unit[0];//获得特定字符串
            int one = Integer.parseInt(unit[1]);
            int two = Integer.parseInt(unit[2]);
            String name = mapUrlToName.get(url);//特征串-》 name 值
            IFunc obj = mapPhysicsClass.get(name);//根据name 判断单例对象有否? 若不存在时，则通过反射技术添加单例对象
            if(obj == null){
                String classname = mapNmaeToCalss.get(name);//获得类名字符串
                Class c  = Class.forName(classname);//获得类信息
                Method m = c.getDeclaredMethod("getInstance");//获得getInstance 方法
                obj = (IFunc) m.invoke(null);//获得单例对象
                mapPhysicsClass.put(name,obj);//加入映射
            }
            int result = obj.service(one,two);//运行多态方法
            System.out.println("the result is :" +result);
        }
    }
}
