package com.zoom.tasks;

import org.testng.annotations.Test;

import com.zoom.cons.BrowserAction;
import com.zoom.pages.Account;
import com.zoom.pages.Billing;
import com.zoom.pages.Group;
import com.zoom.pages.Sub;
import com.zoom.testdata.AccountData;

public class AccountTask {
	private Account account  = new Account();
	private Billing billing  = new Billing();
	private Sub sub = new Sub();
	private Group group = new Group();
	int accountids[] = AccountData.getAccountids();
	
	//account page
	@Test
	public void accountpage(){
		//dashboard,
		account.testDashboard();
		//account info½M¼þ£º type,  role, changeowner, name, alias, domains, vanityurl, update
		for(int i = 0 ;i<accountids.length;i++){
			account.testType(accountids[i]);
			account.testRole(accountids[i]);
			account.testName(accountids[i]);
			account.testAlias(accountids[i]);			
		}
		account.testChangeowner();
		account.testDomains();
		account.testVanityurl();
		account.testUpdate();
		
		//options½M¼þ(19)
		for(int i = 0;i<19;i++){
			for(int j = 0 ;j<accountids.length;j++){
				account.testOptions(i, accountids[j]);
				account.testTeleconfinfo(accountids[j], "12345");
			}				
		}
		account.testSaveoptions();
	}
	
	//billing page
	@Test
	public void billingpage(){
		//links
		for(int i = 0;i<5;i++){
			billing.testLink(i);
		}
		//billing info(14‚€)
		String inputvalues[] = new String [14];
		for(int i = 0;i<inputvalues.length;i++){
			inputvalues[i] = "123";
			//billing cardnumber³ýÍâ
			if(i == 7)
				inputvalues[i] = "41111111111111111";
		}
		//payment type
		billing.testPaymenttype(0);
		//selectors(3)month, year, country
		for(int i = 0;i<3;i++){
			billing.testTimes(i, null);
		}
		
		billing.testSubmit();
		billing.testPrint();
	}
	
	//subaccount page
	@Test
	public void subpage(){
		sub.testDashboard();
		sub.testAccountlist();
		sub.testSearchkey("c");
		sub.testSearchbtn();
		sub.testAddnew();
		sub.testDisassociate();
		sub.testExport();		
	}
	
	//group
	@Test
	public void grouppage(){
		//search
		group.testSearchgroup("1");
		group.testSearchbtn();
		//add new group
		group.testAddnew();
		//group action
		group.testLinkdetail();
		BrowserAction.back();
		group.testEdit();
		BrowserAction.refresh();
		group.testDelete();
		BrowserAction.refresh();
		group.testEmail();
		group.getEmail().click();
		group.testDetailmove();
		group.testDetaildelete();
	}
}
