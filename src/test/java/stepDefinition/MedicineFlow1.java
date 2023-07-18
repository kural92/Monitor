package stepDefinition;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.OrderReviewPage;
import pages.SearchResultPage;

public class MedicineFlow1 extends BaseClass {

	@Given("Check Already Logged in Browser was Opened")
	public void check_already_logged_in_browser_was_opened() throws Throwable {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		ChromeOptions option = new ChromeOptions();
		
		option.setExperimentalOption("debuggerAddress", "localhost:9988");
		option.addArguments("--disable-notifications");
		option.addArguments("--remote-allow-origins=*");
		
		driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		
		  driver.get("https://www.netmeds.com");
		  
		  
		  String user = driver.findElement(By.id("logged_user")).getText();
		  System.out.println("The Logged User was : "+user);
		  System.err.println("The Already logged browser was opened successfuly ");
		  
		  Thread.sleep(1000);
			try {
				driver.switchTo().frame(1);
				driver.findElement(By.xpath("//i[@class='we_close']")).click();
				driver.switchTo().defaultContent();
			} catch (Exception e) {
				
				driver.switchTo().defaultContent();
			}
	}

	@When("Clear the Cart and  Search the Product")
	public void clear_the_cart_and_search_the_product() throws Throwable {
	
		CartPage cartPage = new CartPage(driver);
		Actions acc = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Thread.sleep(3000);
		
		
		// Clear Cart
		
		driver.navigate().to("https://www.netmeds.com/checkout/cart");	
		Thread.sleep(3000);
			if (!(cartPage.getRemove_Icon_List().size()==0)) {	
				int a = cartPage.getRemove_Icon_List().size();
				for (int i = 0; i < a; i++) {
					if (a!=0) {
						Thread.sleep(1000);
						cartPage.getRemove_Icon().click();			
						Thread.sleep(1000);
						cartPage.getRemove_btn().click();	
					} else {
		break;
					}		
				}	
			} else {
		System.out.println("There is no product in cart to clear");
			}
			
			
			//Search the Product
			
			SearchResultPage searchResultPage = new SearchResultPage(driver);
			driver.navigate().to("https://www.netmeds.com/");
			searchResultPage.getSearchBox().click();
			searchResultPage.getSearchBox().sendKeys("Rxtor");
			searchResultPage.getSearchBox().sendKeys(Keys.ENTER);

			
		
		
		
	}

