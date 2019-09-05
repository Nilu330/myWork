package espocrm_page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//Test Case T004 Create Opportunities

public class Create_Opportunities 
{
	//create a reference variable "driver" of type WebDriver
	WebDriver driver;
	
	//build the repository with required WebElements
	@FindBy(how=How.XPATH,using="//span[text()=\"Opportunities\"]")
	WebElement opportunities;
	@FindBy(how=How.XPATH,using="//a[@data-name=\"create\"]")
	WebElement create_opportunity;
	@FindBy(how=How.XPATH,using="//input[@data-name=\"name\"]")
	WebElement name;
	@FindBy(how=How.XPATH,using="//input[@data-name=\"probability\"]")
	WebElement probability;
	@FindBy(how=How.XPATH,using="//input[@data-name=\"amount\"]")
	WebElement amount;
	@FindBy(how=How.XPATH,using="//button[@class=\"btn btn-default btn-icon date-picker-btn\"]")
	WebElement close_date;
	@FindBy(how=How.XPATH,using="//button[@data-action=\"save\"]")
	WebElement save;
	@FindBy(how=How.XPATH,using="//div[@class=\"datepicker-days\"]/table/thead/tr/th[2][@class=\"datepicker-switch\"]")
	WebElement month_year;
	@FindBy(how=How.XPATH,using="//div[@class=\"datepicker-days\"]/table/thead/tr/th[3][@class=\"next\"]")
	WebElement month_year_next;
	@FindBy(how=How.XPATH,using="//td[@class=\"day\"]")
	WebElement day;
	
	//create constructor
	public Create_Opportunities(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);			
	}
	
	//verify Opportunities link
	public void click_opportunuties()
	{		
		opportunities.click();
	}
	
	//verify Create Opportunity button
	public void click_create_opportunity()
	{
		create_opportunity.click();
	}
	
	//verify Name field
	public void type_name(String opp_name) 
	{		
		name.sendKeys(opp_name);		
	}
	
	//verify Probability field
	public void type_probability(CharSequence prob)
	{ 		
		probability.clear();
		probability.sendKeys(prob);
	}
	
	//verify Amount field
	public void type_amount(CharSequence amt) 
	{
		amount.sendKeys(amt);
	}
	
	//verify Close Date calendar field
	public void select_close_date(String my,String d)
	{
		close_date.click();
		while(true) 
		{
			if(month_year.getText().equals(my)) 
			{
				break;
			}
			else 
			{
				
				month_year_next.click();
			}
		}
		
		
		day.findElement(By.xpath(" //td[@class=\"day\"][text()="+d+"]")).click();
	}
	
	//verify Save button
	public void click_save() 
	{
		save.click();
	}
	
	//assertion
	public void opportunities_assert(String o_name)
	{
		Assert.assertEquals(o_name,driver.findElement(By.xpath("//div[@class=\"clearfix header-breadcrumbs\"]/div[3]")).getText());
	}
}
	
	
	

