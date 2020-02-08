package com.imooc.stteam;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    @Test
    public void test1(){
        //1.添加测试数据：存储多个账号列表
        List<String> accounts = new ArrayList<String>();
        accounts.add("tom");
        accounts.add("jerry");
        accounts.add("shuke");
        accounts.add("damu");
        //1.1 业务要求：长度大于等于5的有效账号
        //传统
        /*

        通过迭代器方式 进行的
         Iterator var2 = accounts.iterator();

        while(var2.hasNext()) {
            String account = (String)var2.next();
            if (account.length() >= 5) {
                System.out.println("有效的账号：" + account);
            }
        }
        */
        for (String account :accounts){
            if(account.length()>= 5){
                System.out.println("有效的账号："+account);
            }
        }
        //1.2  迭代器方式进行的
        Iterator<String> iterator =  accounts.iterator();
        while(iterator.hasNext()){
            String account = iterator.next();
            if(account.length()>=5){
                System.out.println("有效的账号："+account);
            }
        }
        //1.3 Stream结合lambda 表达式，完成业务处理 获取当前stram对象 filter 进行过滤   返回长度大于5的账号, 最后将他返回成一个列表
        List vaiidAccounts = accounts.stream().filter( s -> s.length()>=5).collect(Collectors.toList());
        System.out.println(vaiidAccounts);
    }
}
