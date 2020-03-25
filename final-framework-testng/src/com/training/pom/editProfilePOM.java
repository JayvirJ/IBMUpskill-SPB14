package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class editProfilePOM {

private WebDriver driver;
	
	public editProfilePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	

	//To locate and type value in password box,	
	@FindBy(id="profile_password0")
	private WebElement pass; 
	
	public void sendPass(String pwd) {
		this.pass.clear();
		this.pass.sendKeys(pwd);
	}
	

	//To locate and type value in New password box,
	@FindBy(name="password1")
	private WebElement newPass; 
	
	public void sendNewPass(String newPwd) {
		this.newPass.clear();
		this.newPass.sendKeys(newPwd);
	}
	
	
	//To locate and type value in Confirm password box,
	@FindBy(id="profile_password2")
	private WebElement confPass; 
	
	public void sendConfPassword(String confPwd) {
		this.confPass.clear();
		this.confPass.sendKeys(confPwd);
	}
	
	//To locate and click on "Save Changes" button and to verify message,
	@FindBy(name="apply_change")			
	private WebElement SaveChangesBtn;
	
	@FindBy(xpath="//section[@id='cm-content']/div/div[2]/div/div[1]")
	private WebElement Msg;
	
	public void clickSaveChanges() {
		this.SaveChangesBtn.click();
		
		String Msg = this.Msg.getText();
		System.out.println(Msg);
		Assert.assertEquals(Msg, "Your new profile has been saved");
	}

}
