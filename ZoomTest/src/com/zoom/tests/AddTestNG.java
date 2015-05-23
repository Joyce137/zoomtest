package com.zoom.tests;

import java.util.ArrayList;
import java.util.Collection;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AddTestNG {
	private Collection c;
	//基本测试
	@BeforeSuite
	public void t1(){
		System.out.println("注解的方法将只运行一次，被注释的方法将在所有测试运行前运行。");
	}
	
	@AfterSuite
	public void t2(){
		System.out.println("注解的方法将只运行一次，被注释的方法将在所有测试运行后运行。");
	}
	
	@BeforeClass
	public void t3(){
		System.out.println("注解的方法将只运行一次，被注释的方法将在测试运行前运行。");
	}
	
	@AfterClass
	public void t4(){
		System.out.println("注解的方法将只运行一次，被注释的方法将在测试运行后运行。");
	}
	
    @BeforeMethod  
    public void setUp() {  
        c = new ArrayList();  
        System.out.println("@BeforeMethod - setUp");  
    }  
   
    @AfterMethod  
    public void tearDown() {  
        c.clear();  
        System.out.println("@AfterMethod - tearDown");  
    }  
   
    //超时测试
  	 @Test(timeOut = 1000)
  	 public void tout(){
  		 while(true);
  	 }
  	 
    @Test  
    public void testEmptyCollection() {  
        Assert.assertEquals(c.isEmpty(),true);  
        System.out.println("@Test - testEmptyCollection");  
    }  
   
    @Test  
    public void testOneItemCollection() {  
        c.add("itemA");  
        Assert.assertEquals(c.size(),1);  
        System.out.println("@Test - testOneItemCollection");  
    }
    
    //期待异常测试
	 @Test(expectedExceptions = ArithmeticException.class)  
	    public void divisionWithException() {  
	        int i = 1 / 0;  
	 }
	 
	 //忽略测试
	 @Test(enabled = false)
	 public void test(){
		 System.out.println("It is ignored.");
	 }
	 
	 public void testall(){
		 
	 }
}
