package ISOCYes_US_main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import ISOCYes_US.Step03_Finalize;

import org.apache.log4j.Logger;

import lib.Excel;


public class FinalizeResponse
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
    	url = Excel.getCellValue(xlsFilePath, sheet, 1, 2);             
        driver.get(url);    
	  }	
		
		
        //Test for Skill Request page
		  @Test(priority=0)
		  public void login()
		  {
			 
			  Step03_Finalize log = new Step03_Finalize(driver);
			  log.loginAndOpenReq();
			  
			  
				  
		  }
		  @Test(priority=1)
		  public void Finalize()
		  {
			 
			  Step03_Finalize respfinal = new Step03_Finalize(driver);
			  
			  respfinal.FinaliseSubmit();
			  
				  
		  }
		
}
