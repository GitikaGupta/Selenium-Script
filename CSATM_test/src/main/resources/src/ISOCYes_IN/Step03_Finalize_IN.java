package ISOCYes_IN;

import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import lib.Excel;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Step03_Finalize_IN {
 
  
  private WebDriver driver;
  
  public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	// Define the element 
	@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
	@FindBy (xpath=".//*[@id='desktop']") private WebElement Email;
	@FindBy (xpath =".//*[@id='body']/div[1]/div[2]/div/div/form/input[4]") private WebElement password;
	@FindBy (id="btn_signin") private WebElement SignIn;
	@FindBy ( xpath = ".//*[@id='left-nav']//a[contains(text(), 'Search')]" ) private WebElement LHS_Search_tab ;
	@FindBy ( id="FLD_REQ_NUM_SEARCH" ) private WebElement Request_Num_Fld ;
	@FindBy ( name="GO" ) private WebElement Search_GO_btn ;
	@FindBy ( xpath = ".//*[@id='content-main']/form/table[3]/tbody/tr[2]/td[1]/a" ) private WebElement Request_Num_link ;

	 @FindBy ( xpath = ".//*[@id='content-main']/form/table[1]/tbody/tr[1]/td[3]/a" ) private WebElement Skill_link ;
	
	 @FindAll({@FindBy(name="tblcolCandId")}) private List<WebElement>  Select_Checkbox ;
	 @FindBy(id="NSR1") private WebElement Justification;
	 @FindBy ( name="btnAddSelFin" ) private WebElement Btn_AddSelectedToFinalists ;
	 
	 @FindBy ( name="btnSubmitSel" ) private WebElement Btn_SubmitSelected ;
	 //Hiring Approval 
	 @FindBy ( id="FLD_NON_METRO_HIRING_REQUEST_NUM" ) private WebElement Non_Metro ;
	 @FindBy (id="FLD_REASON_NOT_HAVING_METRO_NUM") private WebElement Reason ;
	 @FindBy (id="ContinueSubmit") private WebElement Continue_Submission;
	 @FindBy (name="Continue") private WebElement Continue;
	 //Submit confirmation page
	 @FindBy (id= "FLD_REQST_ORG" ) private WebElement Requesting_Organization ;
	 @FindBy (name="btnConfirmSubmit") private WebElement Confirm_Submission;
	 
	
	// Initialize the web elements 
	public Step03_Finalize_IN(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Function to login to the application
	
	public void loginAndOpenReq()
	{
		
		loginToContractor_Link.click();
		WebDriverWait wait00 = new WebDriverWait(driver, 180);
		wait00.until(ExpectedConditions.visibilityOf(SignIn));
		
		Email.sendKeys(Excel.getCellValue(xlsFilePath, "Login", 12, 0));
		password.sendKeys(Excel.getCellValue(xlsFilePath, "Login", 12, 1));
		
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\WTXRegression\\IN\\Core\\");
		
		SignIn.click();
		
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\WTXRegression\\IN\\Core\\");
		
		WebDriverWait wait01 = new WebDriverWait(driver, 180);
		wait01.until(ExpectedConditions.visibilityOf(LHS_Search_tab));
		
		LHS_Search_tab.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 160);
		wait.until(ExpectedConditions.visibilityOf(Request_Num_Fld)); 
		
		
		Request_Num_Fld.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 15));
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\WTXRegression\\IN\\Core\\");
		Search_GO_btn.click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, 160);
		wait1.until(ExpectedConditions.visibilityOf(Request_Num_link)); 
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\WTXRegression\\IN\\Core\\");
		
		Request_Num_link.click();
	}
		
		
		public void FinaliseSubmit()
		{
			
	    WebDriverWait wait2 = new WebDriverWait(driver, 160);
		wait2.until(ExpectedConditions.visibilityOf(Skill_link)); 
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\WTXRegression\\IN\\Core\\");
		Skill_link.click();
		
		 WebDriverWait wait3 = new WebDriverWait(driver, 160);
	     wait3.until(ExpectedConditions.visibilityOf(Btn_AddSelectedToFinalists)); 
	     
	        for (WebElement elt: Select_Checkbox){

				elt.click();

			} 
	        Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\WTXRegression\\IN\\Core\\");
	     Btn_AddSelectedToFinalists.click();
	     
	     /* code to capture screenshot */
	     Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\WTXRegression\\IN\\Core\\");
			
			WebDriverWait wait4 = new WebDriverWait(driver, 160);
	     wait4.until(ExpectedConditions.visibilityOf(Btn_SubmitSelected));
		
	       for (WebElement elt: Select_Checkbox)
	       {

				elt.click();

			} 
	       Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\WTXRegression\\IN\\Core\\");
		Btn_SubmitSelected.click();
		
		
		
		//Hiring Approval page
		WebDriverWait wait6 = new WebDriverWait(driver, 160);
		wait6.until(ExpectedConditions.visibilityOf(Continue_Submission));
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\WTXRegression\\IN\\Core\\");
		Non_Metro.click();
		
		Reason.sendKeys("I use Metro, but can't for this situation and have a management-approved bypass");
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\WTXRegression\\IN\\Core\\");
		Continue_Submission.click();
		 
		 //submit confirmation page
		
		 WebDriverWait wait7 = new WebDriverWait(driver, 160);
		 wait7.until(ExpectedConditions.visibilityOf(Confirm_Submission));
		 
		 Requesting_Organization.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 1));
		 Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\WTXRegression\\IN\\Core\\");
		 Confirm_Submission.click();
		 
		 
		 
		 
		 /* code to capture screenshot */
		 Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\WTXRegression\\IN\\Core\\");
			
			
		
		
		}
 
		
  
  }

