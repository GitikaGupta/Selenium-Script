package ISOCYes_US_main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ISOCYes_US.Step04_CRB_Auth;

import org.apache.log4j.Logger;

import lib.Excel;


public class CRB_Actions
{
	// TestNG logger
	
		public static Logger log = Logger.getLogger("TnM");
		
		public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
		public String sheet="Login"; 
		public String url;
		public String id;
		public String paswd;
		
		WebDriver driver;
		
		
		@BeforeTest
	    public void setup()
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\IBM_ADMIN\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			System.out.println("output 1");
			driver = new FirefoxDriver();
    	
    	url = "https://"+Excel.getCellValue(xlsFilePath, sheet, 3, 2);
        driver.get(url);    
	  }	
		
		 // test to Login to the application as RIPC
		  
		 @Test(priority=0)
		  public void CRB_login() 
		  {
			  
			  Step04_CRB_Auth login = new Step04_CRB_Auth(driver);
			  login.login();
		  }
		  @Test(priority=1)
		  public void CRB_auth() 
		  {
			  
			  Step04_CRB_Auth crbauth = new Step04_CRB_Auth(driver);
			   crbauth.CRB_Auth();
		  }
		 
		 
			 
}
		  
	
