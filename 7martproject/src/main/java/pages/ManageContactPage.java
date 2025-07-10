package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {

	@FindBy(xpath = "//div[@class='card']/div[2]/table/tbody/tr/td/a/i")
	WebElement updateContact;
	@FindBy(id = "email")
	WebElement emailTextBox;
	@FindBy(css = "textarea[placeholder='Enter the Address']")
	WebElement addressBox;
	@FindBy(css = "button[type='submit'] ")
	WebElement updateButton;
	public WebDriver driver;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ManageContactPage clickOnEditDetailsButton() {
		// updateContact.click();
		PageUtility page = new PageUtility();
		page.javaSriptClick(driver, updateContact);
		return this;
	}

	public ManageContactPage editCustomerDetails(String phoneNumber, String address) {
		emailTextBox.clear();
		emailTextBox.sendKeys(phoneNumber);
		addressBox.clear();
		addressBox.sendKeys(address);
		return this;
	}

	public ManageContactPage clickOnUpdateButton() {
		// updateButton.click();
		PageUtility page = new PageUtility();
		page.javaSriptClick(driver, updateButton);
		return this;
	}

	public boolean updateButtonIsDisplayedOrNot() {
		return updateButton.isDisplayed();
	}
}
