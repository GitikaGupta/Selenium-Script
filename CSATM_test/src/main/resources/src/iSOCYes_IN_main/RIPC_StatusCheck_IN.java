package iSOCYes_IN_main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ISOCYes_GB.Step05_RIPC_ResponseStatus_GB;
import ISOCYes_IN.Step05_RIPC_ResponseStatus_IN;
import ISOCYes_US.Step01_CreateRequest;
import ISOCYes_US.Step02_AddResponse;
import ISOCYes_US.Step03_Finalize;
import ISOCYes_US.Step05_RIPC_ResponseStatus;

import org.apache.log4j.Logger;

import lib.Excel;


public class RIPC_StatusCheck_IN
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
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	    	driver = new ChromeDriver();
	    	
    	id = Excel.getCellValue(xlsFilePath, sheet, 12, 0);
   	  	paswd = Excel.getCellValue(xlsFilePath, sheet, 12, 1);
    	url = Excel.getCellValue(xlsFilePath, sheet, 12, 2);
    	
    	String url1 = "https://" +  id + ":" + paswd + "@" + url;
    	
            driver.get(url1);    
	  }	
		
		 // test to Login to the application as RIPC
		  @Test(priority=0)
		  public void RIPC_Login() 
		  {
			  
			  Step05_RIPC_ResponseStatus_IN statuschk = new  Step05_RIPC_ResponseStatus_IN(driver);
			  statuschk.login();
			  statuschk.status_verf();
			  
}
}