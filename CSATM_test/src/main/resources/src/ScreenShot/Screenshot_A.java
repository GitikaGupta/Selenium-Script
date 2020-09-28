package ScreenShot;

import org.openqa.selenium.WebDriver;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

public class Screenshot_A {
	
	private WebDriver driver;
	public void snap_IN()
	{
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Administrator\\T&M\\2018\\2019\\Selenium\\ISOC\\IN\\Core\\");
	}

}
