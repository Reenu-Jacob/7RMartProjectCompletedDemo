package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageNewsTest extends Base {
	
	public HomePage homePage;
	public ManageNewsPage manageNews;
	@Test
	public void clickOnMoreInfoInManageNews() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		String news = "Hello world";
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(username).enterPassword(password);
		homePage=loginPage.clickSignIn();
		manageNews=homePage.clickOnManageNews();
		manageNews.clickOnNewButton();
		manageNews.enterNewsInTextBox(news);
		manageNews.clickOnSaveButton();
		boolean isAlertDisplayed = manageNews.alertDisplayed();
		Assert.assertTrue(isAlertDisplayed, "Success Alert displayed");
	}

	@Test
	public void clickOnEditInManageNews() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(username).enterPassword(password);
		homePage=loginPage.clickSignIn();
		FakerUtility faker = new FakerUtility();
		String newsUpdated = faker.generateRandomText();
		manageNews=homePage.clickOnManageNews();
		manageNews.clickOnEdit();
		manageNews.editNews(newsUpdated);
		manageNews.clickOnUpdateButton();
	}
}
