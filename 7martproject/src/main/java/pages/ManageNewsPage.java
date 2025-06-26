package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageNewsPage 
{
	@FindBy(xpath="//section[@class='content']/div/div/div[7]/div/a")WebElement moreInfoLink;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")WebElement newButtonLink;
	@FindBy(xpath="//textarea[@id='news']")WebElement newsTextBox;
	@FindBy(xpath="//button[@type='submit']")WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertmsg;
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/edit?edit=6428&page_ad=1']/i")WebElement editNewsBtn;
	@FindBy(xpath="//table/tbody/tr[1]/td[2]/a[1]/i")WebElement editNewsBtn;
	@FindBy(css="button[name='update']")WebElement updateNewsBtn;
	public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver) 
	{
		//assign global with local
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnManageNews() 
	{
		moreInfoLink.click();
	}
	
	public void clickOnNewButton()
	{
		newButtonLink.click();
	}
	
	public void enterNewsInTextBox(String news)
	{
		newsTextBox.sendKeys(news);
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
	public boolean alertDisplayed()
	{
		return alertmsg.isDisplayed();
	}
	
	public void clickOnEdit()
	{
		//editNewsBtn.click();
		PageUtility page=new PageUtility();
		page.javaSriptClick(driver, editNewsBtn);
	}
	
	public void editNews(String news)
	{
		newsTextBox.clear();
		newsTextBox.sendKeys(news);
	}
	
	public void clickOnUpdateButton()
	{
		//updateNewsBtn.click();
		PageUtility page=new PageUtility();
		page.javaSriptClick(driver, updateNewsBtn);
	}
	
}
