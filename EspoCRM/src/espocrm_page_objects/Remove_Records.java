package espocrm_page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//Remove the added Records
public class Remove_Records 
{
	//create a reference variable "driver" of type WebDriver
	WebDriver driver;
	
	//build the repository with required WebElements
	@FindBy(how=How.XPATH,using="//li[@data-name=\"Account\"]")
	WebElement accounts;
	@FindBy(how=How.XPATH,using="//span[text()=\"Contacts\"]")
	WebElement contacts;
	@FindBy(how=How.XPATH,using="//span[text()=\"Leads\"]")
	WebElement leads;
	@FindBy(how=How.XPATH,using="//span[text()=\"Opportunities\"]")
	WebElement opportunities;
	@FindBy(how=How.XPATH,using="//span[text()=\"Cases\"]")
	WebElement cases;
	@FindBy(how=How.XPATH,using="//span[text()=\"Meetings\"]")
	WebElement meetings;
	@FindBy(how=How.XPATH,using="//span[text()=\"Calls\"]")
	WebElement calls;
	@FindBy(how=How.XPATH,using="//li[@data-name=\"Task\"]")
	WebElement tasks;
	@FindBy(how=How.XPATH,using="//input[@class=\"select-all\"]")
	WebElement select_all;
	@FindBy(how=How.XPATH,using="//div[@class=\"btn-group actions\"]")
	WebElement action;
	@FindBy(how=How.XPATH,using="//div[@class=\"btn-group actions open\"]/ul/li/a[@data-action=\"remove\"]")
	WebElement action_remove;
	@FindBy(how=How.XPATH,using="//button[@data-name=\"confirm\"]")
	WebElement remove;
	
	//create constructor
	public Remove_Records(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//remove the test data from Accounts	
	public void remove_record_accounts()
	{
		accounts.click();
		select_all.click();
		action.click();
		action_remove.click();
		remove.click();
	}
	
	//remove the test data from Contacts
	public void remove_record_contacts()
	{
		contacts.click();
		select_all.click();
		action.click();
		action_remove.click();
		remove.click();
	}
	
	//remove the test data from Leads
	public void remove_record_leads()
	{
		leads.click();
		select_all.click();
		action.click();
		action_remove.click();
		remove.click();
	}
	
	//remove the test data from OPportunities
	public void remove_record_opportunities()
	{
		opportunities.click();
		select_all.click();
		action.click();
		action_remove.click();
		remove.click();
	}
	
	//remove the test data from Cases
	public void remove_record_cases()
	{
		cases.click();
		select_all.click();
		action.click();
		action_remove.click();
		remove.click();
	}
	
	//remove the test data from Meetings
	public void remove_record_meetings()
	{
		meetings.click();
		select_all.click();
		action.click();
		action_remove.click();
		remove.click();
	}
	 
	//remove the test data from Calls
	public void remove_record_calls()
	{
		calls.click();
		select_all.click();
		action.click();
		action_remove.click();
		remove.click();
	}
	
	//remove the test data from Tasks
	public void remove_record_tasks()
	{
		tasks.click();
		select_all.click();
		action.click();
		action_remove.click();
		remove.click();
	}
}
