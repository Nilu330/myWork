package espocrm_testng;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import espocrm_page_objects.Create_Accounts;
import espocrm_page_objects.Create_Calls;
import espocrm_page_objects.Create_Cases;
import espocrm_page_objects.Create_Contacts;
import espocrm_page_objects.Create_Leads;
import espocrm_page_objects.Create_Meetings;
import espocrm_page_objects.Create_Opportunities;
import espocrm_page_objects.Create_Tasks;
import espocrm_page_objects.Remove_Records;
import espocrm_page_objects.Verify_Login;
import espocrm_page_objects.Verify_Logout;


public class Main_Class_EspoCRM 
{
	//create a reference variable "driver" of type WebDriver	
	WebDriver driver;

	@BeforeSuite
	public void browser_launch() 
	{	
		//sets the system property to value named webdriver.chrome.driver and the path to get the chrome driver
		System.setProperty("webdriver.chrome.driver","C:\\Temp\\chromedriver.exe");
		
		//create an instance of the chrome driver
		driver=new ChromeDriver();
		
		//polled up to the 10s if the element that is being searched for is not available.
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//maximize the window
		driver.manage().window().maximize();
		
		//navigate to the web page
		driver.get("http://localhost/espocrm/");		
	}
	
	@Test(priority=0, enabled=true)
	
	//give right username and password and login to the web page
	public void verify_login() 
	{		
		Verify_Login Login=new Verify_Login(driver);
		Login.type_username("admin");		
		Login.type_password("test01");		
		Login.click_login();
	}
	
	@Test(priority=1,enabled=true)
	
	//Accounts Management- Create an Account T001
	public void create_accounts() throws InterruptedException 
	{		
		
		Create_Accounts Accounts=new Create_Accounts(driver);
		Thread.sleep(1000);
		Accounts.click_accounts();		
		Accounts.click_create_account();		
		Accounts.type_name("Account 1");		
		Accounts.click_save();
		Thread.sleep(1000);
		Accounts.accounts_assert("Account 1");
	}
	
	@Test(priority=2,enabled=true)
	
	//Contacts Management- Create a Contact T002
	public void create_contacts() throws InterruptedException  
	{		
		
		Create_Contacts Contacts=new Create_Contacts(driver);
		Thread.sleep(1000);
		Contacts.click_contacts();		
		Contacts.click_create_contact();		
		Contacts.select_salutation_name("Mrs.");		
		Contacts.type_first_name("Kara");		
		Contacts.type_last_name("Smith");		
		Contacts.click_save();
		Thread.sleep(1000);
		Contacts.contacts_assert("Kara Smith");
	}
	
	@Test(priority=3,enabled=true)
	
	//Leads Management- Create a Lead T003
	public void create_leads() throws InterruptedException
	{
		Create_Leads Leads=new Create_Leads(driver);
		Thread.sleep(1000);
		Leads.click_leads();		
		Leads.click_create_lead();
		Leads.select_salutation_name("Mr.");		
		Leads.type_first_name("John");		
		Leads.type_last_name("Diggle");		
		Leads.click_save();	
		Thread.sleep(1000);
		Leads.leads_assert("John Diggle");
	}
	
	@Test(priority=4,enabled=true)
	
	//Opportunities Management- Create an Opportunity T004
	public void create_opportunities() throws InterruptedException 
	{		
		Create_Opportunities Opportunities=new Create_Opportunities(driver);
		Thread.sleep(1000);
		Opportunities.click_opportunuties();		
		Opportunities.click_create_opportunity();		
		Opportunities.type_name("Opportunity 1");		
		Opportunities.type_probability("20");		
		Opportunities.type_amount("100");		
		Opportunities.select_close_date("July 2019","22");
		Thread.sleep(1000);
		Opportunities.click_save();	
		Thread.sleep(1000);
		Opportunities.opportunities_assert("Opportunity 1");
	}
	
	@Test(priority=5,enabled=true)
	
	//Cases Management- Create a Case T005
	public void create_cases() throws InterruptedException 
	{
		Create_Cases Cases=new Create_Cases(driver);
		Thread.sleep(1000);
		Cases.click_cases();		
		Cases.click_create_case();		
		Cases.type_name("Case 1");		
		Cases.click_save();
		Thread.sleep(1000);
		Cases.cases_assert("Case 1");		
	}
	
	@Test(priority=6,enabled=true)
	
	//Meetings Management- Create a Meeting T006
	public void create_meetings() throws InterruptedException 
	{
		Create_Meetings Meetings=new Create_Meetings(driver);
		Thread.sleep(1000);
		Meetings.click_meetings();	
		Meetings.click_create_meeting();		
		Meetings.type_name("Meeting 1");		
		Meetings.select_date_start("June 2019","20");		
		Meetings.select_time_start("09:00 am");
		Thread.sleep(1000);
		Meetings.click_save();
		Thread.sleep(1000);
		Meetings.meetings_assert("Meeting 1");
			
	}
	
	@Test(priority=7,enabled=true)
	
	//Calls Management- Create a Call T007
	public void create_calls() throws InterruptedException 
	{
		Create_Calls Calls=new Create_Calls(driver);
		Thread.sleep(1000);
		Calls.click_calls();			
		Calls.click_create_call();		
		Calls.type_name("Call 1");		
		Calls.select_date_start("May 2019","30");		
		//Calls.select_time_start("12:00 pm");
		Calls.click_save();
		Thread.sleep(1000);
		Calls.calls_assert("Call 1");
		
	}
	
	@Test(priority=8,enabled=true)
	
	//Task Management- Create a Task T008
	public void create_tasks() throws InterruptedException 
	{
		Create_Tasks Tasks=new Create_Tasks(driver);
		Thread.sleep(1000);
		Tasks.click_tasks();		
		Tasks.click_create_task();		
		Tasks.type_name("Task 1");
		Tasks.click_save();
		Thread.sleep(1000);
		Tasks.tasks_assert("Task 1");
	}
	
	@Test(priority=9,enabled=true)
	
	//after test delete all the test records
	public void test_closure() throws InterruptedException 
	{
		Remove_Records Records=new Remove_Records(driver);
		
		Records.remove_record_accounts();
		Thread.sleep(1000);
		Records.remove_record_contacts();
		Thread.sleep(1000);
		Records.remove_record_leads();
		Thread.sleep(1000);
		Records.remove_record_opportunities();
		Thread.sleep(1000);
		Records.remove_record_cases();
		Thread.sleep(1000);
		Records.remove_record_meetings();
		Thread.sleep(1000);
		Records.remove_record_calls();
		Thread.sleep(1000);
		Records.remove_record_tasks();		
	}
	
	//Logout of EspoCRM application
	@AfterTest
	public void verify_logout() 
	{
		Verify_Logout Logout=new Verify_Logout(driver);
		Logout.click_menu();
		Logout.click_logout();			
	}
	
	//quit browser and assign driver to null
	@AfterSuite
	public void tearDown()
	{
		driver.quit();	
		driver = null;		
	}	
}