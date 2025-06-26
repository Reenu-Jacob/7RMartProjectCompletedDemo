package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility 
{
	public void selectByVisibleText(WebElement element,String visibleText) 
	{
		Select select =new Select(element);
		select.selectByVisibleText(visibleText);
		
	}
	
	public void selectByIndex(WebElement element,int indexValue) 
	{
		Select select =new Select(element);
		select.selectByIndex(indexValue);
		
	}
	
	public void selectByValue(WebElement element,String value) 
	{
		Select select =new Select(element);
		select.selectByValue(value);
		
	}
	
	public void dragAndDropMethod(WebDriver driver,WebElement source,WebElement target)
	{
		Actions ac=new Actions(driver);
		ac.dragAndDrop(source , target).build().perform();
	}
	
	public void doubleClickMethod(WebDriver driver,WebElement source)
	{
		Actions ac=new Actions(driver);
		ac.doubleClick(source).build().perform();;
	}
	public void moveToElementMethod(WebDriver driver,WebElement target)
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(target).build().perform();
	}
	public void scroll(WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,150)","");
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}
	
	public void scrollBy(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}
	public void javaSriptClick(WebDriver  driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
	}
	
}
