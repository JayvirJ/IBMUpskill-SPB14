package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.MyCoursePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC031_Medium {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private MyCoursePOM myCoursePOM;
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
		myCoursePOM = new MyCoursePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser || Pre-condition: User should have launched the application and should get logged in as Teacher,
		driver.get(baseUrl);
		loginPOM.sendUName("JordanJJ316");
		loginPOM.sendPWD("Welcome@123");
		loginPOM.clickLogin();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	
	@Test
	public void CreateCourse() throws InterruptedException {
		
		//Step 1: Click on Create a Course link,
		myCoursePOM.clickCreateCourse();
		
		//Step 2: Enter valid credentials in in Course name textbox,
		myCoursePOM.sendCourseTitle("AutomationAPI19");
		
		//Step 3: Click on Advanced Settings button,
		myCoursePOM.clickAdvancedSettings();
		
		//Step 4: Select Valid credentials from Category list box,
		myCoursePOM.selectCategory("Projects");
		
		//Step 5: Enter valid credential in Course code textbox,
		myCoursePOM.sendCourseCode("API19");
		
		//Step 6: Select Valid credentials from Language list box,
		myCoursePOM.selectLanguage("English");
		
		//Step 7: Click on Create this course button,
		myCoursePOM.clickCreateCourseBtn();;
		
		//Step 8: click on Add an introduction icon,
		myCoursePOM.clickAddIntroIcon();
		
		//Step 9: Enter valid credentials in textbox,
		myCoursePOM.sendIntro("this is an API course");
		
		//Step 10: Click on Save intro text,
		//myCoursePOM.clickSaveIntroBtn();
		
		
		screenShot.captureScreenShot("ELTC031_CreateCourse");
	}

}
