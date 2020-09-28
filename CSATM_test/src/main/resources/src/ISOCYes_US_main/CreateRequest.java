package ISOCYes_US_main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ISOCYes_US.Step01_CreateRequest;



import org.apache.log4j.Logger;

import lib.Excel;


public class CreateRequest
{
	// TestNG logger
	
		public static Logger log = Logger.getLogger("TnM");
		
		public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
		//public String sheet="Login"; 
		public String url;
		
		
		
		public WebDriver driver;
		
		
		@BeforeTest
	    public void setup()
		{
			
			//System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			
			//driver = new ChromeDriver();
			
			System.setProperty("webdriver.gecko.driver","C:\\Users\\IBM_ADMIN\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			
			driver = new FirefoxDriver();
			

            url = Excel.getCellValue(xlsFilePath, "Login", 1, 2);
			
             driver.get(url); 
         driver.manage().window().maximize();
		       
	  }	
		
		 // test to Login to the application as RIPC
			@Test(priority=0)
		  public void RIPC_Login() 
		  {
			  
			  Step01_CreateRequest login = new Step01_CreateRequest(driver);
			  login.login() ;
		  }
			@Test(priority=1)
			  public void Create_Req() 
			  {
				  
				  Step01_CreateRequest createreq = new Step01_CreateRequest(driver);
				  createreq.Create_New_Request();
			  }
			@Test(priority=2)
			  public void skill_Req() 
			  {
				  
				  Step01_CreateRequest skillreq = new Step01_CreateRequest(driver);
				  skillreq.Skill_Request();
			  }
			@Test(priority=3)
			  public void select_Req() 
			  {
				  
				  Step01_CreateRequest selectreq = new Step01_CreateRequest(driver);
				  selectreq.Select_Requestor();
			  }

			@Test(priority=4)
			  public void select_jrss() 
			  {
				  
				  Step01_CreateRequest selectreq = new Step01_CreateRequest(driver);
				  selectreq.Select_JRSS();
			  }

			@Test(priority=5)
			  public void req_detail() 
			  {
				  
				  Step01_CreateRequest reqdetail = new Step01_CreateRequest(driver);
				  reqdetail.Request_detailpage();
			  }
			@Test(priority=6)
			  public void skill_loc() 
			  {
				  
				  Step01_CreateRequest skillloc = new Step01_CreateRequest(driver);
				  skillloc.Skill_detailLocationpage();
			  }
			@Test(priority=7)
			  public void alert_check() 
			  {
				  
				  Step01_CreateRequest alertchk = new Step01_CreateRequest(driver);
				  alertchk.isAlertPresent();
			  }
			@Test(priority=8)
			  public void skill_price() 
			  {
				  
				  Step01_CreateRequest skillprice = new Step01_CreateRequest(driver);
				  skillprice.Skill_detail_skillpricepage();
			  }
			@Test(priority=9)
			  public void supp() 
			  {
				  
				  Step01_CreateRequest supplier = new Step01_CreateRequest(driver);
				  supplier.SupplierSelectionPage();
			  }
			@Test(priority=10)
			  public void req_data() 
			  {
				  
				  Step01_CreateRequest reqdata = new Step01_CreateRequest(driver);
				  reqdata.Reqdata();
			  }
			  
			  
			  
		
		  }
	    		

