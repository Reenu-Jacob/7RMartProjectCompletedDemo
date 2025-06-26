package testscripts;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;


public class ManageCategoryTest extends Base{

	@Test
	public void addNewCategoryInManageCategoryPage() throws AWTException, IOException
	{
		String username=ExcelUtility.getStringData(1, 0,"LoginPage");
		String password=ExcelUtility.getStringData(1, 1,"LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.clickSignIn();
		//PageUtility page=new PageUtility();
		//page.scroll(driver);
		ManageCategoryPage manageCategory=new ManageCategoryPage(driver);
		manageCategory.clickOnMoreInfoInManageCategory();
		manageCategory.clickOnNewButton();
		manageCategory.addNewCategory();
		manageCategory.clickOnGroups();
		//page.scroll(driver);
		manageCategory.uploadImage();
		manageCategory.clickOnSave();
		
	}
}