	@When("click on Add to the cart and add the product")
	public void click_on_add_to_the_cart_and_add_the_product() throws Throwable {
		CartPage cartPage = new CartPage(driver);
		Actions acc = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		
		Thread.sleep(1000);
		
		
		js.executeScript("window.scrollBy(0,200)");
	
		//Thread.sleep(2000);
		waitForElement(searchResultPage.getAddToCart());
		searchResultPage.getAddToCart().click();
		Thread.sleep(3000);
		try {
			driver.findElement(By.id("mBtn1")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Thread.sleep(1000);
		
	}

	@When("Click on cart page proceed the Product to Order Page")
	public void click_on_cart_page_proceed_the_product_to_order_page() throws Throwable {
	    
		CartPage cartPage= new CartPage(driver);
		OrderReviewPage orderReviewPage = new OrderReviewPage(driver);
		
		Thread.sleep(3000);
		try {////div[@class='close tablecell']
			driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		//	if (!(driver.findElements(By.xpath("//button[contains(text(),'Try Again')]")).size()==0)) {
				driver.findElement(By.xpath("//i[@class='we_close']|//div[@class='close tablecell']")).click();
				driver.switchTo().defaultContent();
		//	} else {}
			
		
		} catch (Exception e) {
			driver.switchTo().defaultContent();
		}
		
	//	Thread.sleep(1000);
		waitForElement(cartPage.getCart_btn());
		cartPage.getCart_btn().click();
		
//	Thread.sleep(3000);
		waitForElement(cartPage.getCart_proceedBtn());
		cartPage.getCart_proceedBtn().click();
		Thread.sleep(1000);
		
//		try {
//			driver.switchTo().frame(1);
//			//if (!(driver.findElements(By.xpath("//div[@class='close tablecell']")).size()==0)) {
//			Thread.sleep(3000);
//					driver.findElement(By.xpath("//div[@class='close tablecell']")).click();
//		//	} else {}
//					driver.switchTo().defaultContent();
//		
//		} catch (Exception e) {
//			driver.switchTo().defaultContent();
//		}
		
		
		
		
		//////////   
		
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("(//input[@id='externaldoctr'])[2]")).isSelected()) {
			
			System.err.println("The Schedule Doctor was Already selected");
			
		}else {
			driver.findElement(By.xpath("(//input[@id='externaldoctr'])[2]")).click();
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Review Order')]")).click();
//		Thread.sleep(3000);
//		try {if (!(driver.findElements(By.xpath("//div[@class='close tablecell']")).size()==0)) {
//			
//			driver.switchTo().frame(1);
//			Actions acc = new Actions(driver);
//			acc.moveToElement(driver.findElement(By.xpath("(//button[@class='close'])[4]"))).perform();
//			driver.findElement(By.xpath("(//button[@class='close'])[4]")).click();
//			driver.switchTo().defaultContent();
//		}else {}
//		}catch (Exception e) {
//			driver.switchTo().defaultContent();
//		}
		
	}

	@Then("From Order page choose delivery adress and click on Pay")
	public void from_order_page_choose_delivery_adress_and_click_on_pay() throws Throwable {
		
		OrderReviewPage orderReviewPage = new OrderReviewPage(driver);
	try {	
		Thread.sleep(3000);
		
		if (!(orderReviewPage.getSelect_Address_List().size()==0)) {
			Thread.sleep(1000);
			orderReviewPage.getSelect_Address().click();
			Thread.sleep(1000);
			Actions acc = new Actions(driver);
			Thread.sleep(1000);
			acc.moveToElement(orderReviewPage.getAddress_checkbox()).click().perform();
			Thread.sleep(1000);
		} else {
	System.err.println("The Address was already selected");
		}
	}catch (Exception e) {
		// TODO: handle exception
	}
//	Thread.sleep(3000);
//	try {
//		driver.switchTo().frame(1);
//		Actions acc = new Actions(driver);
//		acc.moveToElement(driver.findElement(By.xpath("(//button[@class='close'])[4]"))).perform();
//		driver.findElement(By.xpath("(//button[@class='close'])[4]")).click();
//		driver.switchTo().defaultContent();
//	}catch (Exception e) {
//		driver.switchTo().defaultContent();
//
//	}
	
	//	Thread.sleep(3000);
	waitForElement(orderReviewPage.getPay_btn());
		orderReviewPage.getPay_btn().click();
		Thread.sleep(3000);
	
	}

	@Then("check Payment page was landed")
	public void check_payment_page_was_landed() throws Throwable {
		
		 if (driver.findElement(By.xpath("//span[contains(text(),'Payment Details')]")).isDisplayed()) {
			  
			  String pay = driver.findElement(By.xpath("//span[contains(text(),'Payment Details')]")).getText();
			   if (pay.equalsIgnoreCase("Payment Details")) {
				System.out.println("The Payment Page was landed Successfully");
			} else {
				System.err.println("The Payment Page was not landed");
			}
			
		} else {}
		  //driver.findElement(By.xpath("//p[contains(text(),'Payments')]")).click();
		  Thread.sleep(3000);
		//  driver.get("https://www.netmeds.com");
		
	}

	@Then("Verify the payment status of the order")
	public void verify_the_payment_status_of_the_order() throws Throwable {
	  Actions acc = new Actions(driver);
	  JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//	Thread.sleep(3000);
		waitForElement(driver.findElement(By.id("nms_paytm")));
		driver.findElement(By.id("nms_paytm")).click();
		
		//Thread.sleep(3000);
		waitForElement(driver.findElement(By.xpath("//button[@class='process-orderplace']")));
		driver.findElement(By.xpath("//button[@class='process-orderplace']")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		driver.navigate().back();
		Thread.sleep(3000);
		String ff = driver.findElement(By.xpath("//h5[contains(text(),'Transaction Failed')]")).getText();
		Thread.sleep(3000);
		if (ff.contains("Transaction Failed")) {
			
			System.out.println("The Payment Status : "+ ff);
			
		} else {}
		
		
		/*		
			js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		driver.findElement(By.id("newcardlink")).click();
		Thread.sleep(1000);
		driver.switchTo().frame(1);
		Thread.sleep(2000);
		acc.moveToElement(driver.findElement(By.id("card_number"))).click().perform();
		driver.findElement(By.id("card_number")).sendKeys("4111111111111111");
	//	driver.switchTo().defaultContent();
	//   --->	driver.switchTo().frame(2);
//	driver.switchTo().frame("//iframe[@class='card_exp_month_iframe']");//frame("//iframe[@class='card_exp_month_iframe']");
		Thread.sleep(2000);
		driver.findElement(By.id("card_exp_month")).click();
		driver.findElement(By.id("card_exp_month")).sendKeys("12");
	//	driver.switchTo().defaultContent();
		driver.switchTo().frame(3);
	//	driver.switchTo().frame("//iframe[@class='card_exp_year_iframe']");//frame("//iframe[@class='card_exp_year_iframe']");
		Thread.sleep(2000);
		driver.findElement(By.id("card_exp_year")).click();
		driver.findElement(By.id("card_exp_year")).sendKeys("27");
	//	driver.switchTo().defaultContent();
	driver.switchTo().frame(4);	
	//	driver.switchTo().frame("//iframe[@class='security_code_iframe']");//frame("//iframe[@class='security_code_iframe']");
		Thread.sleep(2000);
		driver.findElement(By.id("security_code")).click();
		driver.findElement(By.id("security_code")).sendKeys("411");
	//	driver.switchTo().defaultContent();
	driver.switchTo().frame(5);
		//	driver.switchTo().frame("name_on_card_iframe_xvewG6ohcY4Pdhpg");
		Thread.sleep(2000);
		driver.findElement(By.id("name_on_card")).click();
		driver.findElement(By.id("name_on_card")).sendKeys("Netmeds.com Test");
		
		driver.findElement(By.xpath("(//button[@type='submit'])[5]")).click();
		
	*/
		
		Thread.sleep(15000);
		String fail = driver.findElement(By.xpath("//h5[contains(text(),'Transaction Failed')]")).getText();
		System.err.println("The Transaction status was : "+fail);
	

		
		
	}
	
	
	public void waitForElement(WebElement element) {
		
		WebDriverWait waitt = new WebDriverWait(driver, Duration.ofSeconds(30) );
		waitt.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	
	
	
	
}
