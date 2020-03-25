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
import com.training.pom.LoginPOM;
import com.training.pom.editProfilePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC003_Simple {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private HomePOM homePOM;
	private editProfilePOM EditProfilePOM;
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
		loginPOM = new LoginPOM(driver); 
		homePOM = new HomePOM(driver);
		EditProfilePOM = new editProfilePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser || Pre-condition: User should have launched the application and should have registered as student
		driver.get(baseUrl);
		loginPOM.sendUName("Jordan1");
		loginPOM.sendPWD("Welcome@987");
		loginPOM.clickLogin();
		loginPOM.clickHomepage();
	}
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void StPwdChange() {
		//Step 1: Click on Edit profile link,
		homePOM.ClickEditProfile();
		
		//Step 2: Enter valid credentials in pass textbox,
		EditProfilePOM.sendPass("Welcome@987");
		
		//Step 3: Click on Login button,
		EditProfilePOM.sendNewPass("Welcome@1234");
		
		//Step 4: Enter valid credentials in Confirm password textbox,
		EditProfilePOM.sendConfPassword("Welcome@1234");
				
		//Step 5: Click on Save Changes,
		EditProfilePOM.clickSaveChanges();
		
		screenShot.captureScreenShot("TC03_StPwdChangeSuccess");
	}
}
