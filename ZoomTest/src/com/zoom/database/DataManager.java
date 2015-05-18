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
}
