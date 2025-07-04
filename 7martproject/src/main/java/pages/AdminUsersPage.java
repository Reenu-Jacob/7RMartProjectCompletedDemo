package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUsersPage 
{
	@FindBy(xpath="//section[@class='content']/div/div/div[1]/div/a")WebElement moreInfoLink;
	@FindBy(xpath="//section[@class='content']/div/a[1]")WebElement newButtonLink;
	@FindBy(xpath="//input[@id='username']")WebElement username;
	@FindBy(xpath="//input[@id='password']")WebElement password;
	@FindBy(xpath="//select[@id='user_type']")WebElement selectAdmin;
	@FindBy(xpath="//button[@name='Create']")WebElement saveButton;
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/user/edit?edit=14552&page_ad=1']")WebElement editAction;
	//@FindBy(xpath="//table/tbody/tr[3]/td[5]/a[2]")WebElement editAction;
	@FindBy(xpath="//table/tbody/tr[1]/td[5]/a[2]/i")WebElement editAction;
	@FindBy(css="button[name='Update']")WebElement editClick;
	
	public WebDriver driver;
	
	public AdminUsersPage(WebDriver driver) 
	{
		//assign global with local
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAdminUser() 
	{
		//moreInfoLink.click();
		PageUtility page=new PageUtility();
		page.javaSriptClick(driver, moreInfoLink);
	}
	
	public void clickOnNewButtoninAdminUser()
	{
		//newButtonLink.click();
		PageUtility page=new PageUtility();
		page.javaSriptClick(driver, newButtonLink);
	}
	
	public void enterUserName(String adminUsername)
	{
		username.sendKeys(adminUsername);
	}
	
	public void enterPassword(String adminPassword)
	{
		password.sendKeys(adminPassword);
	}
	
	public void selectUserType()
	{

		PageUtility pageutility=new PageUtility();
		pageutility.selectByValue(selectAdmin, "admin");
	}
	
	public void clickOnSave()
	{
		//saveButton.click();
		PageUtility page=new PageUtility();
		page.javaSriptClick(driver, saveButton);

		
	}
	
	public void clickOnEdit()
	{
		//editAction.click();
		PageUtility page=new PageUtility();
		page.javaSriptClick(driver, editAction);

	}
	
	public void updateUsername(String usernameUpdate)
	{
		username.clear();
		username.sendKeys(usernameUpdate);
	}
	public void updatePassword(String passwordUpdate)
	{
		username.clear();
		username.sendKeys(passwordUpdate);
	}
	
	public void clickOnUpdate()
	{
		//editClick.click();
		PageUtility page=new PageUtility();
		page.javaSriptClick(driver, editClick);

	}
}
