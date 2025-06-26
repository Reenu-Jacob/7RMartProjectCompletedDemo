package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage 
{
	@FindBy(xpath="//img[@class='img-circle']/parent::a")WebElement Admin;
	@FindBy(xpath="//a[@class='dropdown-item']/following-sibling::a")WebElement LogOut;
public WebDriver driver;
	
	public LogOutPage(WebDriver driver) 
	{
		//assign global with local
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAdmin()
	{
		Admin.click();
	}
	
	public void clickOnLogOut()
	{
		LogOut.click();
	}
}
