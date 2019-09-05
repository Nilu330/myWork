package espocrm_page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//Test Case T001 Create Accounts

public class Create_Accounts
{
	//create a reference variable "driver" of type WebDriver 
	WebDriver driver;
	
	//build the repository with required WebElements
	@FindBy(how=How.XPATH,using="//li[@data-name=\"Account\"]")
	WebElement accounts;
	@FindBy(how=How.XPATH,using="//a[ @data-name=\"create\"]")
	WebElement create_account;
	@FindBy(how=How.XPATH,using="//input[@data-name=\"name\"]")
	WebElement name;
	@FindBy(how=How.XPATH,using="//button[@data-action=\"save\"]")
	WebElement save;
	
	//create constructor	
	public Create_Accounts(WebDriver driver) 
	{		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//verify Accounts link
	public void click_accounts()
	{
			accounts.click();	
	}
	
	//verify Create Account button
	public void click_create_account() 
	{
			create_account.click();
	}
	
	//verify Name field
	public void type_name(String a_name)
	{
			name.sendKeys(a_name);
	}
	
	//verify Save button
	public void click_save() 
	{
			save.click();
	}
	
	//assertion
	public void accounts_assert(String a_name)
	{
		Assert.assertEquals(a_name,driver.findElement(By.xpath("//div[@class=\"clearfix header-breadcrumbs\"]/div[3]")).getText());
	}	

}
