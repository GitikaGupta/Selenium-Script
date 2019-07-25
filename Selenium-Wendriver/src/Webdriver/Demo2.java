package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo2 {


	public static void main(String[] args) throws InterruptedException{
System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\workspace\\Jars\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/");
		
		driver.manage().window().maximize();
		
		WebElement UN = driver.findElement(By.name("userName"));
		if(UN.isEnabled())
		{
			UN.sendKeys("sunil");
			Thread.sleep(3000);
			UN.clear();
			UN.sendKeys("sunil");
		}
		if (UN.isDisplayed())
		{
			String nam=UN.getAttribute("name");//this will get the attribute of name which is userName
			//driver.findElement(By.name(nam)).clear();
			System.out.println("Name attribute is : " + nam);
			String sub1 = nam.substring(0,2);
			System.out.println("New Name attribute is : " + sub1);
			
			
			String val1=UN.getAttribute("value"); //this will get the attribute of value
			
			System.out.println("Value attribute is : "+val1);
			
			String val2=UN.getAttribute("type"); //this will get the attribute of type
			
			System.out.println("Type attribute is : "+val2);
			
			WebElement label1 = driver.findElement(By.xpath("//*[contains(text(),'Name:')]"));
			System.out.println("Label is: " + label1.getText());
			
			WebElement label2 = driver.findElement(By.xpath("//*[text()='Password:']"));
			System.out.println("Password label is : " + label2.getText());
			//System.out.println(UN);
		}
		//driver.findElement(By.name("login")).click();
	}
	
	
}

