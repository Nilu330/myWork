package espocrm_page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

//Test Case T003 Create Leads

public class Create_Leads 
{
	//create a reference variable "driver" of type WebDriver 
	WebDriver driver;
	
	//build the repository with required WebElements
	@FindBy(how=How.XPATH,using="//span[text()=\"Leads\"]")
	WebElement leads;
	@FindBy(how=How.XPATH,using="//a[@data-name=\"create\"]")
	WebElement create_lead;
	@FindBy(how=How.XPATH,using="//select[@data-name=\"salutationName\"]")
	WebElement salutation_name;
	@FindBy(how=How.XPATH,using="//input[@data-name=\"firstName\"]")
	WebElement first_name;
	@FindBy(how=How.XPATH,using="//input[@data-name=\"lastName\"]")
	WebElement last_name;
	@FindBy(how=How.XPATH,using="//button[@data-action=\"save\"]")
	WebElement save;

	//create constructor
	public Create_Leads(WebDriver driver) 
	{		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//verify Leads link
	public void click_leads() 
	{		
		leads.click();
	}
	
	//verify Create Leads button
	public void click_create_lead()
	{		
		create_lead.click();
	}
	
	//verify Salutation Name drop down list
	public void select_salutation_name(String sname) 
	{		
		Select s_name=new Select(salutation_name);
		s_name.selectByVisibleText(sname);
	}
	
	//verify First Name field
	public void type_first_name(String fname) 
	{		
		first_name.sendKeys(fname);
	}
	
	//verify Last Name field
	public void type_last_name(String lname)
	{		
		last_name.sendKeys(lname);
	}
	
	//verify Save button
	public void click_save()
	{		
		save.click();
	}
	
	//assertion
		public void leads_assert(String l_name)
		{
			Assert.assertEquals(l_name,driver.findElement(By.xpath("//div[@class=\"clearfix header-breadcrumbs\"]/div[3]")).getText());
		}
}