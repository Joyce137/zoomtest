package com.zoom.accessibility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainAction { 
	  public static void readTest(){  
	      System.out.println("readTest,请输入数据...");  
	        InputStreamReader is = new InputStreamReader(System.in);  
	        BufferedReader br = new BufferedReader(is);  
	        try {  
	            String name = br.readLine();  
	            System.out.println("readTest,输出："+name);  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	  }  
	  public static void scannerTest(){  
	      System.out.println("scannerTest,请输入数据...");  
	      @SuppressWarnings("resource")
		  String name=new Scanner(System.in).nextLine();  
	      System.out.println("scannerTest,输出："+name);  
	  }  
}
