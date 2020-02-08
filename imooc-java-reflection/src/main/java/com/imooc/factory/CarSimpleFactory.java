package com.imooc.factory;

/**
 * 简单工厂
 */
public class CarSimpleFactory {
    public static  final String UPTYPE="upcar";
    public static  final String MIDTYPE="micar";
    public static  final String DNTYPE="dncar";
    public static ICar create(String mark){
        ICar obj = null;
        if(mark.equals(UPTYPE)){//如果是高档类型 则创建高档车对象
            obj = new UpCar();
        }else if(mark.equals(MIDTYPE)){
            obj = new MidCar();
        }else if(mark.equals(DNTYPE)){
            obj = new DnCar();
        }
        return obj;//返回选择的对象
    }
}
