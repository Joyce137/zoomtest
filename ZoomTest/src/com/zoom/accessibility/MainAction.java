package com.zoom.accessibility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainAction { 
	  public static void readTest(){  
	      System.out.println("readTest,����������...");  
	        InputStreamReader is = new InputStreamReader(System.in);  
	        BufferedReader br = new BufferedReader(is);  
	        try {  
	            String name = br.readLine();  
	            System.out.println("readTest,�����"+name);  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	  }  
	  public static void scannerTest(){  
	      System.out.println("scannerTest,����������...");  
	      @SuppressWarnings("resource")
		  String name=new Scanner(System.in).nextLine();  
	      System.out.println("scannerTest,�����"+name);  
	  }  
}
