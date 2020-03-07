package com.hmrs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hmrs.testbase.BaseClass;

public class AddEmployee {
	
	@FindBy(id = "firstName")
	public WebElement firstName; 
	
	@FindBy(id = "lastName")
	public WebElement lastName;
	
	@FindBy(id = "btnSave")
	public WebElement saveBtn;
	
	@FindBy(xpath = "//div[@id='profile-pic']/h1")
	public WebElement verify;
	
	public AddEmployee() {
    	PageFactory.initElements(BaseClass.driver, this);
    }

}
