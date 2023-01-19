package com.scm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.DataProviderTest;
import com.crm.qa.util.TestUtil;
import com.src.qa.base.TestBase;

public class ContactPageTest extends TestBase{
	ContactsPage ContactsPage;
	LoginPage loginPage;
	HomePage HomePage;
	TestUtil TestUtil;
	
	
	
	ContactPageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup()
	{
		initialize();
		ContactsPage=new ContactsPage();
		 loginPage=new LoginPage(); 
		 TestUtil=new TestUtil();
		 HomePage=new HomePage();
			HomePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
			TestUtil.Switchfram();
		//	ContactsPage=HomePage.clickOnContact();
	
		
	}
	
	@Test
	public void contactPageLable()
	{
	boolean b=ContactsPage.verifycontactLable();
	Assert.assertTrue(b,"Lable not found");
	}
	
	@Test
	public void selectRecord()
	{
		ContactsPage.selectRecord();
		
	}
@Test(dataProvider="loginData",dataProviderClass=DataProviderTest.class)
public void validateCreateNewContact(String a,String b,String c,String d,String e)
{
	HomePage.clickOnNewContact();
	ContactsPage.createNewContact(a,b,c,d,e);
	
}
@Test(dataProvider="excelData",dataProviderClass=TestUtil.class)
public void validateCreateNewContactFromExcel(String a,String b,String c,String d,String e)
{
	HomePage.clickOnNewContact();
	ContactsPage.createNewContact(a,b,c,d,e);
	
}

@Test
public void validateCreateNewContactbyhardvalue()
{
	HomePage.clickOnNewContact();
	ContactsPage.createNewContact("Mr.","aaa","aaa","aaa","aaa");
	
}


@Test(dataProvider="loginData",dataProviderClass=DataProviderTest.class)
public void loginBydata(String mail,String pass)
{
	System.out.println(mail+"  "+pass);
}
@AfterMethod
public void teardown()
{
	driver.close();
}
	
}
