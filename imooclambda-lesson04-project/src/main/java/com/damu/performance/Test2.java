package com.damu.performance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList();
        Random random = new Random();
        for(int i=0;i<1000;i++){
            integerList.add(random.nextInt(Integer.MAX_VALUE));
        }
        //串行Stream
        List<Integer> integerList2 = new ArrayList();
        integerList.stream().forEach(x -> integerList2.add(x));
        System.out.println(integerList2.size());
        //并行
        List<Integer> integerList3 = new ArrayList();
        integerList.parallelStream().forEach(x -> integerList3.add(x));
        System.out.println(integerList3.size());

        List<Integer> integerList4 = new ArrayList();
        integerList.parallelStream()
                .collect(Collectors.toList())
                .forEach(x -> integerList4.add(x));
        System.out.println(integerList4.size());

        /**
         * 并行存在线程安全的问题，最后在价格返回结果可以保证数据还原的  .collect,或者使用线程锁，等线程安全相关来规避线程
         */
    }
}
