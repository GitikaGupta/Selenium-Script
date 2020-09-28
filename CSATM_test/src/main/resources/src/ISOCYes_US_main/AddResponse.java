package ISOCYes_US_main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ISOCYes_US.Step02_AddResponse;


import org.apache.log4j.Logger;

import lib.Excel;


public class AddResponse
{
	// TestNG logger
	
		public static Logger log = Logger.getLogger("TnM");
		
		public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
		public String sheet="Login"; 
		public String url;
		public String id;
		public String paswd;
		public String id_green;
		public String paswd_green;
		public String url_green;
		public String url2;
		
		public WebDriver driver;
		
		
		@BeforeTest
	    public void setup()
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\IBM_ADMIN\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			System.out.println("output 1");
			driver = new FirefoxDriver();
		url = "https://"+ Excel.getCellValue(xlsFilePath, sheet, 2, 2);
		driver.get(url);    
	  }	
				  // Test to add response
	   @Test(priority=0)
		  public void green_login()
		  {
		       log.debug("Inside open_CSA_Tab() function");
			  
			  Step02_AddResponse logn = new Step02_AddResponse(driver); 
			  
			  
				 logn.login();
		  }
	  
	   @Test(priority=1)
		  public void add_response()
		  {
		       log.debug("Inside open_CSA_Tab() function");
			  
			  Step02_AddResponse addresp = new Step02_AddResponse(driver); 
			 
			  addresp.FillRespdetails("fResp1" , "US" , "lResp1", "30");
		  } 
	   @Test(priority=2) 
	   public void sbmt()
	   {
	   Step02_AddResponse sbmit = new Step02_AddResponse(driver);
	     sbmit.Submit();
				  
			  
			  }
		  }

		
		  
		

