package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage {
	@FindBy(xpath = "//img[@class='img-circle']/parent::a")
	WebElement Admin;
	@FindBy(xpath = "//a[@class='dropdown-item']/following-sibling::a")
	WebElement LogOut;
	@FindBy(xpath = "//section[@class='content']/div/div/div[1]/div/a")
	WebElement moreInfoLink;	
	@FindBy(xpath = "//section[@class='content']/div/div/div[9]/div/a")
	WebElement moreInfoLinkOnManageCategoryPage;
	@FindBy(xpath = "//section[@class='content']/div/div/div[3]/div/a")
	WebElement moreInfoLinkOnManageContactPage;
	@FindBy(xpath = "//section[@class='content']/div/div/div[7]/div/a")
	WebElement moreInfoLinkOnManageNews;
	@FindBy(xpath = "//section[@class='content']/div/div/div[8]/div/a")
	WebElement moreInfoLinkOnFooter;
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		// assign global with local
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public AdminUsersPage clickOnAdminUser() {
		// moreInfoLink.click();
		PageUtility page = new PageUtility();
		page.javaSriptClick(driver, moreInfoLink);
		return new AdminUsersPage(driver);
	}
	
	public ManageCategoryPage clickOnMoreInfoInManageCategory() {
		PageUtility page = new PageUtility();
		page.javaSriptClick(driver, moreInfoLinkOnManageCategoryPage);
		// moreInfoLink.click();
		return new ManageCategoryPage(driver);
	}
	
	public ManageContactPage clickOnMoreInfoButtonInManageContact() {
		PageUtility page = new PageUtility();
		page.javaSriptClick(driver, moreInfoLinkOnManageContactPage);
		return new ManageContactPage(driver);
	}
	
	public ManageNewsPage clickOnManageNews() {
		moreInfoLinkOnManageNews.click();
		return new ManageNewsPage(driver);
	}
	
	public FooterPage clickOnMoreInfoLink() {
		moreInfoLinkOnFooter.click();
		return new FooterPage(driver);
	}
	public HomePage clickOnAdmin() {
		Admin.click();
		return this;
	}

	public HomePage clickOnLogOut() {
		LogOut.click();
		return this;
	}
	
}
