package espocrm_page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//Test Case T005 Create Cases

public class Create_Cases 
	{
	//create a reference variable "driver" of type WebDriver	
	WebDriver driver;
	
	//build the repository with required WebElements
	@FindBy(how=How.XPATH,using="//span[text()=\"Cases\"]")
	WebElement cases;
	@FindBy(how=How.XPATH,using="//a[@data-name=\"create\"]")
	WebElement create_case;
	@FindBy(how=How.XPATH,using="//input[@data-name=\"name\"]")
	WebElement name;
	@FindBy(how=How.XPATH,using="//button[@data-action=\"save\"]")
	WebElement save;

	//create constructor
	public Create_Cases(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	//verify Cases link
	public void click_cases()
	{
		cases.click();
	}
	
	//verify Create Cases button
	public void click_create_case()
	{
		create_case.click();
	}
	
	//verify Name field
	public void type_name(String c_name)
	{
		name.sendKeys(c_name);
	}
	
	//verify Save button
	public void click_save()
	{
		save.click();
	}

	//assertion
	public void cases_assert(String c_name)
	{
		Assert.assertEquals(c_name,driver.findElement(By.xpath("//div[@class=\"clearfix header-breadcrumbs\"]/div[3]")).getText());
	}
}
