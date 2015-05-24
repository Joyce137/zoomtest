package com.zoom.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;

public class DebugLog {
	
	public static void Log(String tag,String log)
	{
		if(true)
		    System.out.println(log);
	}
	
	public static void Log(String log)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String date=dateFormat.format(new java.util.Date());
		File file = new File("logs.txt");
		FileOutputStream fos = null;
		 BufferedWriter bw = null;

		if(true){
			try {
			 	 fos = new FileOutputStream(file, true);
			 	 bw = new BufferedWriter(new OutputStreamWriter(fos));
			     bw.write("<" + date + ">" + log+"\n");
			 }
			 catch (FileNotFoundException fnfe) {
			     fnfe.printStackTrace();
			 }
			 catch (IOException ioe) {
			     ioe.printStackTrace();
			 }
			 finally {
			     try {
			  if (bw != null)
			      bw.close();
			  if (fos != null)
			      fos.close();
			     }
			     catch (IOException ie) {
			     }
			 }
		}
	}
}
