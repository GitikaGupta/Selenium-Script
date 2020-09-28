package iSOCYes_GB_main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ISOCYes_GB.Step03_Finalize_GB;

import org.apache.log4j.Logger;

import lib.Excel;


public class FinalizeResponse_GB
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
			 driver = new FirefoxDriver();
   	
   	url = "https://"+Excel.getCellValue(xlsFilePath, sheet, 6, 2);
       driver.get(url);    
	  }	
		
		
        //Test for Skill Request page
		  @Test(priority=0)
		  public void Login()
		  {
			 
			  Step03_Finalize_GB login = new Step03_Finalize_GB(driver);
			  login.loginAndOpenReq();
			  login.w3Id();
			  
				  
		  }
		  @Test(priority=1)
		  public void Finalize()
		  {
			 
			  Step03_Finalize_GB respfinal = new Step03_Finalize_GB(driver);
			   respfinal.FinaliseSubmit();
			  
				  
		  }
		
}
