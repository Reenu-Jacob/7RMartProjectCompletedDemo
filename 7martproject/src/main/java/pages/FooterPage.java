package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage 
{
	@FindBy(xpath="//section[@class='content']/div/div/div[8]/div/a")WebElement moreInfoLink;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']/i")WebElement editButton;
	@FindBy(xpath="//textarea[@id='content']")WebElement addressTextBox;
	@FindBy(xpath="//input[@id='email']")WebElement emailTextBox;
	@FindBy(xpath="//input[@id='phone']")WebElement phoneTextBox;
	@FindBy(xpath="//button[@name='Update']")WebElement updateButton;
	
	public WebDriver driver;
	
	public FooterPage(WebDriver driver) 
	{
		//assign global with local
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMoreInfoLink()
	{
		moreInfoLink.click();
	}
	
	public void clickOnEditButton()
	{
		editButton.click();
	}
	
	public void editAddressTextBox(String address)
	{
		addressTextBox.clear();
		addressTextBox.sendKeys(address);
	}
	
	public void editEmailTextBox(String email)
	{
		emailTextBox.clear();
		emailTextBox.sendKeys(email);
	}
	public void editPhoneTextBox(String phoneNumber)
	{
		phoneTextBox.clear();
		phoneTextBox.sendKeys(phoneNumber);
	}
	
	public void clickOnUpdateButton()
	{
		updateButton.click();
	}
}
