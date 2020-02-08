package com.imooc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	private static Properties properties = new Properties();
	private static String DRIVER = null;
	private static String URL = null;
	private static String USER = null;
	private static String PWD = null;
	static {
		try {
			// 加载配置文件
			properties.load(DBUtil.class.getClassLoader().getResourceAsStream(
					"db.properties"));
			DRIVER = properties.getProperty("jdbc.driver");
			URL = properties.getProperty("jdbc.url");
			USER = properties.getProperty("jdbc.user");
			PWD = properties.getProperty("jdbc.password");
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PWD);
	}

	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("关闭连接时发生异常");
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Connection con = DBUtil.getConnection();
		Statement state = con.createStatement();
		ResultSet rs = state.executeQuery("select user_name,age from imooc_goddess");
		while (rs.next()){
            System.out.println(rs.getString("user_name")+":"+ rs.getInt("age") );
        }
	}
}
