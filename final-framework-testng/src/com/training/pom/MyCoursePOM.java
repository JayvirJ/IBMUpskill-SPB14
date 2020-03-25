package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyCoursePOM {

private WebDriver driver; 
	
	public MyCoursePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	//To locate and click on "Create a Course" link and to add a new course,
	@FindBy(xpath="//a[contains(text(),'Create a course')]")			
	private WebElement CreateCourse;
	
	public void clickCreateCourse() {
		this.CreateCourse.click();
	}
	
	
	//To locate and type in Course name textbox,
	@FindBy(id="title")
	private WebElement courseTitle;
	
	public void sendCourseTitle(String title) {
		this.courseTitle.clear();
		this.courseTitle.sendKeys(title);
	}
	
	
	//To locate and click on Advance settings 
	@FindBy(id="advanced_params")			
	private WebElement AdvSettings;
	
	public void clickAdvancedSettings() {
		this.AdvSettings.click();
	}
	
	
	//To select value from category list box,
	@FindBy(xpath="(//span[@class='caret'])[2]")
	private WebElement categoryList;
	@FindBy(xpath="//form[@id='add_course']/fieldset/div[3]/div[1]/div[1]/div/div/div[1]/input")
	private WebElement typeCategory;
	@FindBy(xpath="//form[@id='add_course']/fieldset/div[3]/div[1]/div[1]/div/div/div[2]/ul/li/a")
	private WebElement SelectCategory;
	
	public void selectCategory(String ctgr) {			
		this.categoryList.click();
		this.typeCategory.sendKeys(ctgr);
		this.SelectCategory.click();
	}
	
	//To locate and enter valid credential in Course code textbox,
	@FindBy(name="wanted_code")
	private WebElement courseCode;
	
	public void sendCourseCode(String code) {
		this.courseCode.clear();
		this.courseCode.sendKeys(code);
	}
	
	
	//To select value from language list box,
		@FindBy(xpath="(//span[@class='caret'])[3]")
		private WebElement languageList;
		@FindBy(xpath="//form[@id='add_course']/fieldset/div[3]/div[3]/div[1]/div/div/div[1]/input")
		private WebElement typeLanguage;
		@FindBy(xpath="//form[@id='add_course']/fieldset/div[3]/div[3]/div[1]/div/div/div[2]/ul/li/a")
		private WebElement SelectLanguage;
		
		public void selectLanguage(String lang) {			
			this.languageList.click();
			this.typeLanguage.sendKeys(lang);
			this.SelectLanguage.click();
		}
		
	//To locate and click on Create this course button,
		@FindBy(name="submit")			
		private WebElement createCourseBtn;
		
		public void clickCreateCourseBtn() {
			this.createCourseBtn.click();
		}
		
	//To locate and click on Add an introduction icon,
		@FindBy(xpath="//section[@id='main_content']/div/div[1]/div/div[1]/a/em")			
		private WebElement AddIntro;
		
		public void clickAddIntroIcon() throws InterruptedException {
			this.AddIntro.click();
			Thread.sleep(2000);
		}
		
	//To locate and enter valid credentials in Introduction textbox,
		@FindBy(xpath="//iframe[@title='Rich Text Editor, intro_content']")
		private WebElement IntroTextBox;
		@FindBy(xpath="//html[contains(text(),'')]")				//iframe[@title='Rich Text Editor, intro_content']/html  //iframe[@title='Rich Text Editor, intro_content']/html/body									
		private WebElement EnterIntro;
		//@FindBy(css=".cke_editable")
		//private WebElement typeIntro;
		
		public void sendIntro(String intro) throws InterruptedException {
			Thread.sleep(2000);
			driver.switchTo().frame(this.IntroTextBox);    									//Switching to iFrame to add Introduction 
			this.EnterIntro.click();
			this.EnterIntro.sendKeys(intro);												//locate and type introduction in textbox
			driver.switchTo().defaultContent();									
		}
		
	//To locate and click on Save intro text button	
		@FindBy(id="introduction_text_intro_cmdUpdate")
		private WebElement saveIntroBtn;
		@FindBy(xpath="//section[@id='cm-content']/div/div[3]/div/div")
		private WebElement IntroMsg;
		
		public void clickSaveIntroBtn() {
			this.saveIntroBtn.click();
			
			String IntroMsg = this.IntroMsg.getText();
			System.out.println(IntroMsg);
			Assert.assertEquals(IntroMsg, "Intro was updated");
		}
		
}
