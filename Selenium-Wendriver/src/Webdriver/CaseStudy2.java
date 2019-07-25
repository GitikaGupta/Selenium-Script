package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CaseStudy2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\workspace\\Jars\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/"); //to open a URL
		
		driver.manage().window().maximize(); //maximize the browser window
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		WebElement login = driver.findElement(By.id("btnLogin"));
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		//act.moveToElement(login).click();
		
			Thread.sleep(3000);
		WebElement pim = driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']/b"));
		act.moveToElement(pim).build().perform();
		WebElement addemp = driver.findElement(By.id("menu_pim_viewEmployeeList"));
		act.sendKeys(addemp,Keys.ENTER).build().perform();
		act.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
				//driver.navigate().back();

	}

}
