package com.hmrs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hmrs.testbase.BaseClass;

public class LeaveListPageElements {
	@FindBy(css="a.toggle.tiptip")
	public WebElement leaveListLable;
	
	
	public LeaveListPageElements() {
    	PageFactory.initElements(BaseClass.driver, this);
    }
	

}
