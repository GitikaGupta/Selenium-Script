package iSOCYes_IN_main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ISOCYes_IN.Step02_AddResponse_IN;

import org.apache.log4j.Logger;

import lib.Excel;


public class AddResponse_IN
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
			System.setProperty("webdriver.gecko.driver","C:\\Users\\IBM_ADMIN\\My Documents\\SametimeFileTransfers\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			 driver = new FirefoxDriver();
		url = "https://"+ Excel.getCellValue(xlsFilePath, sheet, 14, 2);
    	
              
        driver.get(url);    
	  }	
		
		 

		  // Test to add response
	   @Test(priority=0)
		  public void add_response()
		  {
		       log.debug("Inside open_CSA_Tab() function");
			  
			  Step02_AddResponse_IN addresp = new Step02_AddResponse_IN(driver); 
			  	 addresp.login();
		  }
	   @Test(priority=1)
	   public void details()
	   {
		   for (int i=400; i<500; i++)
		   {
		   Step02_AddResponse_IN add_details = new Step02_AddResponse_IN(driver);
		   add_details.FillRespdetails("U22QGQ"+i , "IN" , "U22QGQ"+i, "RefNum"+i, "10000");
		   }
	   }
/*	  @Test(priority=2)
	   public void submtresp()
	   {
		   Step02_AddResponse_IN submt = new Step02_AddResponse_IN(driver);
		   submt.Submit();
			  }
			  */
	    
		  }

		
		  
		

