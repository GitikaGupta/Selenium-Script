package ISOCYes_US_main;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ISOCYes_US.Step06_PO_Auth;
import lib.Excel;

 
public class PO_Authorization {
  
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
				 url = Excel.getCellValue(xlsFilePath, sheet, 4, 2);
	    	
	    	//String url1 = "https://" +  id + ":" + paswd + "@" + url;
	        
	        driver.get(url);    
		  }	
			
			// test to Login to the application as RIPC
			  @Test(priority=0)
			  public void PO_Login() 
			  {
				  
				  Step06_PO_Auth login = new Step06_PO_Auth(driver);
				  login.login();
			  }
			  
			  
			// test to authorize request from PO
			  @Test(priority=1)
			  public void authorize_PO() 
			  {
				  
				  Step06_PO_Auth auth_PO = new Step06_PO_Auth(driver);
				  auth_PO.authorize_PO();
			  }


}


