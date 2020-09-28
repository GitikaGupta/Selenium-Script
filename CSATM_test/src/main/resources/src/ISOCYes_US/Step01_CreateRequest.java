package ISOCYes_US;

import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import lib.Excel;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Step01_CreateRequest {
 
  
  private WebDriver driver;
	
	// Define the element 
	@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
	@FindBy (xpath=".//*[@id='desktop']") private WebElement Email;
	@FindBy (xpath =".//*[@id='body']/div[1]/div[2]/div/div/form/input[4]") private WebElement password;
	@FindBy (id="btn_signin") private WebElement SignIn;
	@FindBy (xpath = ".//*[@id='content-main']/form[1]/div/span/input") private WebElement Create_New_Request;
	
	
	//Skill Request Page	
	@FindBy (id ="FLD_REQ_TYPE") private WebElement New_Request ;
	@FindBy ( id="FLD_NORMAL_TYPE1") private WebElement Time_Materials ;
	@FindBy (name = "btnContinue") private WebElement Continue ;
	
	//Select Requestor
	@FindBy  (id = "FLD_REQST_CO") private WebElement  Requesting_Company ;
	@FindBy (id= "FLD_REQST_ORG" ) private WebElement Requesting_Organization ;
	
	// Job Role/Skill
	  @FindBy ( xpath= ".//*[@id='JRSS_SELECTION1']") private WebElement Priced_JRSS;
	    @FindBy ( id = "FLD_JOB_ROLE" ) private WebElement Select_JobRole ;
	    @FindBy ( id = "FLD_SKILL_SET") private WebElement Select_SkillSet;
	
	    //Project Manager field
	    @FindBy ( xpath = ".//*[@name='FLD_EMP_WEB_ID']")  private WebElement Email_Id_TextBox ;
		@FindBy ( xpath = ".//*[@name='BTN_GO']")  private WebElement GoButton ;
		@FindBy (xpath = ".//*[@id='content-main']/table[3]/tbody/tr[2]/td[1]/a" ) private WebElement Name ;
		@FindBy ( xpath = ".//input[@name='TEMP TIME APPROVER BUTTON']")  private WebElement UseAsTimeApprover_Button ;
		@FindBy ( xpath = ".//input[@name='TEMP MANAGER FOR CR BUTTON']")  private WebElement UseAsManager_Button ;
		@FindBy (xpath = ".//*[@id='btnAddContingentMgr']") private WebElement Add_Button;
		
	//Project Creation
	    @FindBy ( id="FLD_PROJ_NAME") private WebElement Project_Name;
	    @FindBy (id="FLD_IS_GLOBAL_RESOURCE0") private WebElement GlobalResource_No ;
	    @FindBy ( id="FLD_CONTACT_NAME") private WebElement CustomerName_Refernce ;
	    @FindBy ( xpath = ".//*[@id='FLD_IS_FED_CONTRACT']")  private WebElement Govt_FederalContract ;
	    @FindBy ( id="FLD_CLIENT") private WebElement Client ;
	    @FindBy ( id="FLD_BRAND") private WebElement Brand ;
	    @FindBy ( id="FLD_SECTOR") private WebElement Sector ;
	    @FindBy ( id="FLD_INDUSTRY") private WebElement Industry ;
	    @FindBy ( id="fldRegulatedAcc1") private WebElement FDA ;
	    @FindBy ( id="fldRegulatedAcc2") private WebElement FFIEC ;
	    @FindBy ( id="fldRegulatedAcc4") private WebElement NREG ;
	    @FindBy ( xpath = " .//*[@value='S'] " ) private WebElement Accounting_Type ;
	    @FindBy ( xpath = " .//*[@value='Y'] " ) private WebElement ISOC_yes ;
	    @FindBy (id="FLD_CMR_NUM") private WebElement Custnum;
	    @FindBy (id="FLD_PRODUCT_SELECTION") private WebElement Dropdown;
	    //Skill detail Location
	    @FindBy ( id="FLD_WRK_LOC_STATE" ) private WebElement State_Region_Province;
	    @FindBy ( id="FLD_WRK_LOC_CITY" ) private WebElement City ;
	    @FindBy ( id="FLD_WRK_LOC" ) private WebElement Work_Location ;
	    @FindBy ( name="Continue" ) private WebElement Continue_2 ;
	    @FindBy (id="FLD_ALT_WORK_LOC" ) private WebElement Alternate_Workloc ;
	    
	  //Skill detail skill price
	    @FindBy ( id="FLD_RQSTD_SKILL_LVL" ) private WebElement Skill_Level;
	    @FindBy (id="FLD_RQSTD_PRICE_LVL" )  private WebElement Price_Level;
	    @FindBy (id="FLD_QTY_SKILL_NEEDED" ) private WebElement Quantity ;
	    @FindBy (id="FLD_CONTACT_NAME") private WebElement Cust_name;
	    
	    //supplier page
	    @FindBy ( xpath= "//input[@name='fldSelectSuppForReq' and @value='2']") private WebElement secondary_supp;
	    @FindBy ( xpath= "//a[contains(text(), 'Deselect all')]") private WebElement Deselect_All;
	    @FindBy ( xpath= "//*[contains(text(), 'WOI US TEST VENDER 1-A')]//preceding-sibling::input[@name='fldSuppliers']") private WebElement RadioButton_UStestVendor;
	    @FindBy ( xpath= "//*[contains(text(), 'UNLIMITED SYSTEMS CORP INC')]//preceding-sibling::input[@name='fldSuppliers']") private WebElement RadioButton_Unlimited_Systems;
	    @FindBy ( xpath= "//textarea[@id='FLD_SUPPWARN_SUPPSELJUST']") private WebElement SuppSelectionJustification;
	    @FindBy ( id="FLD_SUPPWARN_SUPPSELJUST") private WebElement Supp_JustificationText ;
	    
	    //Skill Summary Page
	    @FindBy (xpath = ".//*[@value='Continue to request summary'] ") private WebElement ContinueToRequestSummary;
	
	 //Review Skill request
	    @FindBy (name = "Submit request") private WebElement SubmitRequest;
	    
	    //Request Created
	    @FindBy ( xpath= ".//*[@id='content-main']/table[1]/tbody/tr/td[1]/h1 ") private WebElement RequestCreated;
	
	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	 
	// Initialize the web elements 
	public Step01_CreateRequest(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Function to login to the application
	// Click on the link again as workaround 
	public void login()
	{
		
		loginToContractor_Link.click();
		//loginToContractor_Link.click();
		
		//explicit wait
		WebDriverWait wait00 = new WebDriverWait(driver, 180);
		wait00.until(ExpectedConditions.visibilityOf(SignIn));
		
		
		Email.sendKeys(Excel.getCellValue(xlsFilePath, "Login", 1, 0));
		password.sendKeys(Excel.getCellValue(xlsFilePath, "Login", 1, 1));
		
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\US\\Core\\");
				 SignIn.click();
	} 
	//	
				
  
  
	//Create Request
	public void Create_New_Request()
    {
    	WebDriverWait wait01 = new WebDriverWait(driver, 180);
		wait01.until(ExpectedConditions.visibilityOf(Create_New_Request));
		
		 Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\US\\Core\\");
    	Create_New_Request.click();
    	
    }
	//Skill Request Page
	public void Skill_Request(){
	
		WebDriverWait wait02 = new WebDriverWait(driver, 180);
		wait02.until(ExpectedConditions.visibilityOf(New_Request));
		
		New_Request.click();
		Time_Materials.click();
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\US\\Core\\");
		Continue.click();
		
	}
	
	//Select Requestor Page
	public void Select_Requestor(){
		
		Requesting_Company.sendKeys(Excel.getCellValue(xlsFilePath,"Request_Creation",1,0));
		 
		String RO = Excel.getCellValue(xlsFilePath, "Request_creation", 1, 1);
		System.out.println(RO);
		Select ROlistbox = new Select(Requesting_Organization);
		ROlistbox.selectByVisibleText(RO);
	//	Requesting_Organization.sendKeys(Excel.getCellValue(xlsFilePath,"Request_Creation" , 1, 1));
		
		 /* code to capture screenshot */
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)  ;

		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\US\\Core\\");
		Continue.click();		
	}
	
	//JRSS
	public void Select_JRSS()
    
    {
	 
	 String JR = Excel.getCellValue(xlsFilePath, "Request_creation", 1, 2);
	 String SS = Excel.getCellValue(xlsFilePath, "Request_creation", 1, 3);  
   
	// Priced_JRSS.click();	
	
    Select JRlistbox = new Select(Select_JobRole);
	JRlistbox.selectByVisibleText(JR);
	
	Select SSlistbox = new Select(Select_SkillSet);
	SSlistbox.selectByVisibleText(SS);
	 /* code to capture screenshot */
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)  ;

	Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\US\\Core\\");	 
	Continue.click();
	 
    }
	
	//request details
	public void Request_detailpage()
    
    {
	 
	Project_Name.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 4));
	Cust_name.sendKeys("test_ISOC_IS");
	GlobalResource_No.click();
	Govt_FederalContract.click();
	
	//adding Project_Task_Manager Id.
	Add_Button.click();
	// To handle all new opened window.
	
	String MainWindow=driver.getWindowHandle();

	Set<String> s1=driver.getWindowHandles();		
	Iterator<String> i1=s1.iterator();		

	while(i1.hasNext())			
	{		
		String ChildWindow=i1.next();		

		if(!MainWindow.equalsIgnoreCase(ChildWindow))			
		{    		

			// Switching to Child window
			driver.switchTo().window(ChildWindow);	

			WebDriverWait wait8 = new WebDriverWait(driver, 160);
			wait8.until(ExpectedConditions.visibilityOf(Email_Id_TextBox));               

			Email_Id_TextBox.sendKeys("csatestus1@c25a0161.toronto.ca.ibm.com");                                                                     
			GoButton.click();
			WebDriverWait wait07 = new WebDriverWait(driver, 180);
			wait07.until(ExpectedConditions.visibilityOf(Name));
			Name.click();
			WebDriverWait wait08 = new WebDriverWait(driver, 180);
			wait08.until(ExpectedConditions.visibilityOf(UseAsManager_Button));

			/* code to capture screenshot */
			Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\US\\Core\\");

			UseAsManager_Button.click();

		}		
	}		
	//Switching to Parent window i.e Main Window.
	driver.switchTo().window(MainWindow);
	
	
	Client.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 5));
	Brand.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 6));
	Sector.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 7));
	Industry.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 8));
	FDA.click();
	FFIEC.click();
	NREG.click();
	Accounting_Type.click();
	ISOC_yes.click();
	Custnum.sendKeys("0013715");
	Dropdown.sendKeys("Lenovo");
	Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\US\\Core\\");
	Continue.click();
	}
	
	//skill detail Page
	public void Skill_detailLocationpage()
    
    {
	 
	 Select st = new Select(State_Region_Province);
		st.selectByVisibleText("Vermont");
		
 
   
   Select ct = new Select(City);
	ct.selectByVisibleText("ESSEX JUNCTION");
	
	
  
   Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\US\\Core\\");
   Continue_2.click();
    }
   public boolean isAlertPresent() 
   { 
       try 
       { 
    	   driver.switchTo().alert().accept();
           return true;
       
           
       }   // try 
       catch (NoAlertPresentException Ex) 
       { 
           return false; 
       }   // catch 
   //driver.switchTo().alert().accept();
}
    
	//Skill detail skill price
	public void Skill_detail_skillpricepage()
    
    {

	    WebDriverWait wait3 = new WebDriverWait(driver, 160);
		wait3.until(ExpectedConditions.visibilityOf(Skill_Level));
		
    Skill_Level.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 12));
    Price_Level.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 13));
    Quantity.clear();
    driver.switchTo().alert().accept();
    Quantity.sendKeys("2");
    
   
    try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
    Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\US\\Core\\");
    Continue_2.click();
	
}
	//Supplier Selection Page
	public void SupplierSelectionPage()
	{
		WebDriverWait wait4 = new WebDriverWait(driver, 160);
		wait4.until(ExpectedConditions.visibilityOf(secondary_supp));
		
		secondary_supp.click();
		Deselect_All.click();
		RadioButton_UStestVendor.click();
		
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\US\\Core\\");
		Continue.click();
		
		//Skill detail Skill request
		WebDriverWait wait5 = new WebDriverWait(driver, 160);
		wait5.until(ExpectedConditions.visibilityOf(Continue));
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\US\\Core\\");
		Continue.click();
		
		//justification page
		WebDriverWait wait51 = new WebDriverWait(driver, 160);
		wait51.until(ExpectedConditions.visibilityOf(Supp_JustificationText)); 

		Supp_JustificationText.sendKeys("Test");

		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\US\\Core\\");

		Continue.click(); 
		
		//Summary Page
		WebDriverWait wait6 = new WebDriverWait(driver, 160);
		wait6.until(ExpectedConditions.visibilityOf(ContinueToRequestSummary));
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\US\\Core\\");
		ContinueToRequestSummary.click();
		
		 /* code to capture screenshot */
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)  ;

		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\US\\Core\\");
		WebDriverWait wait7 = new WebDriverWait(driver, 160);
		wait7.until(ExpectedConditions.visibilityOf(SubmitRequest));
		
		SubmitRequest.click();
		
		String Number = RequestCreated.getText().substring(33, 39);
		Excel.setCellValue(xlsFilePath, "Request_creation", 1, 15, Number );
	}

	
	    public String Reqdata()
	    
	    {
		 
	    	Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\US\\Core\\");
		
		
		return RequestCreated.getText();
		
	   }
}



	
