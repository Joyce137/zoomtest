package com.zoom.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class DatabaseManager {
	//�������B��
	private static Connection connect;
	private static Statement stmt;
	public static Statement getMySqlstate(){
		try {
			//����MYSQL JDBC�������� 
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
		    //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������
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
