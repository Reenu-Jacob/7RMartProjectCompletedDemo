package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageNewsPage {

	@FindBy(xpath = "//section[@class='content']/div[1]/a[1]/i")
	WebElement newButtonLink;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement newsTextBox;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmsg;
	@FindBy(xpath = "//table/tbody/tr[1]/td[2]/a[1]/i")
	WebElement editNewsBtn;
	@FindBy(css = "button[name='update']")
	WebElement updateNewsBtn;
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		// assign global with local
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ManageNewsPage clickOnNewButton() {
		newButtonLink.click();
		return this;
	}

	public ManageNewsPage enterNewsInTextBox(String news) {
		newsTextBox.sendKeys(news);
		return this;
	}

	public ManageNewsPage clickOnSaveButton() {
		saveButton.click();
		return this;
	}

	public boolean alertDisplayed() {
		return alertmsg.isDisplayed();
	}

	public ManageNewsPage clickOnEdit() {
		// editNewsBtn.click();
		PageUtility page = new PageUtility();
		page.javaSriptClick(driver, editNewsBtn);
		return this;
	}

	public ManageNewsPage editNews(String news) {
		newsTextBox.clear();
		newsTextBox.sendKeys(news);
		return this;
	}

	public ManageNewsPage clickOnUpdateButton() {
		// updateNewsBtn.click();
		PageUtility page = new PageUtility();
		page.javaSriptClick(driver, updateNewsBtn);
		return this;
	}

}
