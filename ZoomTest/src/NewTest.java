

import java.util.*;
import org.testng.*;
import org.testng.annotations.*;


public class NewTest {
	private Collection c;
		 
	//��������
	@BeforeSuite
	public void t1(){
		System.out.println("ע��ķ�����ֻ����һ�Σ���ע�͵ķ����������в�������ǰ���С�");
	}
	
	@AfterSuite
	public void t2(){
		System.out.println("ע��ķ�����ֻ����һ�Σ���ע�͵ķ����������в������к����С�");
	}
	
	@BeforeClass
	public void t3(){
		System.out.println("ע��ķ�����ֻ����һ�Σ���ע�͵ķ������ڲ�������ǰ���С�");
	}
	
	@AfterClass
	public void t4(){
		System.out.println("ע��ķ�����ֻ����һ�Σ���ע�͵ķ������ڲ������к����С�");
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
   
    //��ʱ����
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
    
    //�ڴ��쳣����
	 @Test(expectedExceptions = ArithmeticException.class)  
	    public void divisionWithException() {  
	        int i = 1 / 0;  
	 }
	 
	 //���Բ���
	 @Test(enabled = false)
	 public void test(){
		 System.out.println("It is ignored.");
	 }
	 
}
