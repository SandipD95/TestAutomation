package com.scm.qa.testcases;

import org.junit.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import com.crm.qa.pages.LoginPage;
import com.src.qa.base.TestBase;

public class LoginTest extends TestBase {

	LoginPage LoginPage;
	public LoginTest()
	{
	super();	
	}
	@BeforeMethod
	public void  setup()
		{
		initialize();
		 LoginPage=new LoginPage();
		}
	@Test(priority=1)
	public void loginPageTitleTest()
	{
	String title=LoginPage.validatePageTile();
	System.out.println(title);
		Assert.assertEquals(title,"Free CRM - CRM software for customer relationship management, sales, and support.");
	}
	@Test(priority=2)
	public void crmLogTest()
	{
		boolean flag=LoginPage.validateLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest()
	{
		LoginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	Assert.assertEquals(driver.getTitle(),"CRMPRO");	
	}
	@AfterMethod(enabled=true)
	public void teardown()
	{
		driver.close();
	}
}
