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
	//����sql
	public static void executesql(String sql){
		try {
			stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	//��user�Ы@ȡĳ��user��Ϣ(ͨ�^id)
	public static String getuserinfo(int userid, String item){
		String sql = "select "+item +" from user when id = "+userid;
		return query(sql);
	}
	//��user�Ы@ȡĳ��user��Ϣ(ͨ�^email)
	public static String getuserinfo(String useremail, String item){
		String sql = "select "+item +" from user when email = "+useremail;
		return query(sql);
	}
	//����update user
	public static void updateuser(int userid, String item, String value){
		String sql = "update user set "+item+" = "+value+" where id = "+userid;
		executesql(sql);
	}
	
	//ͨ�^account email�@ȡaccount id
	public static int getaccountid(String value){
		String sql = "select id from user when email = "+value;
		int id = query(sql).charAt(0)-'0';
		return id;
	}
}
