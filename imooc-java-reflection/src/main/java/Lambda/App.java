package Lambda;

import java.lang.reflect.Constructor;

/**
 * Hello world!
 *
 */
public class App 
{
    int m;
    public App( ) {
    }
    public App(int m) {
        this.m = m;
    }
    private void func1(){}
    public void func2(){}
    public static void main(String [] args) throws Exception {
        /**
         * Class 代表一个类
         * Constructor 代表类的构造方法
         * Field 代表类的成员变量（成员变量也称为类的属性）
         * Method 代表类的方法
         */
        System.out.println(App.class);
        //加载并初始化指定的类A
        Class classInfo = Class.forName("App");
        //获得类的构造器函数
        System.out.println("类A的构造函数如下所示：");
        Constructor[] constructors = classInfo.getConstructors();
    }
}
