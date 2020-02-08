package com.imooc.proxy.one;

/**
 * 定义抽象主题接口 IITem
 * 是以一个项目的所有项目信息为单位的。前三个字段，有get\set方法，表明这三个自断地额信息是直接从事护数据库表得到的。而后面两个字段 只有get方法，表明这两个字段的信息仅当第二及查询时才填充完毕，有itemFill()方法完成
 */
public interface IITem {
    String getAccount();void setAccount(String s);//账号
    String getName();void setName(String s);//主持人名称
    String getProject();void setProject(String s);//项目名称
    String getContent();//项目主要内容
    String getPlan();//计划
    void itemFill()throws Exception;//用来在第二级查询时，才填充信息
}
