package com.hmrs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hmrs.testbase.BaseClass;
import com.hmrs.utils.CommonMethods;

public class loginPagesElements extends CommonMethods{
	
	@FindBy(xpath="//div[@id='divLogo']")
    public WebElement logo;
    
    @FindBy(id="loginPanelHeading")
    public WebElement loginLabel;
    
    @FindBy(id="txtUsername")
    public WebElement username;
    
    @FindBy(css="input#txtPassword")
    public WebElement password;
    
    @FindBy(css="input[name='Submit']")
    public WebElement loginBtn;

    @FindBy(id="spanMessage")
    public WebElement erroMsg;
    
    public loginPagesElements() {
    	PageFactory.initElements(BaseClass.driver, this);
    }
    
    public void login(String uId, String pwd) {
    	sendText(username, uId);
    	sendText(password, pwd);
    	click(loginBtn);
    	
    	
    }
    
    

}
