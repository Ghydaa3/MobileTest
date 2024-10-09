package App_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MyMobile {
	
	AndroidDriver driver;
	DesiredCapabilities caps=new DesiredCapabilities();
	
	
	@BeforeTest
	public void preTest() {
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "JOR");
		
//		caps.setCapability("chromedriverExecutable", "D:\\app\\chromedriver_win32\\chromedriver.exe");
//		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		
		File myApp=new File("");
		caps.setCapability(MobileCapabilityType.APP, myApp.getAbsolutePath());
		
		
	}
	
	@Test(enabled=false)
	public void MyTest() throws MalformedURLException {
	
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		List<WebElement> allBttn=driver.findElements(By.className("btn"));
		for( int i=0 ; i<allBttn.size();i++) {
			
			allBttn.get(i).click();
		}
		
	
		
		
	}
	

		
		

	
	

	
	
	
	
	@AfterTest
	public void postTest() {
		
	}
	
}
