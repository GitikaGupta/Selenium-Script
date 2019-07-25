package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\workspace\\Jars\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://elearning.upskills.in/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.name("login")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin@123");
		driver.findElement(By.name("submitAuth")).click();
		driver.findElement(By.xpath("//*[@class='list-items-admin']/li[4]/a")).click();
		
		driver.findElement(By.id("user_import_import_file")).sendKeys("C:\\Users\\IBM_ADMIN\\Desktop\\attachment.txt");
	}

}
