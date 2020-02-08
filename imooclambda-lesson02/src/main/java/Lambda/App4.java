package Lambda;

import org.junit.Test;

/**
 * 方法重载对于lambda  表达式的影响
 */
public class App4 {
    interface Param1{
        void outInfo(String info);
    }
    interface Param2{
        void outInfo(String info);
    }

    //定义重载的方法
    public void LambdaMethod(Param1 param1){
        param1.outInfo("hello param1 imooc");
    }

    public void LambdaMethod(Param2 param2){
        param2.outInfo("hello param2 imooc");
    }

    @Test
    public void test1(){
        App4 app4 = new App4();
        app4.LambdaMethod(new Param1() {
            @Override
            public void outInfo(String info) {
                System.out.println("-----");
                System.out.println(info);
            }
        });
        app4.LambdaMethod(new Param2() {
            @Override
            public void outInfo(String info) {
                System.out.println(info);
            }
        });

        /**
         * 用lambda实现调用
         * lambda表达式存在类型检查 -> 自动推动lambda表达式的目标类型
         * lambdaMethod() -> 方法 -> 重载方法
         *                  -> Parma1 函数式接口
         *                  -> Param2 函数式接口
         *                  调用方法 -> 传递了lambda表达式->自动推导
         *                  -Param1 | Paran2
         *                  在某些情况下下肢穿传统的发某些方法，比如重构
         *                  如果出现在方法的重载过程中，参数都是函数类类型
         *                  ，使用匿名内部类类替代
         */
//        app4.LambdaMethod( (String info) -> System.out.println(info));

    }
}
