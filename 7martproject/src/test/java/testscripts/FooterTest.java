package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.FooterPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class FooterTest extends Base 
{
	public HomePage homePage;
	public FooterPage footer; 
	@Test
	public void clickAndUpdateOnFooterTab() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		homePage=loginpage.clickSignIn();
		FakerUtility faker = new FakerUtility();
		footer=homePage.clickOnMoreInfoLink();
		footer.clickOnEditButton();
		footer.editAddressTextBox(faker.generateAddress());
		footer.editEmailTextBox(faker.generateEmail());
		footer.clickOnUpdateButton();
	}
}
