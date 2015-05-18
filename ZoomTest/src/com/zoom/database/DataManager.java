package com.zoom.database;

import java.sql.*;

public class DataManager {
	private static Statement stmt = DatabaseManager.getMySqlstate();
	
	//��ԃ
	public static String query(String sql){
		String result = null;
		try {
			result = stmt.executeQuery(sql).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result==null){
			System.out.println("�]��ԓuser, enter new uerid.");
		}
		return result;
	}

	//��user��ͨ�^userid�õ�pmi
	public static String getpmi(int userid){
		String sql = "select pmi from user when id = "+userid;
		return query(sql);
	}
	//��meeting�Ы@ȡĳ��meeting��Ϣ
	public static String getinfo(String meetingid, String item){
		String sql = "select "+item +" from meeting when meetingid = "+meetingid;
		return query(sql);
	}
}
