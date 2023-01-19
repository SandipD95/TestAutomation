package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.src.qa.base.TestBase;

public class HomePage extends TestBase{

	
	
	@FindBy(xpath="//td[contains(text(),'User: sandip dahatonde')]")
	WebElement userName;
	
	@FindBy(xpath="//a[@title=\"Home\"]")
	WebElement HomeLink;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealsTab;
	@FindBy(xpath="//a[contains(text(),'task')]")
	WebElement taskLink;
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement NewContactLink;
	@FindBy(xpath="//a[text()=\'New Deal\']")
	WebElement NewDeal;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String homePageTile()
	{
		return driver.getTitle();
	}
	
public boolean loginuser()
{
	
	return userName.isDisplayed();
}
public ContactsPage clickOnContact()
{
	contactsLink.click();
	return new ContactsPage();
}
public DealsPage clickOnDeals()
{
	DealsTab.click();
	return new DealsPage();
}
public TaskPage clickOnTask()
{
	taskLink.click();
	return new TaskPage();
}
public void clickOnNewContact()
{
	Actions action=new Actions(driver);
	action.moveToElement(contactsLink).build().perform();
	NewContactLink.click();
	
}
}
