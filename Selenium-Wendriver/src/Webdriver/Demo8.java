package Webdriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Demo8 {

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\IBM_ADMIN\\workspace\\Jars\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://realestate.upskills.in/admin/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("user_login")).sendKeys("admin");
		driver.findElement(By.id("user_pass")).sendKeys("adminuser@12345");
		driver.findElement(By.name("login")).click();
		WebElement link = driver.findElement(By.xpath("//*[contains(text(),'Howdy')]"));
		Actions act = new Actions(driver);
		act.contextClick(link).build().perform();
		//act.sendKeys(Keys.).build().perform();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		
		//String title1= driver.getTitle();
		ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
		int size =tabs.size();
		driver.switchTo().window(tabs.get(1));
		String title1= driver.getTitle();
		
		driver.switchTo().window(tabs.get(0));
		String title2= driver.getTitle();
		System.out.println(title2);
		
		if (title1.equals(title2)){
			System.out.println("title are same");
		}
		
		else
		{
			System.out.println("title not same");
		}
	}

}
