package ces_page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class Create_Sales_Order {
		
	WebDriver driver;
	
	//WebElement repository
	@FindBy(how=How.CLASS_NAME,using="modulesPane-opener")
	WebElement navigation_pane;
	@FindBy(how=How.XPATH,using="//a[text()=\"Accounts receivable\"]")
	WebElement account_receivable;
	@FindBy(how=How.XPATH,using="//a[@data-dyn-title=\"All sales orders\"]")
	WebElement all_sales_orders;
	@FindBy(how=How.XPATH,using="//span[text()=\"New\"]")
	WebElement new_order;
	@FindBy(how=How.XPATH,using="//div[@id=\"SalesCreateOrder_5_groupCustomer\"]/div/div/div/div")
	WebElement customer_account;
	@FindBy(how=How.XPATH,using="//input[@name=\"SalesTable_SalesOriginId\"]")
	WebElement order_type_drop_down;
	@FindBy(how=How.XPATH,using="//input[@name=\"SalesTable_ALM_SupplierReference\"]")
	WebElement supplier_ref;
	@FindBy(how=How.XPATH,using="//input[@name=\"SalesTable_CustomerRef\"]")
	WebElement customer_ref;
	@FindBy(how=How.XPATH,using="//button[@name=\"OK\"]/div")
	WebElement ok;
	@FindBy(how=How.XPATH,using="//input[@name=\"SalesLine_ItemId\"][@tabindex=\"0\"]")
	WebElement item_number;
	@FindBy(how=How.XPATH,using="//input[@name=\"SalesLine_SalesQty\"][@tabindex=\"0\"]")
	WebElement quantity;
	@FindBy(how=How.XPATH,using="//input[@name=\"SalesLine_SalesUnit\"][@tabindex=\"0\"]")
	WebElement unit;
	@FindBy(how=How.XPATH,using="//input[@name=\"SalesLine_ALM_ManualDiscAmt\"][@tabindex=\"0\"]")
	WebElement manual_discount;	
	@FindBy(how=How.XPATH,using="//input[@name=\"SalesLine_ALM_BonusReasonCode\"][@tabindex=\"0\"]")
	WebElement manual_disc_reason;
	@FindBy(how=How.XPATH,using="//span[text()=\"Add line\"]")
	WebElement add_line;
	@FindBy(how=How.XPATH,using="//span[text()=\"Header\"]")
	WebElement header;
	@FindBy(how=How.XPATH,using="//input[@name=\"Administration_WorkerSalesTaker_DirPerson_FK_Name\"]")
	WebElement sales_taker;
	@FindBy(how=How.XPATH,using="//span[text()=\"Lines\"]")
	WebElement lines;
	@FindBy(how=How.XPATH,using="//span[text()=\"Validate and update\"]")
	WebElement validate_update;
	@FindBy(how=How.XPATH,using="//span[@class=\"titleField staticText layout-ignoreArrange fill-width\"]")
	WebElement sales_order;
	@FindBy(how=How.XPATH,using="//input[@name=\"SalesTable_SalesIdAdvanced\"][@tabindex=\"0\"]")
	WebElement sales_order_number;
	@FindBy(how=How.XPATH,using="//div[@class=\"messageBar-messageRegion\"]")
	WebElement message_bar;
	@FindBy(how=How.XPATH,using="//span[text()=\"NI\"]")
	WebElement user;
	@FindBy(how=How.XPATH,using="//span[text()=\"Sign out\"]")
	WebElement signout;
	
	
	//create constructor	
	public Create_Sales_Order(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);					
	}
	
	//click on navigation pane
	public void click_navigation_pane() {
		
		navigation_pane.click();
	}
	
	//verify account receivable link
	public void click_account_receivable() {
		
		account_receivable.click();
	}
	
	//verify all sales orders link
	public void click_all_sales_orders() {
		
		all_sales_orders.click();
	}
	
	//verify new order link
	public void click_new_order() {
		
		new_order.click();
	}
	
	//verify customer account field
	public void select_customer_account(String ca) {
		
		customer_account.click();
		customer_account.findElement(By.xpath("//input[@name=\"CustTable_AccountNum\"][@title=\'"+ca+"']")).click();		
	}
	
	//verify order type field
	public void type_order_type(String ot) {
	
		order_type_drop_down.clear();
		order_type_drop_down.sendKeys(ot);						
	}
	
	//verify supplier reference field
	public void type_supplier_ref(String sr) {
		supplier_ref.sendKeys(sr);
	}
	
	//verify customer reference field
	public void type_customer_ref(String cr) {
		customer_ref.sendKeys(cr);
	}

	//verify ok button
	public void click_ok() {
		ok.click();
	}
		
	//verify item number field
	public void type_item_number(String in) {
		item_number.sendKeys(in);
	}
	
	//verify quantity field
	public void type_quantity(CharSequence q) {
		quantity.clear();
		quantity.sendKeys(q);
	}
	
	//verify unit field
	public void type_unit(String u) {
		unit.clear();
		unit.sendKeys(u);
	}
	
	//verify manual discount field
	public void type_manual_discount(String md) {
		manual_discount.clear();
		manual_discount.sendKeys(md);
	}
	
	public void select_manual_disc_reason(String mdr) {
		manual_disc_reason.sendKeys(mdr);
	}
	
	//verify add line link
	public void click_add_line() {
		add_line.click();
	}
	
	//verify Header link
	public void click_header() {
		header.click();
	}
	
	//verify Sales Taker field
	public void select_sales_taker(String st) {
		sales_taker.clear();
		sales_taker.sendKeys(st);		
	}
	
	//verify Lines link
	public void click_lines() {
		lines.click();
	}
	
	//verify validate and update link
	public void click_validate_update() {
		validate_update.click();
		
	}
	
		
	//get order no
	public void assertion() {
		String order=sales_order.getText();
		String order_arr[]=order.split(":");
		String order_no=order_arr[0];
		Assert.assertTrue(message_bar.findElement(By.xpath("//span[text()=\"The order "+order_no+"validated sucessfully.\"]")).getText().contains(order_no));
	}
	
	//sign out
	public void signout() {
		user.click();
		signout.click();		
	}	
	
}
