package espocrm_page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//Login to EspoCRM Application

public class Verify_Login 
{
	//create a reference variable "driver" of type WebDriver
	WebDriver driver;

	//build the repository with required WebElements
	@FindBy(how=How.ID,using="field-userName")
	WebElement username;
	@FindBy(how=How.ID,using="field-password")
	WebElement password;
	@FindBy(how=How.ID,using="btn-login")
	WebElement login;
	
	//create constructor
	public Verify_Login(WebDriver driver) 
	{		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//verify UserName field with correct UserName
	public void type_username(String uid)
	{		
		username.sendKeys(uid);	
	}	
	
	//verify Password field with correct Password
	public void type_password(String pw) 
	{		
		password.sendKeys(pw);
	}	
	
	//verify Login button
	public void click_login() 
	{		
		login.click();
	}
}	


