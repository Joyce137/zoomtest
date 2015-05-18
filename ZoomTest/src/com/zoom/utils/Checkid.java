package com.zoom.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zoom.database.DatabaseManager;

public class Checkid {
	private static Statement stmt = DatabaseManager.getMySqlstate();
	//根據meeting id規範判斷meeting id is ok or not.
	//不能以0、1開頭
	public static boolean isnot01(String id){
		if(id.charAt(0)=='0'||id.charAt(0)=='1')
			return false;
		return true;
	}
	
	//非PMI9-11位
	public static boolean isOK(String id){
		int count = id.length();
		if(count<9||count>11||!isnot01(id))
			return false; 
		return true;
	}
	
	//PMI為10位
	public static boolean isPMIOK(String id){
		if(id.length()==10&&isnot01(id))
			return true;
		return false;
	}
	
	//是否是已存在的會id
	public static boolean isExisted(String id){
		try {
			String sql = "select * from meeting where id = "+id;
			System.out.println(sql.toString());
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()&&isOK(id))
				return true;
		} catch (SQLException e) {
			System.out.println("isExisted fail to execute query.");
			e.printStackTrace();
		}
		return false;
	}
	//是否是正在開的會
	public static boolean isOpened(String id){
		try {
			String sql = "select * from meeting where id = "+id+" and isopen = 0";
			System.out.println(sql.toString());
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()&&isOK(id))
				return true;
		} catch (SQLException e) {
			System.out.println("isOpened fail to execute query.");
			e.printStackTrace();
		}
		return false;
	}
}
