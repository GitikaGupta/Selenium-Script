package Webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo5 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\workspace\\Jars\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/"); //to open a URL
		
		driver.manage().window().maximize(); //maximize the browser window
		
	//	driver.findElement(By.linkText("Performance")).click();
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		int size = allLinks.size();
		System.out.println(size);
		String arr[] = new String[size+4];
		
		for (int i=0;i<size;i++){
			arr[i]=allLinks.get(i).getText();
		//	System.out.println("Element" + i +"....."+arr[i]);
		}
		for (int i=0; i <size; i++)
		{
			driver.findElement(By.linkText(arr[i])).click();
				
		//	Link.click();
			Thread.sleep(3000);
			if(driver.getTitle().equals("Under Construction: Mercury Tours"))
					{
				System.out.println(i+")"+arr[i]+"....This page is Under Construction");
					}
			else
			{
				System.out.println(i+")"+arr[i]+"....working fine");
			}
			Thread.sleep(2000);
			driver.navigate().back();
		}
		}

	}


