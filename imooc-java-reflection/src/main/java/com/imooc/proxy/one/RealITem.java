package com.imooc.proxy.one;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 具体实现主题类
 * itemFill();描述第二级查询时，如何获得content、plan字段具体内容的过程，但是何时调用、怎样调用该方法并没有在本类中没有体现，是由代理类完成的
 */
public class RealITem implements IITem {
    private String account;//账号
    private String name;//主持人名称
    private String project;//项目名称
    private String content;//项目主要内容
    private String plan;//计划安排

    @Override
    public String getAccount() {
        return account;
    }

    @Override
    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getProject() {
        return project;
    }

    @Override
    public void setProject(String project) {
        this.project = project;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getPlan() {
        return plan;
    }

    @Override
    public void itemFill() throws Exception {//填充项目content及plan字段
        //第2级查询sql语句
        String strSql ="select content,plan from projecttemp where account='"+account+"'";
        DbProc dbobj = new DbProc();
        Connection connection = dbobj.connect();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(strSql);
        rst.next();
        content = rst.getString("content");//填充content字段
        plan = rst.getString("plan");//填充plan字段
        rst.close();stm.close();connection.close();

    }


}
