package Lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App3 {
    public void test(MyInterface<String,List> inte){
        List<String> list = inte.strategy("hello",new ArrayList());
        System.out.println(list);
    }
    @Test
    public void test1(){
        /**
         * (x,y)-> {..} -----> test(param) --> param==MyInterface的参数，---》 lambda表达式 -> MyInteface 类型
         * 这个就是对于lambda表达式的类型检查，myInterface 接口就是lambda表达式的目标类型（target,typing）
         *
         * (x,y)->{..} --> MyInterface.strategy(T t,R r) ---> MyInterface<String,List> inte.strategy("hello",new ArrayList())
         *  ---> T ==String R==LIST ---> lambda -->(x,y) == strategy(T t,R r)
         *  x==T String ,y==R List
         *  lambda 表达式参数类型检查
         */
        test(new MyInterface<String, List>() {
            @Override
            public List strategy(String s, List list) {
                list.add(s);
                return list;
            }
        });
        test((x,y) -> {
            y.add(x);
//            Collections.singletonList(list.add(s));
            return y;

        });
//        test((x,y) -> Collections.singletonList(y.add(x)));
    }
    @FunctionalInterface
    interface  MyInterface<T,R>{
        R strategy(T t,R r);
    }
}
