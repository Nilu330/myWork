package espocrm_page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//Test Case T008 Create Tasks

public class Create_Tasks 
{
	//create a reference variable "driver" of type WebDriver
	WebDriver driver;
	
	//build the repository with required WebElements
	@FindBy(how=How.XPATH,using="//li[@data-name=\"Task\"]")
	WebElement tasks;
	@FindBy(how=How.XPATH,using="//a[@data-name=\"create\"]")
	WebElement create_task;
	@FindBy(how=How.XPATH,using="//input[@data-name=\"name\"]")
	WebElement name;
	@FindBy(how=How.XPATH,using="//button[@data-action=\"save\"]")
	WebElement save;
	
	//create constructor
	public Create_Tasks(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//verify Tasks link
	public void click_tasks()
	{
		tasks.click();
	}
	
	//verify Create Tasks button
	public void click_create_task()
	{
		create_task.click();
	}
	
	//verify Name field
	public void type_name(String t_name)
	{
		name.sendKeys(t_name);
	}
	
	//verify Save button
	public void click_save()
	{
		save.click();
	}	
	
	//assertion
	public void tasks_assert(String t_name)
	{
		Assert.assertEquals(t_name,driver.findElement(By.xpath("//div[@class=\"clearfix header-breadcrumbs\"]/div[3]")).getText());
	}

}
