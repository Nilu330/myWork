package ces_testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ces_page_objects.Create_Sales_Order;

public class CES_Main {
	
	WebDriver driver;
	
	//launch the browser
	@BeforeTest
	public void load_browser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\eclipse\\Webdriver for chrome\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//get the application
		driver.get("https://almat7e310a1ee5c87584aos.cloudax.dynamics.com");
		
		//Microsoft login
		driver.findElement(By.id("i0116")).sendKeys("18221101@student.agi.ac.nz");
		Thread.sleep(1000);
		driver.findElement(By.id("idSIButton9")).click();
		driver.findElement(By.id("i0118")).sendKeys("Indika19");
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		driver.findElement(By.xpath("//input[@value='Yes']")).click();
	}
	
	//create sales order
		@Test
		public void create_sales_order() throws InterruptedException  
		{
			
			Create_Sales_Order s_order=new Create_Sales_Order(driver);
			s_order.click_navigation_pane();
			Thread.sleep(1000);
			s_order.click_account_receivable();
			s_order.click_all_sales_orders();
			s_order.click_new_order();
			s_order.select_customer_account("US-013");
			Thread.sleep(1000);
			s_order.type_order_type("FAX");
			s_order.type_supplier_ref("000123");
			s_order.type_customer_ref("111123");
			s_order.click_ok();
			
			//add first item
			s_order.type_item_number("D0007");
			Thread.sleep(1000);
			s_order.type_quantity("2");
			Thread.sleep(1000);
			s_order.type_unit("pr");
			Thread.sleep(1000);
			s_order.type_manual_discount("5.00");
			s_order.select_manual_disc_reason("@ALM:Claim");
			
			//add second item
			s_order.click_add_line();
			Thread.sleep(1000);
			s_order.type_item_number("D0006");
			Thread.sleep(1000);
			s_order.type_quantity("3");
			Thread.sleep(1000);
			s_order.type_manual_discount("10.00");
			s_order.select_manual_disc_reason("@ALM:Claim");
			
			//select Sales Taker
			s_order.click_header();
			s_order.select_sales_taker("Charlie Carson");
			
			//validate and update
			s_order.click_lines();
			Thread.sleep(2000);
			s_order.click_validate_update();
			
			//assertion
			s_order.assertion();
			
			//Sign out
			s_order.signout();			
						
			//browser quit
			driver.quit();
					
		}		

}
