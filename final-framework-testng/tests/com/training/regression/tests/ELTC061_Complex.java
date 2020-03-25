package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.HomePOM;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC061_Complex {

	private WebDriver driver;
	private String baseURL;
	private RegisterPOM regPOM;
	private HomePOM homePOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		regPOM = new RegisterPOM(driver); 
		homePOM = new HomePOM(driver);
		baseURL = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser || Pre-condition: User should have launched the application,	
		driver.get(baseURL);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(dataProvider = "TD61_StRegistration", dataProviderClass = LoginDataProviders.class)
	public void RegisterStudent(String fName, String lName, String emailId, String uName, String pwd, String confirmPwd, String phn, String lng) throws InterruptedException {
		
	
	//Step 1: Click on Sign Up! link for Registration,
		homePOM.clickSignUp();
		
	//Step 2: Enter valid credential in First name textbox,
		regPOM.sendFirstName(fName);
		
	//Step 3: Enter valid credential in Last name textbox,
		regPOM.sendLastName(lName);
	
	//Step 4: Enter valid credential in e-mail textbox,
		regPOM.sendEmail(emailId);
		
	//Step 5: Enter valid credential in username textbox,
		regPOM.sendUserName(uName);
		
	//Step 6: Enter valid credential in pass textbox,
		regPOM.sendPassword(pwd);
		
	//Step 7: Enter valid credential in confirm password textbox,
		regPOM.sendConfirmPassword(confirmPwd);
		
	//Step 8: Enter valid credential in phone textbox,
		regPOM.sendPhone(phn);		
	
	//Step 9: Select valid option from Language list box,
		regPOM.selectLanguage(lng);
		
	//Step 10: Click Student radio button in Profile,
		regPOM.clickStudentRadio();
		
	//Step 11: Click on Register button and verify the message,
		regPOM.clickRegister();
		
		screenShot.captureScreenShot("ELTC061_DP_Excel_StRegistration");
	}
}
