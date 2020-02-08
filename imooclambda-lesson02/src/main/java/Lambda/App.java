package Lambda;

import com.imooc.test.IMessageFormat;
import com.imooc.test.IUserCredential;
import com.imooc.test.MessageFormatImpl;
import com.imooc.test.UserCredentialImpl;

import java.util.UUID;
import java.util.function.*;

/**
 * 需求改动：
 *  所有用户验证，可以同时获取用户的验证信息【是否认证成功|成功-返回用户|null】
 *默认方法是给所有子类实现的对象增加的一些通用方法
 * 静态方法和默认方法都是在接口中实现的
 */
public class App 
{
    public static void main( String[] args ) {
        IUserCredential ic = new UserCredentialImpl();
        //默认方法
        System.out.println(ic.verifyUser("admin"));
        System.out.println(ic.getCredential("admin"));
        //静态方法
        String msg="hello world";
        if(IMessageFormat.verifyMessage(msg)){
            IMessageFormat format = new MessageFormatImpl();
            System.out.println(format.format(msg,"json"));
        }
        //匿名内部类，实现接口的抽象方法
        IUserCredential ic2 = new IUserCredential() {
            @Override
            public String verifyUser(String username) {
                return "admin".equals(username)?"管理员":"会员";
            }
        };
        System.out.println(ic2.verifyUser("admin"));

        //Lambda 表达式，针对函数式接口的简单实现 ()-> {} 也可以说是匿名内部类 new 接口 （）{ 实现接口中的方法}
        IUserCredential ic3 = (String username) ->{
            return "admin".equals(username)?"lambda 管理员":" lambda 会员";
        };
        System.out.println( ic3.verifyUser("admin"));
/**
 *  -java.util.funciton.Predicate<T>
 *                     -接收参数对象T,返回一个boolean类型结果
 *                 -java.util.function.Comsumer<T>
 *                     -接收参数对象T,不返回结果
 *                 -java.util.function.Function<T,R>
 *                     -接收参数对象T,返回结果对象R
 *                 -java.util.function.Supplier<T>
 *                     -不接收参数，提供T对象的创建工厂
 *                 -java.util.function.UnaryOperator<T>
 *                     -接收参数对象T,返回结果对象T
 *                 -java.util.function.BinaryOperator<T>
 *                     -接收两个T对象,返回一个T对象结果
 */
        Predicate<String> pre = (String username) -> {
            return "admin".equals(username);
        };
        System.out.println(pre.test("admin"));

        Consumer<String> com = (String message) -> {
            System.out.println("要发送的消息"+message);
            System.out.println("发送消息成功");
        };
        com.accept("hello !!");

        Function<String,Integer> fun = (String gender) -> {
            return gender.equals("male")?1:0;
        };
        System.out.println(fun.apply("male"));

        Supplier<String> sup = () -> {
            return UUID.randomUUID().toString();
        };
        System.out.println(sup.get());

        UnaryOperator<String> uo = (String img) -> {
            return img +="[100*200]";
        };
        System.out.println(uo.apply("原图--"));
        BinaryOperator<Integer> bo = (Integer i1,Integer i2) -> {
            return i1>i2?i1:i2;
        };
        System.out.println(bo.apply(1,2));

        /**
         * java.util.function 提供了大量的函数式接口
         *  Predicate 接收参数T对象，返回一个boolean对象
         *  Consumer 接收参数T对象，没有返回值
         *  Function 接收参数T对象，返回R对象
         *  Supplier 不接收任何参数，直接通过get()获取指定类型的对象
         *  UnaryOperator 接收参数T对象，执行业务处理后，返回更新后的T对象
         *  BinaryOperator 接口接收两个T对象；执行业务处理后，返回一个T对象
         */

        //1.lambda表达式的基本语法
        /*
            1) 声明： 就是和Lambda表达式绑定的接口类型
            2）参数：包含在一对圆括号中，和绑定的接口中的抽象方法中参数个数及顺序一致。
            3）操作符： ->
            4）执行代码块： 包含在一对大括号中，出现在操作符的右侧

            [接口声明] = （参数） -> {执行代码块}
            一行代码可以不要{}

            在入参的时候可以不用写参数类型，会自动带出参数类型

         */
        Ilambda i1  = () -> {
            System.out.println("hello imooc!");
        };
        i1.test();
        /**
         * {} 输入只有一行时，可以把{}给去掉了
         */
        Ilambda i2  = () ->
            System.out.println("hello imooc!2");
        i2.test();

        ILambda2 iLambda2 = (String name,int age) -> System.out.println("say:my year:"+age+"name:"+name);
        iLambda2.test(" ws ",22);
        /**
         * 输入参数，就行，不需要输入类型，会自动装箱
         */
        ILambda2 iLambda3 = ( name, age) -> System.out.println(name+"say:my year:"+age);
        iLambda3.test(" tom ",22);
        /**
         * 当{}里面止只有一个行代码是，去掉{} 代码有返回值的，可以把return 给去掉
         *
         */
        ILambda3 iLambda31 = (x,y) ->
             x+y;
        System.out.println(iLambda31.test(1,2));
        /**
         * 1.lambda 表达式，必须和接口进行绑定
         * 2.lambda表达式的参数，可以附带0个到n个参数，括号中参数类型可以不用指定，jvm运行时会自动根据绑定的抽象参数推导
         * 3.lambda 表达式的返回值，如果代码只有一行，并且没有大括号，不用写return关键字，单行代码的执行结果，会自动返回。如果添加了大扩号，或者有多行代码，必须通过returen 关键字返回执行结果。
         *
         */
    }

    //没有参数，没有返回值的lambda 表达式绑定的接口
    interface Ilambda {
        void test();
    }
    //带有参数，没哟返回值的lambda表达式
    interface ILambda2{
        void test(String name,int age);
    }
    //带有参数，带有返回值的lambda表达式
    interface  ILambda3{
        int test (int x,int y);
    }
}
