package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

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
//		loginPage.enterUserName(username);
//		loginPage.enterPassword(password);
//		loginPage.clickSignIn();
		adminUsersPage.clickOnNewButtoninAdminUser();
		//adminUsersPage.enterUserName(Adminusername).enterPassword(Adminpassword).selectUserType().clickOnSave();
		adminUsersPage.enterPassword(Adminpassword);
		adminUsersPage.selectUserType();
		adminUsersPage.clickOnSave();
//		AdminUsersPage adminuser = new AdminUsersPage(driver);
		
//		adminuser.clickOnAdminUser();
//		adminuser.clickOnNewButtoninAdminUser();
//		adminuser.enterUserName(Adminusername);
//		adminuser.enterPassword(Adminpassword);
//		adminuser.selectUserType();
//		adminuser.clickOnSave();
	}

	@Test
	public void updateExistingUserDetails() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		// String Adminusername=ExcelUtility.getStringData(1, 0,"AdminUsers");
		// String Adminpassword=ExcelUtility.getStringData(1, 1,"AdminUsers");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(username).enterPassword(password);
//		loginPage.enterPassword(password);
		homePage=loginPage.clickSignIn();

		//AdminUsersPage adminuser = new AdminUsersPage(driver);
		FakerUtility faker = new FakerUtility();
		String Adminusername = faker.creatARandomFirstName();
		String Adminpassword = faker.creatARandomLastName();
		adminUsersPage=homePage.clickOnAdminUser();
		//adminuser.clickOnAdminUser();
		adminUsersPage.clickOnEdit();
		adminUsersPage.updateUsername(Adminusername);
		adminUsersPage.updatePassword(Adminpassword);
		adminUsersPage.clickOnUpdate();
	}
}
