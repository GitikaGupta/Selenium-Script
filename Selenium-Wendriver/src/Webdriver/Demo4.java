package Webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Demo4 {

	public static void main(String[] args){
		
	
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
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	act.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER).perform();
	
	driver.findElement(By.linkText("Performance")).click();
	List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	int size = allLinks.size();
	for (int i=0; i <size; i++)
	{
		System.out.println(allLinks.get(i).getText() + "..."+allLinks.get(i).getAttribute("href"));
	}
	}
}
