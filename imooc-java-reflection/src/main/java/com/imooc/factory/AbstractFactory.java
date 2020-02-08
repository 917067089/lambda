package com.imooc.factory;

/**
 * 用关键字abstract修饰的类称为abstract类（抽象类），
 * 用关键字abstract修饰的方法称为abstract方法（抽象方法）
 *   对于abstract方法只允许声明，不允许实现（因为没有方法体）\  （毕竟叫抽象，当然不能实实在在的让你实现），并且不允许使用final和abstract同时修饰一个方法或者类，也不允许使用static修饰abstract方法。也就是说，abstract方法只能是实例方法，不能是类方法。
 *   1.abstract类中可以有abstract方法
 *
 *  abstract类中可以有abstract方法，也可以有非abstract方法
 *
 *  非abstract类中不可以有abstract方法
 *
 * 2.abstract类不能使用new运算符创建对象
 * 但是如果一个非抽象类是抽象类的子类，这时候我们想要创建该对象呢，这时候它就必须要重写父类的抽象方法，并且给出方法体，这也就是说明了为什么不允许使用final和abstract同时修饰一个类或者方法的原因。
 * final和abstract，private和abstract，static和abstract，这些是不能放在一起的修饰符，因为abstract修饰的方法是必须在其子类中实现（覆盖）
 * 才能以多态方式调用，以上修饰符在修饰方法时期子类都覆盖不了这个方法，final是不可以覆盖，private是不能够继承到子类，所以也就不能覆盖，static是可以覆盖的，但是在调用时会调用编译时类型的方法，因为调用的是父类的方法，而父类的方法又是抽象的方法，又不能够调用，所以上的修饰符不能放在一起
 3.abstract类的子类

 如果一个非abstract类是abstract类的子类，它必须重写父类的abstract方法，也就是去掉abstract方法的abstract修饰，并给出方法体。

 如果一个abstract类是abstract类的子类，它可以重写父类的abstract方法，也可以继承父类的abstract方法。

 下面举个例子：
 1、具有相同特征的小汽车，公共汽车放在相同的工厂
 2该类也是抽象类，表明特征是多个。
定义抽象工厂
 */
public abstract class AbstractFactory extends AbstractFactory1{
    public abstract ICar createCar();//产生小汽车对象
    public abstract IBus createBus();//产生公交车车对象
}
