package ISOCYes_US;

import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import lib.Excel;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Step06_PO_Auth {
 
  
  private WebDriver driver;
	
	// Define the element 
	@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
	@FindBy (xpath=".//*[@id='desktop']") private WebElement Email;
	@FindBy (xpath =".//*[@id='body']/div[1]/div[2]/div/div/form/input[4]") private WebElement password;
	@FindBy (id="btn_signin") private WebElement SignIn;
	@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Awaiting project office action')]") private WebElement Awaiting_PO_Auth_link ;
	@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Candidates')]") private WebElement Candidates ;
	@FindBy (id="FLD_REQUEST_NUMBER") private WebElement Req_Num_Search ;
	@FindBy (name="btnGo") private WebElement GO_reqnum ;
	@FindBy (xpath =" .//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[3]/a " ) private WebElement Request_Number ;
	@FindBy (xpath = ".//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[4]/a" ) private WebElement Project_Name ;
	@FindBy (xpath = ".//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[5]/a" ) private WebElement Skill_link ;
	@FindBy(name="FLD_MULTI_LINE_ITEMS") private WebElement  Select_Checkbox ;
	@FindBy (name="btnSubmitSelCand") private WebElement Submit_Selected_Responses ;
	 @FindBy (id= "FLD_REQST_ORG" ) private WebElement Requesting_Organization ;
	@FindBy (name="btnConfirmSubmit") private WebElement Confirm_submission ;
	@FindBy ( xpath=".//input[@id='finalConfirmation']" ) private WebElement OK_button ;
	@FindBy(xpath = ".//a[text()='Return to request header']") private WebElement  returnToRequest ;
	
	
	
	
	
	// Initialize the web elements 
	public Step06_PO_Auth(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Function to login to the application
	// Click on the link again as workaround 
	public void login(){
		
		loginToContractor_Link.click();
		WebDriverWait wait00 = new WebDriverWait(driver, 180);
		wait00.until(ExpectedConditions.visibilityOf(SignIn));
		
		Email.sendKeys(Excel.getCellValue(xlsFilePath, "Login", 4, 0));
		password.sendKeys(Excel.getCellValue(xlsFilePath, "Login", 4, 1));
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\US\\Core\\");
		SignIn.click();
  
		
  }
	
	
	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	
		
		//Function to click Create New Request button
        public void authorize_PO ()
        {
        	
        	WebDriverWait wait01 = new WebDriverWait(driver, 180);
			wait01.until(ExpectedConditions.visibilityOf(Awaiting_PO_Auth_link));
			
		    Awaiting_PO_Auth_link.click();
		    
		    WebDriverWait wait21 = new WebDriverWait(driver, 180);
			wait21.until(ExpectedConditions.visibilityOf(Candidates));
			
    		Candidates.click();
    		
    		Req_Num_Search.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 15));
    		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\US\\Core\\");
    		GO_reqnum.click();

    		WebDriverWait wait02 = new WebDriverWait(driver, 180);
			wait02.until(ExpectedConditions.visibilityOf(Project_Name));
			Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\US\\Core\\");
    		
    	Project_Name.click();
    	
    	WebDriverWait wait03 = new WebDriverWait(driver, 180);
		wait03.until(ExpectedConditions.visibilityOf(Submit_Selected_Responses));
    	
		Select_Checkbox.click();
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\US\\Core\\");
    	Submit_Selected_Responses.click();
    	
    	 /* code to capture screenshot */
    	Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\US\\Core\\");
    	WebDriverWait wait04 = new WebDriverWait(driver, 180);
		wait04.until(ExpectedConditions.visibilityOf(Confirm_submission));
		
		 Requesting_Organization.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 1));
    	Confirm_submission.click();
    	
    	driver.switchTo().alert().accept();
    	
    	WebDriverWait wait10 = new WebDriverWait(driver, 160);
    	wait10.until(ExpectedConditions.visibilityOf( OK_button));

    	/* code to capture screenshot */
    	Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\US\\Core\\");

    	OK_button.click();
    	
    	WebDriverWait wait11 = new WebDriverWait(driver, 160);
    	wait11.until(ExpectedConditions.visibilityOf( returnToRequest));
    	 /* code to capture screenshot */
    	Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\US\\Core\\");
    	
        	
        }
	
}
