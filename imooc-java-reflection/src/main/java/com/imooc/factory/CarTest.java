package com.imooc.factory;

import org.junit.Test;

public class CarTest {
    /**
     * 简单工厂
     * 编制 小汽车简单工厂模式的相关类
     */
    @Test
    public void testsimplefactory(){
        try{
            //从工厂中创建对象
            ICar obj = CarSimpleFactory.create("upcar");
            if(obj==null){
                new Exception("没有创建成功");
            }
            System.out.println(obj);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 工厂
     * 小汽车工厂模式的相关类
     */
    @Test
    public void testfactory(){
        //利用java的多态性
        AbstractFactory obj = new UpFactory();
        System.out.println(obj.createCar());//获得高档工厂的小汽车
        //获得超高档小汽车 当需求变化，只需要增加或删除，而不是修改已已有的类，如果是上面的简单工厂的，则必须要修改简单工厂才能支持。
        obj = new SupserFactory();
        System.out.println(obj.createCar());
    }
    /**
     * 抽象工厂
     * 简单工厂、工厂模式是单产品系的，而抽象工厂是多产品系的。从本质上来说，抽象工厂、工厂模式是统一的
     * 汽车抽象工厂模式
     * 多产品系，局部特征情况相同，小汽车和公共汽车都有高、中当类型，此外小汽车还有低当类型，而公共汽车则没有
     */
}
