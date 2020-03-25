package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePOM {
	private WebDriver driver; 
	
	public HomePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
//Project eLearning	
	//To locate and click on 'Sign Up!' link,
	@FindBy(linkText="Sign up!")			
	private WebElement SignUp_link;
	
	public void clickSignUp() {
		this.SignUp_link.click();
	}
	
	//To locate and click on Edit Profile link,
	@FindBy(linkText="Edit profile")
	private WebElement EditProfile;
	
	public void ClickEditProfile() {
		this.EditProfile.click();
	}
	


//For Magento test
	@FindBy(className="fa-user")			
	private WebElement user_icon; 
	
	public void clickUserIcon() {
		this.user_icon.click();
	}
	
	
	
}
