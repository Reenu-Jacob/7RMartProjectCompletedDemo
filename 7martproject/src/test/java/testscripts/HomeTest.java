package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	
	public HomePage homePage;
	@Test
	public void clickOnLogOutButton() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(username).enterPassword(password);
		homePage=loginPage.clickSignIn();
		homePage.clickOnAdmin().clickOnLogOut();
//		loginPage.enterUserName(username);
//		loginPage.enterPassword(password);
//		loginPage.clickSignIn();
//		HomePage logOut = new HomePage(driver);
//		logOut.clickOnAdmin();
//		logOut.clickOnLogOut();
	}
}
