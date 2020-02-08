package com.imooc.proxy.one;

import com.imooc.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 * 代理项目集合类
 * 对于数据库应用来说，往往是记录的集合进行操作的，因此若用到代理模式，则一般有一个代理基本类，如ProxyItem,代理集合管理类，如ManageItems
 */
public class ManageItems {
    Vector<Proxyitem> v = new Vector();//代理项目集合
    public void firstSearch()throws Exception{
        //第2级查询sql语句
        String strSql ="select account,name,project from projecttemp";//第一级查询sql语句
        Connection connection = DBUtil.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(strSql);//获得一级查询记录集合
        while (rst.next()){
            Proxyitem obj = new Proxyitem(new RealITem());
            obj.setAccount(rst.getString("account"));
            obj.setName(rst.getString("name"));
            obj.setProject(rst.getString("project"));
            v.add(obj);
        }
        rst.close();stm.close();connection.close();
    }
}
