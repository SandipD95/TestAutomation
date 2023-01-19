package com.scm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import com.src.qa.base.TestBase;



public class HomePageTest extends TestBase{
   TestUtil TestUtil;
	HomePage HomePage;
	LoginPage loginPage;
	ContactsPage ContactsPage;
	public HomePageTest()
	{
	super();	//to call super class constructor i. base class
	}
	
	@BeforeMethod
	public void setup() {
		initialize();
		  TestUtil=new TestUtil();
		 loginPage=new LoginPage(); 
	HomePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
		}
	@Test(priority=1)
	public void verifyPageTitle()
	{
		String HomePageTitle=HomePage.homePageTile();
		Assert.assertEquals(HomePageTitle, "CRMPRO","home page title not matched");
		
	}
	@Test(priority=2)
	public void userVerification()
	{
	TestUtil.Switchfram();
	boolean a=HomePage.loginuser();
		Assert.assertTrue(a,"UserName not dispalyed");
	}
	@Test
	public void verityContactPage()
	{
		TestUtil.Switchfram();
		ContactsPage=HomePage.clickOnContact();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
}
