package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	
	public HomePage homePage;
	
	@Test(retryAnalyzer = retry.Retry.class, groups = ("Regression"),description="verifyTheUserIsAbletoLoginUsingValidCredentials")
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(username).enterPassword(password);
		homePage=loginPage.clickSignIn();
//		loginPage.enterUserName(username);
//		loginPage.enterPassword(password);
//		loginPage.clickSignIn();
		boolean displayedOrNot = loginPage.isDashboardDisplayed();
		Assert.assertTrue(displayedOrNot, Constant.LOGINVALIDASSERTION);
	}

	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidUserCredentials() throws IOException {
		String username = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(username).enterPassword(password);
		homePage=loginPage.clickSignIn();
//		loginPage.enterUserName(username);
//		loginPage.enterPassword(password);
//		loginPage.clickSignIn();
		boolean alertDisplayedOrNot = loginPage.isInvalidUsernameOrPasswordDisplayed();
		Assert.assertTrue(alertDisplayedOrNot, Constant.INVALIDUSERNAMEANDPASSWORD);
	}

	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidPassCredentials() throws IOException {
		String username = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(username).enterPassword(password);
		homePage=loginPage.clickSignIn();
//		loginPage.enterUserName(username);
//		loginPage.enterPassword(password);
//		loginPage.clickSignIn();
		boolean alertDisplayedOrNot = loginPage.isInvalidUsernameOrPasswordDisplayed();
		Assert.assertTrue(alertDisplayedOrNot,Constant.INVALIDUSERNAMEANDPASSWORD );
	}

	@Test(dataProvider="logindataprovider")
	public void verifyTheUserIsAbleToLoginUsingInvalidUserAndPassCredentials(String username ,String password) throws IOException {  
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(username).enterPassword(password);
		homePage=loginPage.clickSignIn();
//		loginPage.enterUserName(username);
//		loginPage.enterPassword(password);
//		loginPage.clickSignIn();
		boolean alertDisplayedOrNot = loginPage.isInvalidUsernameOrPasswordDisplayed();
		Assert.assertTrue(alertDisplayedOrNot,Constant.INVALIDUSERNAMEANDPASSWORD);
	}
	
	@DataProvider(name="logindataprovider")
	public Object[][] dpMethod()
	{
		return new Object[][] 
		{
			{"222","sss"},{"22222","rrrr"},{"eee","ddd"}
		};
	}
}
