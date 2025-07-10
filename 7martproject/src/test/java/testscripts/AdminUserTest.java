package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base

{
	public AdminUsersPage adminUsersPage;
	public HomePage homePage;
	@Test
	public void clickOnAdminUsersTab() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(username).enterPassword(password);
		homePage=loginPage.clickSignIn();		
		FakerUtility faker = new FakerUtility();
		String Adminusername = faker.creatARandomFirstName();
		String Adminpassword = faker.creatARandomLastName();		
		adminUsersPage=homePage.clickOnAdminUser();
		adminUsersPage.clickOnNewButtoninAdminUser();
		adminUsersPage.enterPassword(Adminpassword);
		adminUsersPage.selectUserType();
		adminUsersPage.clickOnSave();
	}

	@Test
	public void updateExistingUserDetails() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(username).enterPassword(password);
		homePage=loginPage.clickSignIn();
		FakerUtility faker = new FakerUtility();
		String Adminusername = faker.creatARandomFirstName();
		String Adminpassword = faker.creatARandomLastName();
		adminUsersPage=homePage.clickOnAdminUser();
		adminUsersPage.clickOnEdit();
		adminUsersPage.updateUsername(Adminusername);
		adminUsersPage.updatePassword(Adminpassword);
		adminUsersPage.clickOnUpdate();
	}
}
