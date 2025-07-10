package testscripts;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.PageUtility;

public class ManageCategoryTest extends Base {

	public HomePage homePage;
	public ManageCategoryPage manageCategory;
	@Test
	public void addNewCategoryInManageCategoryPage() throws AWTException, IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(username).enterPassword(password);
		//loginPage.enterPassword(password);
		homePage=loginPage.clickSignIn();
		 PageUtility page=new PageUtility();
		 page.scroll(driver);
		//ManageCategoryPage manageCategory = new ManageCategoryPage(driver);
		manageCategory=homePage.clickOnMoreInfoInManageCategory();
		manageCategory.clickOnNewButton();
		manageCategory.addNewCategory();
		manageCategory.clickOnGroups();
		// page.scroll(driver);
		manageCategory.uploadImage();
		manageCategory.clickOnSave();

	}
}
