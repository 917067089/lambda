package com.damu.performance;

import lombok.AllArgsConstructor;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList();
        Random random = new Random();
        for(int i=0;i<10000000;i++){
            integerList.add(random.nextInt(Integer.MAX_VALUE));
        }
        //基本数据类型
        //1.stram 流
        testStream(integerList);
        //2.parallelStream 并行流
        testParallelStream(integerList);
        //3.普通for
        testforloop(integerList);
        //4.增强fot循环
        testStrongForloop(integerList);
        //5.迭代器
        testIterator(integerList);
        //2.复杂数据类型
        List<Product> products = new ArrayList();
        for(int i=0;i<1000000;i++){
            products.add(new Product("pro"+i,i,random.nextInt(Integer.MAX_VALUE)));
        }
        //1.stram 流
        testProductStream(products);
        //2.parallelStream 并行流
        testProductParallelStream(products);
        //3.普通for
        testProductforloop(products);
        //4.增强fot循环
        testProductStrongForloop(products);
        //5.迭代器
        testProductIterator(products);
        /**
         * 在简单的 数据类型 ，例如：List<Integer> </>
         *      迭代器性能最好 ,平常的for循环 for(int i) ,然后是增强性for循环 for(stirng s: list) ,然后是平行光处理流 testParallelStream，最后是 Stream流
         *  在负载的 数据类型 ，例如：List<对象> 首先是 平行光处理流 testParallelStream，然后是迭代器，然后是 增强行for循环，然后是普通for循环，最后是stream
         *
         *  随着机器的增加 ，并行 testParallelStream的对性能提升是最明显的，简单的通过外部迭代进行处理，，最好使用迭代器。如果对性能有要求，使用parallelStream进行操作
         *
         */

    }
    public static void testProductStream(List<Product> list){
        long start = System.currentTimeMillis();
        Optional optional = list.stream().max((p1,p2) -> p1.hot-p2.hot);
        System.out.println("最大值："+optional.get());
        long end = System.currentTimeMillis();
        System.out.println("testProductStream 总共耗时："+(end-start)+"毫秒");
    }
    public static void testProductParallelStream(List<Product> list){
        long start = System.currentTimeMillis();
        Optional optional = list.parallelStream().max((p1,p2) -> p1.hot-p2.hot);
        System.out.println("testParallelStream最大值："+optional.get());
        long end = System.currentTimeMillis();
        System.out.println("testProductParallelStream 总共耗时："+(end-start)+"毫秒");
    }
    public static void testProductforloop(List<Product> list){
        long start = System.currentTimeMillis();
        Product maxHot = list.get(0);
        for(int i=0;i<list.size();i++){
            Product current = list.get(i);
            if(current.hot> maxHot.hot){
                maxHot = current;
            }
        }
        System.out.println("testforloop 最大值："+maxHot);
        long end = System.currentTimeMillis();
        System.out.println("testProductforloop 总共耗时："+(end-start)+"毫秒");
    }
    public static void testProductStrongForloop(List<Product> list){
        long start = System.currentTimeMillis();
        Product maxHot = list.get(0);
        for(Product product:list){
            if(product.hot> maxHot.hot){
                maxHot = product;
            }
        }
        System.out.println("testStrongForloop 最大值："+maxHot);
        long end = System.currentTimeMillis();
        System.out.println("testProductStrongForloop 总共耗时："+(end-start)+"毫秒");
    }
    public static void testProductIterator(List<Product> list){
        long start = System.currentTimeMillis();
        Iterator<Product> it = list.iterator();
        Product maxHot =  it.next();
        while (it.hasNext()){
            Product current = it.next();
            if(current.hot>maxHot.hot){
                maxHot =current;
            }
        }
        System.out.println("testIterator 最大值："+maxHot);
        long end = System.currentTimeMillis();
        System.out.println("testProductIterator 总共耗时："+(end-start)+"毫秒");
    }
    public static void testStream(List<Integer> list){
        long start = System.currentTimeMillis();
        Optional optional = list.stream().max(Integer::compareTo);
        System.out.println("最大值："+optional.get());
        long end = System.currentTimeMillis();
        System.out.println("testStream总共耗时："+(end-start)+"毫秒");
    }
    public static void testParallelStream(List<Integer> list){
        long start = System.currentTimeMillis();
        Optional optional = list.parallelStream().max(Integer::compareTo);
        System.out.println("testParallelStream最大值："+optional.get());
        long end = System.currentTimeMillis();
        System.out.println("testParallelStream总共耗时："+(end-start)+"毫秒");
    }
    public static void testforloop(List<Integer> list){
        long start = System.currentTimeMillis();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            int current = list.get(i);
            if(current> max){
                max = current;
            }
        }
        System.out.println("testforloop 最大值："+max);
        long end = System.currentTimeMillis();
        System.out.println("testforloop总共耗时："+(end-start)+"毫秒");
    }
    public static void testStrongForloop(List<Integer> list){
        long start = System.currentTimeMillis();
        int max = Integer.MIN_VALUE;
        for(Integer integer:list){
            if(integer> max){
                max = integer;
            }
        }
        System.out.println("testStrongForloop 最大值："+max);
        long end = System.currentTimeMillis();
        System.out.println("testStrongForloop总共耗时："+(end-start)+"毫秒");
    }
    public static void testIterator(List<Integer> list){
        long start = System.currentTimeMillis();
        Iterator<Integer> it = list.iterator();
        int max =  it.next();
        while (it.hasNext()){
            int current = it.next();
            if(current>max){
                max =current;
            }
        }
        System.out.println("testIterator 最大值："+max);
        long end = System.currentTimeMillis();
        System.out.println("testIterator总共耗时："+(end-start)+"毫秒");
    }
}
@AllArgsConstructor
class Product{
    String name;//名称
    Integer stock;//库存
    Integer hot;//热度
}

