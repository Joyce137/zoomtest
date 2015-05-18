package com.zoom.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class DatabaseManager {
	//數據庫連接
	private static Connection connect;
	private static Statement stmt;
	public static Statement getMySqlstate(){
		try {
			//加载MYSQL JDBC驱动程序 
		    Class.forName("com.mysql.jdbc.Driver");       
		    System.out.println("Success loading Mysql Driver!");
		}
		catch (Exception e) {
			System.out.print("Error loading Mysql Driver!");
		    e.printStackTrace();
		}
		try {
			connect = DriverManager.getConnection(
		          "jdbc:mysql://localhost:3306/zoomdata","zoomer","123");
		    //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
			stmt = connect.createStatement();
		    System.out.println("Success connect Mysql server!");
		}
		catch (Exception e) {
			connect = null;
		    System.out.print("Fail to connect Mysql server or create statment!");
		    e.printStackTrace();
		}
		return stmt;
	}
}
