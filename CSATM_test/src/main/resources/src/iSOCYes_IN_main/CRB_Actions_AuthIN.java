package iSOCYes_IN_main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ISOCYes_IN.Step04_CRB_Auth_IN;

import org.apache.log4j.Logger;

import lib.Excel;


public class CRB_Actions_AuthIN
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
			System.setProperty("webdriver.gecko.driver","C:\\Users\\IBM_ADMIN\\My Documents\\SametimeFileTransfers\\geckodriver-v0.19.1-win64\\geckodriver.exe");
	    	driver = new FirefoxDriver();
	
    	//id = Excel.getCellValue(xlsFilePath, sheet, 15, 0);
   	  	//paswd = Excel.getCellValue(xlsFilePath, sheet, 15, 1);
    	url = "https://"+Excel.getCellValue(xlsFilePath, sheet, 15, 2);
    	
    	
        
        driver.get(url);    
	  }	
		
		 // test to Login to the application as RIPC
		  
		  
		  @Test(priority=0)
		  public void CRB_Wlcmpage() 
		  {
			  
			  Step04_CRB_Auth_IN crblogin = new Step04_CRB_Auth_IN(driver);
			  crblogin.login();
		  }
		  @Test(priority=1)
		  public void CRB_auth() 
		  {
			  
			  Step04_CRB_Auth_IN auth = new Step04_CRB_Auth_IN(driver);
			  auth.crb_auth();
		  }
			  
}
		  
	
