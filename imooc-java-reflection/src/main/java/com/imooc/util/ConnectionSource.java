package com.imooc.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;
import javax.swing.ComboBoxEditor;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 	访问数据库
 * 后在该类中添加init方法，在该方法中数据源信息进行初始，代码如下所示：
 * @author Administrator
 *
 */

public class ConnectionSource {
	public static void main(String[] args) {
		getConnection();
//		ResultSet rs ;
////		rs.getMetaData().getCatalogName('');//获取列表
	}
	//数据源
	private static BasicDataSource dataSource=null;//如果在上面属性里面面 new就是单利模式中的俄汉模式 
	private static DataSource ds=null;//如果在上面属性里面面 new就是单利模式中的俄汉模式 
	//配置文件名
	private static final String CONFIGFILE="D:\\IdeaWorkspace\\lambda\\imooc-java-reflection\\src\\main\\resouce\\db.properties";
	private static final String CONFIGDSFILE="/db.properties";
	public static void init(){
		Properties dbProps = new Properties();//这个是第二种的单利模式中的懒汉模式
		//去配置文件
		try {
			dbProps.load(ConnectionSource.class.getClassLoader().getResourceAsStream(CONFIGFILE));
			String drive = dbProps.getProperty("jdbc.driver");
			String url = dbProps.getProperty("jdbc.url");
            String username = dbProps.getProperty("jdbc.user");
            String password = dbProps.getProperty("jdbc.password");
            
            // 加载配置文件
            String initialSize = dbProps.getProperty("dataSource.initialSize");
            String minIdle = dbProps.getProperty("dataSource.minIdle");
            String maxIdle = dbProps.getProperty("dataSource.maxIdle");
            String maxWait = dbProps.getProperty("dataSource.maxWait");
            String maxActive = dbProps.getProperty("dataSource.maxActive");
            
            
            dataSource= new BasicDataSource();
            dataSource.setDriverClassName(drive);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            
            // 初始化连接数
           if(initialSize!=null){
        	   dataSource.setInitialSize(Integer.valueOf(initialSize));
           }
           // 最小空闲连接
           if(minIdle!=null){
        	   dataSource.setMinIdle(Integer.valueOf(minIdle));
           }
        // 最大空闲连接
           if (maxIdle != null)
               dataSource.setMaxIdle(Integer.parseInt(maxIdle));
           
           // 最大连接数
           if (maxActive != null) {
               if (!maxActive.trim().equals("0"))
                   dataSource.setMaxActive(Integer.parseInt(maxActive));
           }
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
            e.printStackTrace();
            System.out.println("创建连接池失败!请检查设置!!!");
        }
	}
	//这个和上面的那个set是一样的
	private static void initDbcp(){
		Properties dbProps = new Properties();//这个是第二种的单利模式中的懒汉模式
		try {
			dbProps.load(Object.class.getResourceAsStream(CONFIGDSFILE));
			ds =  BasicDataSourceFactory.createDataSource(dbProps);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 *  synchronized是对类的当前实例进行加锁， 防止其他线程同时访问该类的该实例的所有synchronized块，注意这里是“类的当前实例”， 类的两个不同实例就没有这种约束了
	 *  那么static synchronized恰好就是要控制类的所有实例的访问了，static synchronized是限制线程同时访问jvm中该类的所有实例同时访问对应的代码快。
	 *   结论：A: synchronized static是某个类的范围，synchronized static cSync{}防止多个线程同时访问这个    类中的synchronized static 方法。它可以对类的所有对象实例起作用。
   
             B: synchronized 是某实例的范围，synchronized isSync(){}防止多个线程同时访问这个实例中的synchronized 方法。
               
	 */
	//从数据源中获取一个连接
	public static synchronized Connection getConnection (){
		if(dataSource==null){
			init();
		}
		Connection conn =null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			
			e.printStackTrace(System.err);
		}
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	//从数据源中获取一个连接
	public static synchronized Connection getConnectionDS(){
		if(ds==null){
			initDbcp();
		}
		Connection conn =null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			
			e.printStackTrace(System.err);
		}
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//从数据源中获取一个连接
	public static synchronized Connection getConnectionC3p0(){
		ComboPooledDataSource ds = new ComboPooledDataSource();
		Connection conn =null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			
			e.printStackTrace(System.err);
		}
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("关闭连接时发生异常");
			}
		}
	}
}
