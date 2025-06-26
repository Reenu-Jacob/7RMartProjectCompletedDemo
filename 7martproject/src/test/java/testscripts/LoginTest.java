package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base
{
	@Test(retryAnalyzer=retry.Retry.class,groups=("Regression"))
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException 
	{
		 String username=ExcelUtility.getStringData(1, 0,"LoginPage");
		 String password=ExcelUtility.getStringData(1, 1,"LoginPage");
		 LoginPage loginPage=new LoginPage(driver);
		 loginPage.enterUserName(username);
		 loginPage.enterPassword(password);
		 loginPage.clickSignIn();
		 boolean displayedOrNot=loginPage.isDashboardDisplayed();
		 Assert.assertTrue(displayedOrNot, "Home page not loaded");
	}
	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidUserCredentials() throws IOException 
	{
		 String username=ExcelUtility.getStringData(2, 0,"LoginPage");
		 String password=ExcelUtility.getStringData(2, 1,"LoginPage");
		 LoginPage loginPage=new LoginPage(driver);
		 loginPage.enterUserName(username);
		 loginPage.enterPassword(password);
		 loginPage.clickSignIn();
		 boolean alertDisplayedOrNot=loginPage.isInvalidUsernameOrPasswordDisplayed();
		 Assert.assertTrue(alertDisplayedOrNot, "Invalid Username");
	}
	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidPassCredentials() throws IOException 
	{
		 String username=ExcelUtility.getStringData(3, 0,"LoginPage");
		 String password=ExcelUtility.getStringData(3, 1,"LoginPage");
		 LoginPage loginPage=new LoginPage(driver);
		 loginPage.enterUserName(username);
		 loginPage.enterPassword(password);
		 loginPage.clickSignIn();
		 boolean alertDisplayedOrNot=loginPage.isInvalidUsernameOrPasswordDisplayed();
		 Assert.assertTrue(alertDisplayedOrNot, "Invalid Password");
	}
	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidUserAndPassCredentials() throws IOException 
	{
		 String username=ExcelUtility.getStringData(4, 0,"LoginPage");
		 String password=ExcelUtility.getStringData(4, 1,"LoginPage");
		 LoginPage loginPage=new LoginPage(driver);
		 loginPage.enterUserName(username);
		 loginPage.enterPassword(password);
		 loginPage.clickSignIn();
		 boolean alertDisplayedOrNot=loginPage.isInvalidUsernameOrPasswordDisplayed();
		 Assert.assertTrue(alertDisplayedOrNot, "Invalid Username and Password");
	}

}
