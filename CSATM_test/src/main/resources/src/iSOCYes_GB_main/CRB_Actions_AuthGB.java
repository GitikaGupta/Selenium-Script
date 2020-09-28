package iSOCYes_GB_main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ISOCYes_GB.Step04_CRB_Auth_GB;

import org.apache.log4j.Logger;

import lib.Excel;


public class CRB_Actions_AuthGB
{
	// TestNG logger
	
		public static Logger log = Logger.getLogger("TnM");
		
		public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
		public String sheet="Login"; 
		public String url;
		
		
		WebDriver driver;
		
		
		@BeforeTest
	    public void setup()
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\IBM_ADMIN\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			 driver = new FirefoxDriver();
    	url = "https://"+ Excel.getCellValue(xlsFilePath, sheet, 9, 2);
    	
    	//String url1 = "https://" +  id + ":" + paswd + "@" + url;
        
        driver.get(url);    
	  }	
		
		 // test to Login to the application as RIPC
		  
		  @Test(priority=0)
		  public void CRB_Wlcmpage() 
		  {
			  
			  Step04_CRB_Auth_GB login = new Step04_CRB_Auth_GB(driver);
			  login.login();
		  }
		  @Test(priority=1)
		  public void CRB_auth() 
		  {
			  
			  Step04_CRB_Auth_GB crbauth = new Step04_CRB_Auth_GB(driver);
			  crbauth.CRB_Auth();
		  }
			  
			 
		  
}
		  
	
