package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageCategoryPage {
	@FindBy(xpath = "//section[@class='content']/div/div/div[9]/div/a")
	WebElement moreInfoLink;
	@FindBy(xpath = "//section[@class='content']/div/a[1]/i")
	WebElement newButton;
	@FindBy(id = "category")
	WebElement categoryText;
	@FindBy(id = "134-selectable")
	WebElement discountGroups;
	@FindBy(id = "main_img")
	WebElement imageUpload;
	@FindBy(css = "button[name='create']")
	WebElement saveButton;

	public WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	public void clickOnMoreInfoInManageCategory() {
//		PageUtility page = new PageUtility();
//		page.javaSriptClick(driver, moreInfoLink);
//		// moreInfoLink.click();
//	}

	public ManageCategoryPage clickOnNewButton() {
		newButton.click();
		return this;
	}

	public ManageCategoryPage addNewCategory() {
		categoryText.sendKeys("Portrait_1");
		return this;
	}

	public ManageCategoryPage clickOnGroups() {
		discountGroups.click();
		return this;
	}

	public ManageCategoryPage uploadImage() throws AWTException {
		WaitUtility waitUtility = new WaitUtility();
		waitUtility.elementToBeClickable(driver, imageUpload);
		FileUploadUtility fileUpload = new FileUploadUtility();
		fileUpload.fileUploadUsingSendKeys(imageUpload, Constant.IMAGEFILE);
		// fileUpload.fileuploadUsingRobertClass(imageUpload,Constant.IMAGEFILE);
		return this;
	}

	public ManageCategoryPage clickOnSave() {
		PageUtility page = new PageUtility();
		page.javaSriptClick(driver, saveButton);
		// saveButton.click();
		return this;
	}
}
