package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.HomePOM;
//import com.training.pom.LoginPOM;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC001_Simple {

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
	
	@Test
	public void RegisterStudent() throws InterruptedException {
		
	
	//Step 1: Click on Sign Up! link for Registration,
		homePOM.clickSignUp();
		
	//Step 2: Enter valid credential in First name textbox,
		regPOM.sendFirstName("JayvirK");
		
	//Step 3: Enter valid credential in Last name textbox,
		regPOM.sendLastName("Jethwa");
	
	//Step 4: Enter valid credential in e-mail textbox,
		regPOM.sendEmail("jordan@gma.com");
		
	//Step 5: Enter valid credential in username textbox,
		regPOM.sendUserName("JordanJJ318");
		
	//Step 6: Enter valid credential in pass textbox,
		regPOM.sendPassword("Welcome@123");
		
	//Step 7: Enter valid credential in confirm password textbox,
		regPOM.sendConfirmPassword("Welcome@123");
		
	//Step 8: Enter valid credential in phone textbox,
		regPOM.sendPhone("9123456780");		
	
	//Step 9: Select 'English' from Language list box,
		regPOM.selectLanguage("Eng");
		
	//Step 10: Click Student radio button in Profile
		regPOM.clickStudentRadio();
		
	//Step 11: Click on Register button and verify the message,
		regPOM.clickRegister();
		
		
		screenShot.captureScreenShot("TC01_StRegistration");
		
	}
	
	
}
