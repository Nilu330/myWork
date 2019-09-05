package espocrm_page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//Logout from EspoCRM Application

public class Verify_Logout 
{
	//create a reference variable "driver" of type WebDriver
	WebDriver driver;
	
	//build the repository with required WebElements
	@FindBy(how=How.XPATH,using="//a[@title=\"Menu\"]")
	WebElement menu;
	@FindBy(how=How.XPATH,using="//a[@data-action=\"logout\"]")
	WebElement logout;
	
	//create constructor
	public Verify_Logout(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//verify Menu drop down
	public void click_menu()
	{
		menu.click();
	}
	
	//verify Logout link
	public void click_logout() 
	{
		logout.click();	
	}
	

}
