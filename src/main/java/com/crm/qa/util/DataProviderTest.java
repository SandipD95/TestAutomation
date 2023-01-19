package com.crm.qa.util;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@Test(dataProvider="loginData")
	public void loginTest(String mail,String pass,String status) {
		System.out.println(mail +"  "+pass+" "+status);
	}
	
	@DataProvider(name="loginData")
	public Object[][] dataProviderMethod()
	{
		Object[][] data= {{"Mr.","abc","valid","Om","Sai"},{"Mr.","efg","invalid","Om","Sai"},{"Mr.","mno","valid","Om","sai"}};
		return data;
	}
}

