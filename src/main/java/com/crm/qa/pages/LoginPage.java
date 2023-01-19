package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.src.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//pagefactory
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbutton;
	
	@FindBy(xpath="//a[contains(text(),'SignUp')]")
	WebElement SignUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement logo;
	//initializing page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	//actions
	public String validatePageTile()
	{
      return driver.getTitle();
	}
	public boolean validateLogo()
	{
		return logo.isDisplayed();
	}
	public HomePage login(String un,String pws)
	{
		username.sendKeys(un);
		password.sendKeys(pws);
		loginbutton.click();
		return new HomePage();
	//	return HomePage;
	}
	

}
