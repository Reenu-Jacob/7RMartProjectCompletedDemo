package testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;

public class Base 
{
	WebDriver driver;
	public Properties properties;
	public FileInputStream fileinputstream;
	
	@Parameters("browser")
	@BeforeMethod(alwaysRun=true)
	public void browserInitialization(String browser) throws Exception 
	{
		try 
		{
			properties=new Properties();
			fileinputstream=new FileInputStream(Constant.CONFIGFILE);
			properties.load(fileinputstream);
		}
		catch(Exception e) 
		{
			System.out.println("INVALID");
		}
		if(browser.equalsIgnoreCase("chrome"))
		{
			//ChromeOptions options = new ChromeOptions();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			throw new Exception("INVALID");
		}
		//driver=new ChromeDriver();
		//driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
		driver.manage().window().maximize();
		
	}
	@AfterMethod(alwaysRun=true)
	public void browserQuit(ITestResult iTestResult) throws IOException
	{ 
		if (iTestResult.getStatus() == ITestResult.FAILURE) 
	{ 
		ScreenshotUtility scrShot = new ScreenshotUtility(); 
		scrShot.getScreenShot(driver, iTestResult.getName()); 
	}
		driver.quit();
	}
}
