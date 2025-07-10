package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;
import utilities.PageUtility;

public class ManageContactTest extends Base {
	
	public HomePage homePage;
	public ManageContactPage manageContact;
	@Test
	public void ClickOnManageContactTab() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(username).enterPassword(password);
		//loginPage.enterPassword(password);
		homePage=loginPage.clickSignIn();
		//ManageContactPage manageContact = new ManageContactPage(driver);
		manageContact=homePage.clickOnMoreInfoButtonInManageContact();
		manageContact.clickOnEditDetailsButton();
		FakerUtility faker = new FakerUtility();
		manageContact.editCustomerDetails(faker.generateEmail(), faker.generateAddress());
		PageUtility page = new PageUtility();
		page.scroll(driver);
		manageContact.clickOnUpdateButton();

	}

	@Test
	public void VerifyUpdateButtonIsPresent() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(username).enterPassword(password);
		//loginPage.enterPassword(password);
		homePage=loginPage.clickSignIn();
		//ManageContactPage manageContact = new ManageContactPage(driver);
		manageContact=homePage.clickOnMoreInfoButtonInManageContact();
		manageContact.clickOnEditDetailsButton();
		boolean isPresent = manageContact.updateButtonIsDisplayedOrNot();
		Assert.assertTrue(isPresent, "UpdateButton not displayed");

	}
}
