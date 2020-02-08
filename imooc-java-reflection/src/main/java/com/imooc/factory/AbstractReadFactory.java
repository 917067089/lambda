package com.imooc.factory;

public abstract class AbstractReadFactory {
    private static String TEXT="text";
    private static String IMAGE="IMAGE";

    public abstract IRead craete();

    /**
     * 抽象方法 create () 语义：具体工厂类对象是由客户端调用方产生的。静态方法 create()语义是：具体工厂类对象是在本类产生的，根据mark标识自动产生不同的具体工厂类对象。本类暗含两种产生工厂对戏那个的方法，方便用户加以选择。
     * 其实，运用java反射技术，可以编制更加灵活的代码
     * @param classname
     * @return
     */
    static AbstractReadFactory create(String classname){//是具体工厂类型标识字符串，不是类名
        AbstractReadFactory factory =null;
        try{
            Class c = Class.forName(classname);
            factory = (AbstractReadFactory) c.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return factory;
    }

}
