package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.src.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	//@FindBy(xpath="//td[@class='datacardtitle'][normalize-space()='']")
	WebElement contactLable;
	
@FindBy(xpath="//input[@value='52905718']")
WebElement checkboxSelect;

@FindBy(id="first_name")
@CacheLookup//it will store this element in cache and it will get search faster
WebElement fristName;
@FindBy(id="middle_initial")
WebElement middleName;
@FindBy(id="surname")
WebElement surname;

@FindBy(name="client_lookup")
WebElement client_lookup;

@FindBy(xpath="//input[@type='submit' and @value='Save']")
WebElement saveButton;

	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifycontactLable()
	{
		return contactLable.isDisplayed();
	}
	public void selectRecord()
	{
		checkboxSelect.click();//input[@value='52905718']
	}
		
	public void createNewContact(String title,String FristName,String middle,String LastName,String company)
	{
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		fristName.sendKeys(FristName);
		middleName.sendKeys(middle);
		surname.sendKeys(LastName);
		client_lookup.sendKeys(company);
		saveButton.click();
	}
	
	
}
