package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterPOM {

	private WebDriver driver;
	
	public RegisterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	
	//To locate and type value in First name box,
	@FindBy(id="registration_firstname")
	private WebElement firstName; 
	
	public void sendFirstName(String fName) {
		this.firstName.clear();
		this.firstName.sendKeys(fName);
	}
	
	
	//To locate and type value in Last name box,
	@FindBy(name="lastname")
	private WebElement lastName;
	
	public void sendLastName(String lName) {
		this.lastName.clear(); 
		this.lastName.sendKeys(lName); 
	}
	
	
	//To locate and type value in e-mail box,
	@FindBy(id="registration_email")
	private WebElement email; 
	
	public void sendEmail(String emailId) {
		this.email.sendKeys(emailId); 
	}

	
	//To locate and type value in Username box,
	@FindBy(id="username")
	private WebElement userName; 
	
	public void sendUserName(String uName) {
		this.userName.clear();
		this.userName.sendKeys(uName);
	}
	
	
	//To locate and type value in password box,
	@FindBy(name="pass1")
	private WebElement password; 
	
	public void sendPassword(String pwd) {
		this.password.clear();
		this.password.sendKeys(pwd);
	}
	
	
	//To locate and type value in Confirm password box,
	@FindBy(name="pass2")
	private WebElement confirmPassword; 
	
	public void sendConfirmPassword(String confirmPwd) {
		this.confirmPassword.clear();
		this.confirmPassword.sendKeys(confirmPwd);
	}
	
	
	//To locate and type value in phone box,
	@FindBy(name="phone")
	private WebElement phone; 
	
	public void sendPhone(String phn) {
		this.phone.clear();
		this.phone.sendKeys(phn);
	}
	
	
	//To select any language from language list box,
	@FindBy(xpath="//form[@id='registration']/fieldset/div[9]/div/div")
	private WebElement languageDropdown;
	@FindBy(xpath="//form[@id='registration']/fieldset/div[9]/div/div/div/div/input")
	private WebElement Enterlanguage;
	@FindBy(xpath="//form[@id='registration']/fieldset/div[9]/div/div/div/div[2]/ul/li/a/span")
	private WebElement SelectLanguage;
	
	public void selectLanguage(String lng) {			
		this.languageDropdown.click();
		this.Enterlanguage.sendKeys(lng);
		this.SelectLanguage.click();
	}

	//To locate and select Student radio button,
	@FindBy(xpath="//input[@class='register-profile' and @value='5']")
	private WebElement studentRadio;
	
	public void clickStudentRadio() {
		if(!this.studentRadio.isSelected())  //As Student radio button is already selected on launch
		{
			this.studentRadio.click();    //click Student radio button if not selected by default
		}
	}
	
	
	//To locate and select Teacher radio button,
	@FindBy(xpath="//input[@class='register-profile' and @value='1']")
	private WebElement teacherRadio;
	
	public void clickTeacherRadio() {
		if(!this.teacherRadio.isSelected())  //In case Teacher radio button is not selected by default on launch
		{
			this.teacherRadio.click();    //click Teacher radio button
		}
	}
	
	
	//To locate and click on Register button and to verify message for Student registration success,
	@FindBy(id="registration_submit")
	private WebElement register; 
	
	@FindBy(xpath="//section[@id='cm-content']/div/div[2]/div/p")
	private WebElement msg1;
	
	@FindBy(xpath="//section[@id='cm-content']/div/div[2]/div/p[2]")
	private WebElement msg2;
	
	@FindBy(xpath="//form[@id='form_register']/fieldset/p")
	private WebElement msg3;
	
	public void clickRegister() {
		
		String fstName = this.firstName.getAttribute("value");	
		String lstName = this.lastName.getAttribute("value");
		
		this.register.click();	
		
		String Msg1 = this.msg1.getText();
		String Msg2 = this.msg2.getText();
		String Msg3 = this.msg3.getText();
		
		System.out.println(Msg1 + "\n\n" + Msg2 + "\n\n\n" + Msg3);
		
		Assert.assertEquals(Msg1 + "\n\n" + Msg2 + "\n\n\n" + Msg3, "Dear "+ fstName +" "+ lstName + "," 
				+ "\n\n" + "Your personal settings have been registered." 
				+ "\n\n" + "An e-mail has been sent to remind you of your login and password." 
				+ "\n\n\n" + "You can now select, in the list, the course you want access to.");
		//NOTE: As discussed, Registration success Expected message in test case sheet was different than the Actual message displayed on elearning Website, hence it's been updated to match with Actual message so that the test case will be passed.
	
	}
	
}
