package Webdriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class9 {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\IBM_ADMIN\\workspace\\Jars\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[contains(text(),'Gmail')]")).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
		ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
		int size = tabs.size();
		System.out.println(size);
		driver.switchTo().window(tabs.get(1));
		String title1= driver.getTitle();
		driver.switchTo().window(tabs.get(0));
		String title2= driver.getTitle();
		
		if(title1.equals(title2)){
			System.out.println("titles are same");
		}
		else
			System.out.println("titles are not same");
		
		
		
	}

}
