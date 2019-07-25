package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo1 {

	public static void main(String[] args){
		
		//set the chrome driver properties
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\workspace\\Jars\\chromedriver_win32\\chromedriver.exe");
		
		//WebDriver driver = new ChromeDriver(); //open the new instance of browser , it supports all browsers
		//ChromeDriver driver = new ChromeDriver(); // can be instantiated this way also but it supports only Chrome.

		System.setProperty("webdriver.gecko.driver","C:\\Users\\IBM_ADMIN\\workspace\\Jars\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		//WebDriver driver1 = new FirefoxDriver(); // opens second firefox browser
		
		driver.get("https://opensource-demo.orangehrmlive.com/"); //to open a URL
		
		driver.manage().window().maximize(); //maximize the browser window
		
		String ExpectedTitle = driver.getTitle();
		System.out.println(ExpectedTitle);
		
		//System.out.println(driver.getTitle()); //can be done this way also
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		String ActualTitle=driver.getTitle();
		if (ExpectedTitle.equals(ActualTitle))
		{
			driver.findElement(By.id("welcome")).click();
			
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
			System.out.println("logout done");
			driver.close(); // close the active browser
			
			//driver.quit();  //close all the active windows
			//These two doesnot have return types and doesnot accept arguments
		}
		else
			{System.out.println("title mismatch");}
	}
}
