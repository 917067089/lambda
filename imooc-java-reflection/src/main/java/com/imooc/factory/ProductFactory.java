package com.imooc.factory;

/**
 * 运用反射技术，实现了更加灵活的自动工厂选择功能，当增加新具体工厂类时候，无需修改AbstractFactory 类，通过仔细分析可知，该类结构和对抽象工厂是最恰当的，抽象工厂对应多个产品族，每个具体工厂邮包含多种产品。从层次分析角度来说：也应该谁具体工厂，然后在得到该工厂改产品。当对于简单工厂、工厂模式他们都是单一，没有必要用反射。
 * 在运用反射的技术前提下，没有必要利用反射先产生具体工厂，在产生具体产品，直接用反射产生具体产品就可以了，而且该类也可由抽象类变成普通类
 *
 *
 *  static IRead create(String className){
 *         IRead iRead=null;
 *         try{
 *             Class c = Class.forName(className);
 *             iRead = (IRead) c.newInstance();
 *         }catch (Exception e){
 *             e.printStackTrace();
 *         }
 *         return iRead;
 *     }
 * 产品工厂类ProductFactory 是用于返回IRead 产品的，不过只要稍加改造，运用泛型技术，就可以得出更普遍的形式
 *
 */
public class ProductFactory<T> {
   public T create(String className){
       T product=null;
       try{
            Class c = Class.forName(className);
            product = (T) c.newInstance();
       }catch (Exception e){
              e.printStackTrace();
       }
       return product;
   }
}
