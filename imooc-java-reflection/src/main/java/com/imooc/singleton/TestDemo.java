package com.imooc.singleton;

import org.junit.Test;

public class TestDemo {
    /**
     * 通过测试发现：当java虚拟机应用程序字节码是，单例对象并不是立即加载的，当第一次运行My.single时，单例对象才能生成。，在上文直接实例化方法中，Singletonlei 中直接定义成员变量Privae static final Singleton single = new Singleton()
     * 导致java虚拟机应用成字节码是，单例对象直接射给你吃呢个，因此从虚拟机的效率来说，利用静态内部类生成单例对象是更优的。
     */
    @Test
    public void test1(){
//        Scanner scanner = new Scanner(System.in);
//        scanner.nextLine();
        Singleton3 singleton3 = Singleton3.getInstance();
        System.out.println(singleton3);
        Singleton3 singleton32 = Singleton3.getInstance();

    }

    /**
     *
     */
    @Test
    public void test2(){
        FileLogger fileLogger = FileLogger.getInstance();
        fileLogger.write("hello");
        fileLogger.write("你好！");
        fileLogger.close();
    }
    /**
     * 该类的设计师利用Properties系统类读取配置文件config.txt.将键值-对保存在map中类型的成员变量map.通过getinfo(Sting key)方法，返回所需信息。
     */
    @Test
    public void test3 (){
    MyConfig myConfig = MyConfig.getInstance();//获取单例对象
        String url= myConfig.getInfo("url");//获取数据库连接
        String username = myConfig.getInfo("username");
        String password = myConfig.getInfo("password");
        System.out.println("url:"+url+" username:"+username+" password:"+password);
    }

    public static void main(String[] args) throws Exception {
        /*IFunc iFunc = PlusFunc.getInstance();//获得加单例对象
        IFunc iFunc2 = MinusFunc.getInstance();//获得减单例对象
        Map<String,Object> mapNameToObj = new HashMap();
        mapNameToObj.put("plus",iFunc);//将单例对象加入map中
        mapNameToObj.put("minus",iFunc2);//name与类关联
        Map<String,String> mapUrlToName = new HashMap();
        mapUrlToName.put("plusurl","plus");//url 与name 关联
        mapUrlToName.put("minusurl","minus");
        Scanner scanner = new Scanner(System.in);
        while (true){
            String url = scanner.nextLine();
            String  unit []  =url.split(" ");
            String name = mapUrlToName.get(unit[0]);
            IFunc iobj = (IFunc) mapNameToObj.get(name);
            int result = iobj.service(Integer.parseInt(unit[1]),Integer.parseInt(unit[2]));
            System.out.println("result is "+result);
        }*/

        MyIntegrate.init();
        MyIntegrate.run();
    }
    @Test
    public void test5() throws Exception {
        MyIntegrate.run();
    }
}
