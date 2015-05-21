package com.zoom.database;

import java.sql.*;

public class DataManager {
	private static Statement stmt = DatabaseManager.getMySqlstate();
	
	//查詢
	public static String query(String sql){
		String result = null;
		try {
			result = stmt.executeQuery(sql).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result==null){
			System.out.println("沒有該user, enter new uerid.");
		}
		return result;
	}
	//執行sql
	public static void executesql(String sql){
		try {
			stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//在user中通過userid得到pmi
	public static String getpmi(int userid){
		String sql = "select pmi from user when id = "+userid;
		return query(sql);
	}
	//從meeting中獲取某個meeting信息
	public static String getinfo(String meetingid, String item){
		String sql = "select "+item +" from meeting when meetingid = "+meetingid;
		return query(sql);
	}
	//從user中獲取某個user信息(通過id)
	public static String getuserinfo(int userid, String item){
		String sql = "select "+item +" from user when id = "+userid;
		return query(sql);
	}
	//從user中獲取某個user信息(通過email)
	public static String getuserinfo(String useremail, String item){
		String sql = "select "+item +" from user when email = "+useremail;
		return query(sql);
	}
	//執行update user
	public static void updateuser(int userid, String item, String value){
		String sql = "update user set "+item+" = "+value+" where id = "+userid;
		executesql(sql);
	}
	
	//通過account email獲取account id
	public static int getaccountid(String value){
		String sql = "select id from user when email = "+value;
		int id = query(sql).charAt(0)-'0';
		return id;
	}
}
