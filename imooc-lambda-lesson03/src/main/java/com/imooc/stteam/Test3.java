package com.imooc.stteam;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1.聚合操作
 *  针对批量数据的操作
 *     在电商项目中，获取指定用户的年销售额，获取指定店铺中最便宜的商品，获取当月商家的有效订单数量等
 *
 * 2.stream的处理流程
 *      获取数据源
 *      数据装换
 *      执行操作，获取结果
 *  3、获取stream对象
 *      1.从集合或数组中获取[**]
 *          Collection.stram()；例如accounts.stream()
 *          Conllection.parallelStream() 获取到并行处理集合的流 ，并发处理
 *          在处理过程中，如果数据源是数组，Arrays.stream(T t); 将数组添加进来即可
 *
 *        2.BufferReader
 *          BufferReader.lines() -> Stream()
 *
 *         3.静态工厂
 *          java.util.stream.IntStream.rangge().. 获取stream对象
 *          java.nio.file.File.walk()..
 *
 *         4.自行构建
 *            java.util.Spliterator
 *          5.更多方式
 *              Random.ints()
 *              Parern.splitSaStream()..
 *      4. 中间操作API{intermediate}
 *          操作结果是一个stream,中间操作可以有一个或多个连续的中间操作，需要注意的是，中间操作只记录操作方式，不做具体执行，直到结束操作发生时，才做数据的最终执行
 *          中间操作：就是业务逻辑处理
 *          中间操作过程:
 *              无状态：数据处理时，不受中间操作的影响
 *                  map/filter/peek/parallel/sequential/unordered
 *              有状态：数据处理时，会收到中间操作的影响
 *                  distinct/sarted/limit/skip
 *      5.终结操作|结束操作{Terminal}
 *          需要注意:一个stream对象；只能有一个Treminal,这个操作一但发生，就会真实处理数据
 *          ，生成对应的处理结果，是不可逆
 *          终结操作：非短路操作 ：当前的Stream对象必须处理集合所有数据，才能得到处理结果
 *                      forEach/forEachOrdered/toArray/redue/collect/min/max/count/iteratar
 *                      短路操作：当前的stream 对象在处理过程中，一旦满足某个条件，就可以得处理结果
 *                        anyMatch/allMatch/noneMatch/finfFirest/findAny等
 *
 *                        shart-circuting 无限大的Steam -> 有限大的Stream
 *
 *
 */
public class Test3 {

    @Test
    public void test1(){
        //1.批量数据（集合、数组等） -> Stream对象
        //多个数据
        Stream stream = Stream.of("admin","tom","imooc");
        System.out.println(stream);
        //数组
        String [] strings = new String[]{"biyao","xueqi"};
        Stream stream2 = Arrays.stream(strings);
        //列表
        List<String> list = new ArrayList();
        list.add("少林");
        list.add("武当");
        Stream stream3 = list.stream();
        //集合
        Set<String> strings1 = new HashSet();
        strings1.add("少林罗汉拳");
        strings1.add("武当太极拳");
        Stream stream4 = strings1.stream();
        //map k -v
        Map<String,Integer> map = new HashMap();
        map.put("tom",1000);
        map.put("jerry",2000);
        map.put("imooc",800);
        Stream stream5 = map.entrySet().stream();
        //2.Stream 对于基本数据类型的功能进行封装
        //频繁装箱和拆箱的操作
        //int /long/double  基本数据在运算的过程中，是装箱的操作，在数据出处理过成中是拆箱的操作
       /* IntStream.of(new int[]{10,20,30}).forEach(System.out:: println);
        IntStream.range(1,5).forEach(System.out ::println);//范围操作
        IntStream.rangeClosed(1,5).forEach(System.out ::println);//范围操作*/
        /**
         * IntStream var10000 = IntStream.of(new int[]{10, 20, 30});
         *         PrintStream var10001 = System.out;
         *         System.out.getClass();
         *         var10000.forEach(var10001::println);
         */
        //3.Stream对象 --> 装换得到指定的数据类型
        //数据 可以指定转换为某种类型
//        Object [] objects = stream.toArray(String[]::new);
       /* //字符串   stream has already been operated upon or closed 因为上面的终端操作了
        String str = stream.collect(Collectors.joining()).toString();//将集合中的数组，分隔拼接成字符串
        System.out.println(str);*/
       /* //列表
        List<String> listx = (List<String>) stream.collect(Collectors.toList());
        System.out.println(listx);
*/
        //集合
      /*  Set<String> setx = (Set<String>) stream.collect(Collectors.toSet());
        System.out.println(setx);*/
        /*//map
        Map<String,String> mapx = (Map<String, String>) stream.collect(Collectors.toMap(x -> "key"+x, y -> "value"+y));
        System.out.println(mapx);*/

        /**
         * 4.Stream 中常见的API操作
         */
        List<String> accountList = new ArrayList();
        accountList.add("songjiang");
        accountList.add("wusong");
        accountList.add("luzhishen");
        //在每个数据前面增加一个数据 ：梁山好汉
        //map() 中间操作。map()方法接受一个Function接口
//        accountList = accountList.stream().map(x -> "梁山好汉："+x).collect(Collectors.toList());
        //filter()添加过滤条件，过滤符合条件的用户  -获取长度等于6
//        accountList = accountList.stream().filter(x -> x.length()>6).collect(Collectors.toList());
        //forEach 增强型循环
//        accountList.forEach(x -> System.out.println("forEach->"+x));
        //peek() 中间操作，迭代数据完成数据的依次处理过程
       /* accountList.stream()
                .peek(x -> System.out.println("peek1:"+x))
                .peek(x -> System.out.println("peek2:"+x))
                .forEach(System.out::println);
        accountList.forEach(System.out::println);*/
        /**
         * stream 对数据运算的支持
         */
        List<Integer> integerList = new ArrayList();
        integerList.add(20);
        integerList.add(19);
        integerList.add(7);
        integerList.add(100);
        integerList.add(120);
        integerList.add(3);
        integerList.add(7);
        /**
         * 取几个用的数据
         */
        //skip() 中间操作，有状态，跳过部分数据，完成数据的提取 跳过3个数据
//        integerList.stream().skip(3).forEach(System.out::println);
        //limt() 中间操作，有状态 ，限制输出数据量
//        integerList.stream().skip(3).limit(2).forEach(System.out::println);

        //dinstinct () 中间操作，有状态 去掉重复的数据
//        integerList.stream().distinct().forEach(System.out ::println);
        //sorted ()中间操作 ，有状态，排期
//        integerList.stream().sorted().forEach(System.out::println);
        //max() 获取最大值 optional是基本数据的包装类型
       /* Optional optional = integerList.stream().max((x,y) -> x -y);
        System.out.println(optional.get());*/
        //min() 获取最小数据
        Optional optional = integerList.stream().min((x,y) -> x -y);
        System.out.println(optional.get());
        //reduct() 合并数据处理 -技术上面所有数据的和
        Optional optional1 = integerList.stream().reduce((sum,x) -> sum+x);
        System.out.println(optional1.get());
    }

}
