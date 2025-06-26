package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LogOutPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LogOutTest extends Base
{
	@Test
	public void clickOnLogOutButton() throws IOException
	{
		 String username=ExcelUtility.getStringData(1, 0,"LoginPage");
		 String password=ExcelUtility.getStringData(1, 1,"LoginPage");
		 LoginPage loginPage=new LoginPage(driver);
		 loginPage.enterUserName(username);
		 loginPage.enterPassword(password);
		 loginPage.clickSignIn();
		 
		 LogOutPage logOut=new LogOutPage(driver);
		 logOut.clickOnAdmin();
		 logOut.clickOnLogOut();
	}
}
