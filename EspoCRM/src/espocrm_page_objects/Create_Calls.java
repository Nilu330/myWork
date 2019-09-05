package espocrm_page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class Create_Calls {
	//create a reference variable "driver" of type WebDriver 
	WebDriver driver;
	
	//build the repository with required WebElements
	@FindBy(how=How.XPATH,using="//span[text()=\"Calls\"]")
	WebElement calls;
	@FindBy(how=How.XPATH,using="//a[@data-name=\"create\"]")
	WebElement create_call;
	@FindBy(how=How.XPATH,using="//input[@data-name=\"name\"]")
	WebElement name;
	@FindBy(how=How.XPATH,using="//button[@type=\"button\"and@class=\"btn btn-default btn-icon date-picker-btn\"]")
	WebElement date_start;
	@FindBy(how=How.XPATH,using="//button[@type=\"button\"and@class=\"btn btn-default btn-icon time-picker-btn\"]")
	WebElement time_start;
	@FindBy(how=How.XPATH,using="//button[@class='btn btn-primary action'][contains(.,'Save')]")
	WebElement save;
	@FindBy(how=How.XPATH,using="//div[@class=\"datepicker-days\"]/table/thead/tr/th[2][@class=\"datepicker-switch\"]")
	WebElement month_year_start;
	@FindBy(how=How.XPATH,using="//div[@class=\"datepicker-days\"]/table/thead/tr/th[3][@class=\"next\"]")
	WebElement month_year_start_next;
	@FindBy(how=How.XPATH,using="//div[@class=\"datepicker-days\"]/table//tbody")
	WebElement day_start;
	
	//create constructor
	public Create_Calls(WebDriver driver) 
	{		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//verify Calls link
	public void click_calls()
	{		
		calls.click();
	}
	
	//verify Create Call button
	public void click_create_call()
	{
		create_call.click();
	}
	
	//verify Name field
	public void type_name(String c_name)
	{
		name.sendKeys(c_name);
	}
	
	//verify Date Start calendar field 
	public void select_date_start(String my_s,String d_s)
	{
		date_start.click();
	
		while(true)
		{
			if(month_year_start.getText().equals(my_s))
			{
				break;
			}
			else
			{
				month_year_start_next.click();
			}
		}
	
	day_start.findElement(By.xpath("//td[@class=\"day\"or @class=\"today active day\"][text()="+d_s+"]")).click();

	}
	
	//verify time Start Field
	public void select_time_start(String ts) 
	{
		time_start.click();
	
		time_start.findElement(By.xpath("//li[@class='ui-timepicker-am'or@class='ui-timepicker-pm'][contains(.,'"+ts+"')]")).click();
	}
	
	//verify Save button
	public void click_save() 
	{
		save.click();
	}
	
	//assertion
	public void calls_assert(String c_name)
	{
		Assert.assertEquals(c_name,driver.findElement(By.xpath("//div[@class=\"clearfix header-breadcrumbs\"]/div[3]")).getText());
	}	

}
