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
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC002_Simple {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
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
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser || Pre-condition: User should have launched the application
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void validStudentLogin() {
		//Step 1: Enter valid credentials in Username textbox,
		loginPOM.sendUName("Jjethwa");
		
		//Step 2: Enter valid credential in pass text box,
		loginPOM.sendPWD("Welcome@123");
		
		//Step 3: Click on Login button,
		loginPOM.clickLogin(); 
		
		String Msg = driver.findElement(By.xpath("//article[@id='homepage-course']/div/p[1]")).getText();
		Assert.assertEquals(Msg, "Hello Jayvir Jethwa and welcome,");
		
		screenShot.captureScreenShot("TC02_StLogin");
	}

}
