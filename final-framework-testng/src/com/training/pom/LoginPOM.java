package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
//Project eLearning	
	@FindBy(id="login")
	private WebElement uName; 
	
	public void sendUName(String username) {
		this.uName.clear();
		this.uName.sendKeys(username);
	}
	
	
	@FindBy(id="password")
	private WebElement pwd;
	
	public void sendPWD(String password) {
		this.pwd.clear();
		this.pwd.sendKeys(password);
	}
	
	@FindBy(name="submitAuth")
	private WebElement login; 
	
	public void clickLogin() {
		this.login.click(); 
	}
		
	
	@FindBy(linkText="Homepage")
	private WebElement homepage;
	
	public void clickHomepage() {
		this.homepage.click(); 
	}
	
	
	
//For Magento test
	@FindBy(id="email")							
	private WebElement userName; 
	
	@FindBy(id="pass")
	private WebElement password;
	
	@FindBy(id="send2")
	private WebElement loginBtn; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	
}
