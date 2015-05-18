package com.zoom.pages;

import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.zoom.cons.DriverManager;
import com.zoom.cons.ElementOperation;
import com.zoom.cons.LocatorManager;
import com.zoom.database.DatabaseManager;

public class Group {
	private WebDriver driver = DriverManager.getDriver();
	private Statement stmt = DatabaseManager.getMySqlstate();
	//����LocatorManager����
	private LocatorManager yaml = new LocatorManager("group");
	//�����M��
	private WebElement searchgroup, searchbtn, addnew, linkdetail, edit, delete;
	//detail group info
	private WebElement email, detaildelete, detailmove;
	
	//���캯����ʼ���M��
	public Group(){
		searchgroup = yaml.getElement("searchgroup");
		searchbtn = yaml.getElement("searchbtn");
		addnew = yaml.getElement("addnew");
		linkdetail = yaml.getElement("linkdetail");
		edit = yaml.getElement("edit");
		delete = yaml.getElement("delete");
		email = yaml.getElement("email");
		detaildelete = yaml.getElement("detaildelete");
		detailmove = yaml.getElement("detailmove");
	}
	//�M��get����
	public WebElement getSearchgroup() {
		return searchgroup;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getAddnew() {
		return addnew;
	}

	public WebElement getLinkdetail() {
		return linkdetail;
	}

	public WebElement getEdit() {
		return edit;
	}

	public WebElement getDelete() {
		return delete;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getDetaildelete() {
		return detaildelete;
	}

	public WebElement getDetailmove() {
		return detailmove;
	}
	
	//�M���Ļ����yԇ����
	String inputgroup = null;
	String currentgroup = linkdetail.getText();
	//searchgroup
	public void testSearchgroup(String value){
		ElementOperation eo = new ElementOperation(driver, searchgroup);
		eo.inputOperation(value);
		inputgroup = value;
	}
	//searchbtn
	public void testSearchbtn(){
		searchbtn.click();
		String groupstr = currentgroup;
		boolean is = groupstr.indexOf(inputgroup)>0?true:false;
		Assert.assertEquals(is, true);
	}
	//addnew
	public void testAddnew(){
		addnew.click();
		//�@ȡ�I�Pݔ��newgroup
		String newgroup = "new";
		//������group����������
		try {
			stmt.execute("insert group('name') values("+newgroup+")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//linkdetial
	public void testLinkdetail(){
		linkdetail.click();
	}
	//edit
	public void testEdit(){
		edit.click();
	}
	//delete;
	public void testDelete(){
		delete.click();
		//�@ȡҪ�h���ĽM��
		String delgroup = currentgroup;
		//�ڔ������Єh���M
		try {
			stmt.execute("delete from group where name = "+delgroup);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//email
	public void testEmail(){
		Assert.assertEquals(currentgroup, email.getText());
	}
	//detaildelete
	public void testDetaildelete(){
		delete.click();
		//�ڔ������Єh���M
		try {
			stmt.execute("delete from group where name = "+email.getText());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//detailmove;
	public void testDetailmove(){
		detailmove.click();
	}
}
