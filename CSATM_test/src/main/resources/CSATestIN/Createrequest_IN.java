package ISOCYes_IN;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import ScreenShot.Screenshot_A;
import lib.Excel;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Step01_CreateRequest_IN {
 
  
  private WebDriver driver;
	
	// Define the element 
	@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
	@FindBy (xpath = ".//*[@id='content-main']/form[1]/div/span/input") private WebElement Create_New_Request;
	@FindBy (xpath=".//*[@id='desktop']") private WebElement Email;
	@FindBy (xpath =".//*[@id='body']/div[1]/div[2]/div/div/form/input[4]") private WebElement password;
	@FindBy (id="btn_signin") private WebElement SignIn;
	@FindBy ( xpath = ".//*[@name='btnAddContingentMgr']")  private WebElement Project_Task_Manager_AddButton ;
	@FindBy ( xpath = ".//*[@name='FLD_EMP_WEB_ID']")  private WebElement Email_Id_TextBox ;
	@FindBy ( xpath = ".//*[@name='BTN_GO']")  private WebElement GoButton ;
	@FindBy (xpath = ".//*[@id='content-main']/table[3]/tbody/tr[2]/td[1]/a" ) private WebElement Name ;
	@FindBy ( xpath = ".//input[@name='TEMP TIME APPROVER BUTTON']")  private WebElement UseAsTimeApprover_Button ;
	@FindBy ( xpath = ".//input[@name='TEMP MANAGER FOR CR BUTTON' and @value='Use as Manager']")  private WebElement UseAsManager_Button ;
	
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
	    @FindBy ( xpath = " .//*[@value='I'] " ) private WebElement Accounting_Type_I ;
	    @FindBy ( xpath = " .//*[@value='Y'] " ) private WebElement ISOC_yes ;
	    @FindBy (id="FLD_CMR_NUM") private WebElement Custnum;
	    @FindBy (id="FLD_PRODUCT_SELECTION") private WebElement Dropdown;
	    @FindBy (id="FLD_CONTACT_NAME") private WebElement Cust_name;
	    //Skill detail Location
	    @FindBy ( xpath=".//*[@id='FLD_WRK_LOC_STATE']" ) private WebElement State_Region_Province;
	    @FindBy ( id="FLD_WRK_LOC_CITY" ) private WebElement City ;
	    @FindBy ( id="FLD_WRK_LOC" ) private WebElement Work_Location ;
	    @FindBy ( name="Continue" ) private WebElement Continue_2 ;
	    @FindBy (id="FLD_ALT_WORK_LOC" ) private WebElement Alternate_Workloc ;
	    
	  //Skill detail skill price
	    @FindBy ( id="FLD_RQSTD_SKILL_LVL" ) private WebElement Skill_Level;
	    @FindBy (id="FLD_RQSTD_PRICE_LVL" )  private WebElement Price_Level;
	    @FindBy (id="FLD_QTY_SKILL_NEEDED" ) private WebElement Quantity ;
	    @FindBy (xpath =".//*[@id='FLD_ST']") private WebElement ST_time;
	    
	    //Skill Summary Page
	    @FindBy (xpath = ".//*[@value='Continue to request summary'] ") private WebElement ContinueToRequestSummary;
	
	 //Review Skill request
	    @FindBy (name = "Submit request") private WebElement SubmitRequest;
	    
	    //Request Created
	    @FindBy ( xpath= ".//*[@id='content-main']/table[1]/tbody/tr/td[1]/h1 ") private WebElement RequestCreated;
	
	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	 
	// Initialize the web elements 
	public Step01_CreateRequest_IN(WebDriver driver)
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
		
		Email.sendKeys(Excel.getCellValue(xlsFilePath, "Login", 12, 0));
		password.sendKeys(Excel.getCellValue(xlsFilePath, "Login", 12, 1));
		
		//Take ScreenShot
	//	Screenshot_A S1 = new Screenshot_A();
		//S1.snap_IN();
		
		SignIn.click();
  
  }
	
	//Create Request
	public void Create_New_Request()
    {
    	WebDriverWait wait01 = new WebDriverWait(driver, 180);
		wait01.until(ExpectedConditions.visibilityOf(Create_New_Request));
		
		//Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\IN\\Core\\");
    	Create_New_Request.click();
    	
    }
	//Skill Request Page
	public void Skill_Request(){
	
		WebDriverWait wait02 = new WebDriverWait(driver, 180);
		wait02.until(ExpectedConditions.visibilityOf(New_Request));
		
		New_Request.click();
		Time_Materials.click();
		//Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\IN\\Core\\");
		Continue.click();
		
	}
	
	//Select Requestor Page
	public void Select_Requestor(){
		
		
		 /* code to capture screenshot */
	//	Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\IN\\Core\\");
		Continue.click();		
	}
	
	//JRSS
	public void Select_JRSS()
    
    {
	 
		WebDriverWait wait02 = new WebDriverWait(driver, 180);
		wait02.until(ExpectedConditions.visibilityOf(Priced_JRSS));
	 String JR = Excel.getCellValue(xlsFilePath, "Request_creation", 3, 2);
	 String SS = Excel.getCellValue(xlsFilePath, "Request_creation", 3, 3);  
   
	 //Priced_JRSS.click();	
	
    Select JRlistbox = new Select(Select_JobRole);
	JRlistbox.selectByVisibleText(JR);
	
	Select SSlistbox = new Select(Select_SkillSet);
	SSlistbox.selectByVisibleText(SS);
	
	 /* code to capture screenshot */
	//Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\IN\\Core\\");
		
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	
	 Continue.click();
	 
    }
	
	//request details
	public void Request_detailpage()
    
    {
		WebDriverWait wait03 = new WebDriverWait(driver, 180);
		wait03.until(ExpectedConditions.visibilityOf(Project_Name));
	Project_Name.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 4));
	Cust_name.sendKeys("test_ISOC_IN");
	GlobalResource_No.click();
	Govt_FederalContract.click();
	
	Project_Task_Manager_AddButton.click();
	String MainWindow=driver.getWindowHandle();

	Set<String> s1=driver.getWindowHandles();     

	Iterator<String> i1=s1.iterator();        

	while(i1.hasNext())         

	{       

	String ChildWindow=i1.next();       

	if(!MainWindow.equalsIgnoreCase(ChildWindow))           

	{           

	System.out.println("Window handler Id of Parent window= "+MainWindow);

	System.out.println("Window handler Id of Child window= "+ChildWindow);

	//Switching to Child window

	driver.switchTo().window(ChildWindow);  

	WebDriverWait wait8 = new WebDriverWait(driver, 160);

	wait8.until(ExpectedConditions.visibilityOf(Email_Id_TextBox));               

	Email_Id_TextBox.sendKeys("csatestin1@c25a0161.toronto.ca.ibm.com");                                                                     

	GoButton.click();

	WebDriverWait wait07 = new WebDriverWait(driver, 180);

	wait07.until(ExpectedConditions.visibilityOf(Name));

	Name.click();

	WebDriverWait wait08 = new WebDriverWait(driver, 180);

	wait08.until(ExpectedConditions.visibilityOf(UseAsManager_Button));
     System.out.println("test1");
	/* code to capture screenshot */

	//Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\GogulaKousalya\\Downloads\\All Jars for Selenium (1)\\Reg_PF_IN");

	UseAsManager_Button.click();
System.out.println("test2");
	}       

	}

	//Switching to Parent window i.e Main Window.

	driver.switchTo().window(MainWindow);
	Client.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 5));
	Brand.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 6));
	Sector.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 7));
	Industry.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 8));
	
	Accounting_Type_I.click();
	//ISOC_yes.click();
	//Custnum.sendKeys("123456");
	//Dropdown.sendKeys("GMC");
	
	//Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\IN\\Core\\");
	
	Continue.click();
	}
	
	//skill detail Page
	public void Skill_detailLocationpage()
	{
	WebDriverWait wait04 = new WebDriverWait(driver, 180);
	wait04.until(ExpectedConditions.visibilityOf(State_Region_Province));
    
	 
	 Select st = new Select(State_Region_Province);
		st.selectByVisibleText("Karnataka");
		
   try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
   
   Select ct = new Select(City);
	ct.selectByVisibleText("BANGALORE");
	
	
   try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
 //  Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\IN\\Core\\");
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
		Select sl = new Select(Skill_Level);
		sl.selectByVisibleText("Band 6G");
		
   // Skill_Level.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 12));
    //Price_Level.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 13));
    Quantity.clear();
    driver.switchTo().alert().accept();
    Quantity.sendKeys("2");
    ST_time.clear();
    driver.switchTo().alert().accept();
    ST_time.sendKeys("12");
   // ST_time.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"12");
   // Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\IN\\Core\\");
    Continue_2.click();
	
}
	//Supplier Selection Page
	public void SupplierSelectionPage()
	{
		WebDriverWait wait4 = new WebDriverWait(driver, 160);
		wait4.until(ExpectedConditions.visibilityOf(Continue));
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\IN\\Core\\");
		Continue.click();
			
		//Summary Page
		WebDriverWait wait6 = new WebDriverWait(driver, 160);
		wait6.until(ExpectedConditions.visibilityOf(ContinueToRequestSummary));
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\IN\\Core\\");
		ContinueToRequestSummary.click();
		
		 /* code to capture screenshot */
	//	Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\IN\\Core\\");
			
			try 
			{
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		
		WebDriverWait wait7 = new WebDriverWait(driver, 160);
		wait7.until(ExpectedConditions.visibilityOf(SubmitRequest));
	//	Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\IN\\Core\\");
		SubmitRequest.click();
		
	
	}

	//String Number = RequestCreated.getText().substring(33, 39);
	//Excel.setCellValue(xlsFilePath, "Request_creation", 3, 15, Number );
	 //   public void Reqdata()
	    
	   
	
		 /* code to capture screenshot */
	  //  	Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\IN\\Core\\");
		
				
	  
}



	
