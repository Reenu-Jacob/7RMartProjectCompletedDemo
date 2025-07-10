package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(xpath = "//input[@name='username']")
	WebElement user;
	@FindBy(xpath = "//input[@name='password']")
	WebElement pass;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signIn;
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboard;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement Invalidalertmsg;

	// create globally because driver in constructor is local, and to get the access
	// in entire class declare globally
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		// assign global with local
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage enterUserName(String username) {
		user.sendKeys(username);
		return this;
	}

	public LoginPage enterPassword(String password) {
		pass.sendKeys(password);
		return this;
	}
	public HomePage clickSignIn() {
		signIn.click();
		return new HomePage(driver);
	}

	public boolean isDashboardDisplayed() {
		return dashboard.isDisplayed();
	}

	public boolean isInvalidUsernameOrPasswordDisplayed() {
		return Invalidalertmsg.isDisplayed();
	}

}
