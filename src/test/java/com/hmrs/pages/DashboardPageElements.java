package com.hmrs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hmrs.testbase.BaseClass;
import com.hmrs.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods{
	@FindBy(linkText = "Leave")
	public WebElement leave;
	
	@FindBy(linkText = "Leave List")
	public WebElement leaveList;
	
	@FindBy(linkText = "PIM")
	public WebElement pim;
	
	@FindBy(id = "menu_pim_addEmployee")
	public WebElement addEmp;
	
	@FindBy (id ="welcome")
	public WebElement welcome;
	
	
	public DashboardPageElements() {
    	PageFactory.initElements(BaseClass.driver, this);
    }
	
	public void navigateToLeaveList() {
		jsClick(leave);
		jsClick(leaveList);
	}
	
	public void  navigateToAddEmployee() {
		jsClick(pim);
		jsClick(addEmp);
	}
	
	
	
	
	
	
	
	
	
	
	

}
