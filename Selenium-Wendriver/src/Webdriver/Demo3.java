package Webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Demo3 {


	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\IBM_ADMIN\\workspace\\Jars\\chromedriver_win32\\chromedriver.exe");
				
				WebDriver driver = new ChromeDriver();
				
				driver.get("http://newtours.demoaut.com/");
				
				driver.manage().window().maximize();
				
				driver.findElement(By.name("userName")).sendKeys("sunil");
				driver.findElement(By.name("password")).sendKeys("sunil");
				driver.findElement(By.name("login")).click();
				Thread.sleep(2000);
				WebElement RT=driver.findElement(By.xpath("//*[@type='radio' and @value='roundtrip']"));
				
				WebElement OW=driver.findElement(By.xpath("//*[@type='radio' and @value='oneway']"));
				
				
				if(RT.isSelected())
				{
					System.out.println("Round table is selected by default ");
					OW.click();
					System.out.println("One way is selected now");
				}
				WebElement DD=driver.findElement(By.name("passCount")); //.sendKeys("2");
				Select sel = new Select(DD);
				
				List<WebElement> data = sel.getOptions();
				System.out.println(data.size());
				for (int i=0; i < data.size(); i++)
				{
					System.out.println(data.get(i).getText());
				}
				
				sel.selectByVisibleText("2");
				Thread.sleep(2000);
				
				WebElement DD1 = driver.findElement(By.name("fromPort"));
				Select sel1=new Select(DD1);
				
				List<WebElement> data1 = sel1.getOptions();
				System.out.println(data1.size());
				
				for(int j=0;j<data1.size(); j++)
				{
					System.out.println("Country " +j+ "......"+data1.get(j).getText());
				}
				
				driver.findElement(By.xpath("//*[@name='servClass' and @value='Business']")).click();
				driver.findElement(By.name("findFlights")).click();
				driver.findElement(By.name("reserveFlights")).click();
				Thread.sleep(2000);
				driver.findElement(By.name("passFirst0")).sendKeys("Gitika");
				driver.findElement(By.name("passLast0")).sendKeys("Gupta");
				driver.findElement(By.name("creditnumber")).sendKeys("12345");
				
				List<WebElement> el1= driver.findElements(By.name("ticketLess"));
		//for(WebElement checkbox:el1){
	//		checkbox.click();
	//	}
			//int
				int i;
				for (i=0;i<(el1.size()-1); i++)
	{
	 el1.get(i).click();
	}
				
				
				
				
			/*	driver.findElement(By.name("fromPort")).sendKeys("London");
				driver.findElement(By.name("fromMonth")).sendKeys("September");
				driver.findElement(By.name("fromDay")).sendKeys("19"); 
				*/
				
	}
}
