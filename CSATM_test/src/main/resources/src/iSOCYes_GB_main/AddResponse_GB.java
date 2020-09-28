package iSOCYes_GB_main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ISOCYes_GB.Step02_AddResponse_GB;
import ISOCYes_US.Step02_AddResponse;

import org.apache.log4j.Logger;

import lib.Excel;


public class AddResponse_GB
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
			//System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	    	//driver = new ChromeDriver();
			System.out.println("output 1");
			driver = new FirefoxDriver();
		url = "https://"+ Excel.getCellValue(xlsFilePath, sheet, 8, 2);
		driver.get(url);
	   	  }	
		
		 

		  // Test to add response
	   @Test(priority=0)
		  public void add_response()
		  {
		       log.debug("Inside open_CSA_Tab() function");
			  
			  Step02_AddResponse_GB addresp = new Step02_AddResponse_GB(driver); 
			  
			 	 addresp.login();
		  }
	   @Test(priority=1)
	   public void add_response1()
	   {
		  
		   Step02_AddResponse_GB addresp1 = new Step02_AddResponse_GB(driver);
				  addresp1.FillRespdetails("fResp1" , "UK" , "lRes1", "200");
				  
				 
				  //addresp.Submit();
				  
			  }
		   @Test(priority=2) 
		   public void sbmt()
		   {
		   Step02_AddResponse sbmit = new Step02_AddResponse(driver);
		     sbmit.Submit();
		   }
		  }

		
		  
		

