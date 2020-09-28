package iSOCYes_IN_main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ISOCYes_IN.Step01_CreateRequest_IN;

import org.apache.log4j.Logger;

import lib.Excel;


public class CreateRequest_IN
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
    	url = "https://"+ Excel.getCellValue(xlsFilePath, sheet, 12, 2);
    	
    	//String url1 = "https://" +  id + ":" + paswd + "@" + url;
    	      
        driver.get(url);    
	  }	
		
		 // test to Login to the application as RIPC
		  @Test(priority=0)
		  public void RIPC_Login() 
		  {
			  
			  Step01_CreateRequest_IN login = new Step01_CreateRequest_IN(driver);
			  login.login();
		  }
		  @Test(priority=1)
		  public void createReq() 
		  {
			  Step01_CreateRequest_IN create = new Step01_CreateRequest_IN(driver);
			  create.Create_New_Request();
		  }
		  @Test(priority=2)
		  public void sklReq() 
		  {
			  Step01_CreateRequest_IN newreq = new Step01_CreateRequest_IN(driver);
			  newreq.Skill_Request();
		  }
		  @Test(priority=3)
		  public void selectReq() 
		  {
			  Step01_CreateRequest_IN req = new Step01_CreateRequest_IN(driver);
			  req.Select_Requestor();
		  }  
			  
		  @Test(priority=4)
		  public void seljrss() 
		  {
			  Step01_CreateRequest_IN sel = new Step01_CreateRequest_IN(driver);
			  sel.Select_JRSS();
		  }
		  
		  @Test(priority=5)
		  public void reqdetail() 
		  {
			  Step01_CreateRequest_IN reqdet = new Step01_CreateRequest_IN(driver);
			  reqdet.Request_detailpage();
		  }
		  
		  @Test(priority=6)
		  public void locdetail() 
		  {
			  Step01_CreateRequest_IN loc = new Step01_CreateRequest_IN(driver);
			  loc.Skill_detailLocationpage();
		  }
		  @Test(priority=7)
		  public void alert() 
		  {
			  Step01_CreateRequest_IN alrt = new Step01_CreateRequest_IN(driver);
			  alrt.isAlertPresent();
		  }
		  
		  
		  @Test(priority=8)
		  public void skillpric() 
		  {
			  Step01_CreateRequest_IN sklprc = new Step01_CreateRequest_IN(driver);
			  sklprc.Skill_detail_skillpricepage();
		  }
		  @Test(priority=9)
		  public void suppsel() 
		  {
			  Step01_CreateRequest_IN supp = new Step01_CreateRequest_IN(driver);
			  supp.SupplierSelectionPage();
		  }
		  
		  
			 
			 
}
		  
		  
		

