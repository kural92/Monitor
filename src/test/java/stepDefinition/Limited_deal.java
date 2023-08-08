package stepDefinition;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import pages.OrderReviewPage;
import pages.SearchResultPage;

public class Limited_deal extends BaseClass{
	
	
	@Given("Check and verify already logged in browser was opened successfully")
	public void check_and_verify_already_logged_in_browser_was_opened_successfully() throws Throwable {
	   
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
		  
		  Thread.sleep(3000);
		  paymentFailure_Pop_up();
		
		  
		  
	}

	@Given("Check and clear the cart")
	public void check_and_clear_the_cart() throws Throwable {
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
					
	}

	@When("Go to homepage and check for limited time deal")
	public void go_to_homepage_and_check_for_limited_time_deal() throws Throwable {

		SearchResultPage searchResultPage = new SearchResultPage(driver);
		HomePage homePage = new HomePage(driver);
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		driver.navigate().to("https://www.netmeds.com/");
		
		for (int i = 0; i < 5; i++) {
			if (driver.findElements(By.xpath("//h2[contains(text(),' Limited Time Deals ')]")).size()==0) {		
				js.executeScript("window.scrollBy(0,300)");
				Thread.sleep(3000);			
			} else {
				break;
			}	
		}
		
		
		
		
		
		
		
	}

	@When("Click on view all and add the product into the cart")
	public void click_on_view_all_and_add_the_product_into_the_cart() throws Throwable {
	  
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		HomePage homePage = new HomePage(driver);
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		
		waitForElement(homePage.getLmd_ViewAll());
		homePage.getLmd_ViewAll().click();
		
		waitForElement(homePage.getLmd_Add_to_cart());
		homePage.getLmd_Add_to_cart().click();
		
paymentFailure_Pop_up();
		
		
		
		
	}

	@When("Check schedule doctor options and proceed the order")
	public void check_schedule_doctor_options_and_proceed_the_order() throws Throwable {
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		HomePage homePage = new HomePage(driver);
		CartPage cartPage= new CartPage(driver);
		OrderReviewPage orderReviewPage = new OrderReviewPage(driver);
		
	
		Thread.sleep(1000);
		try {
	waitForElement(cartPage.getCart_btn());
	cartPage.getCart_btn().click();
		}catch (Exception e) {
		driver.navigate().to("https://www.netmeds.com/checkout/cart");
		}
		
		Thread.sleep(3000);
		waitForElement(cartPage.getCart_proceedBtn());
		cartPage.getCart_proceedBtn().click();
		Thread.sleep(1000);
		
		
		//driver.navigate().to("https://www.netmeds.com/checkout/upload-rx");

		try {
			Thread.sleep(2000);
			waitForElement(driver.findElement(By.xpath("(//input[@id='externaldoctr'])[2]")));
			if (driver.findElement(By.xpath("(//input[@id='externaldoctr'])[2]")).isSelected()) {
				
				System.err.println("The Schedule Doctor was Already selected");
				
			}else {
				driver.findElement(By.xpath("(//input[@id='externaldoctr'])[2]")).click();
			}
			Thread.sleep(2000);
			waitForElement(driver.findElement(By.xpath("//button[contains(text(),'Review Order')]")));
			driver.findElement(By.xpath("//button[contains(text(),'Review Order')]")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		//////
		
		
		
	}

	@Then("Click on select address and Pay button")
	public void click_on_select_address_and_pay_button() throws Throwable {
	   
		

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
	Thread.sleep(1000);
		}
	}catch (Exception e) {
		Thread.sleep(1000);
		// TODO: handle exception
	}
	Actions acc = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,200)");
	
		Thread.sleep(3000);
	waitForElement(orderReviewPage.getPay_btn());
	acc.moveToElement(orderReviewPage.getPay_btn()).build().perform();
		orderReviewPage.getPay_btn().click();
		try {
			orderReviewPage.getPay_btn().click();
		}catch (Exception e)  {
			System.err.println("Unalble to click the Pay Button");
		}
		Thread.sleep(3000);
		
	}

	@Then("Verify the payment page was landed successfully and place the order")
	public void verify_the_payment_page_was_landed_successfully_and_place_the_order() throws InterruptedException {
		waitForElement(driver.findElement(By.xpath("//span[contains(text(),'Payment Details')]")));
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
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  Actions acc = new Actions(driver);
		  js.executeScript("window.scrollBy(0,200)");
			Thread.sleep(1000);
			driver.findElement(By.id("newcardlink")).click();
			Thread.sleep(1000);
			 int countIframesInPage = driver.findElements(By.tagName("iframe")).size();
	         System.out.println("Number of Frames on a Page:" + countIframesInPage);
			driver.switchTo().frame(1);
			Thread.sleep(2000);
			acc.moveToElement(driver.findElement(By.id("card_number"))).click().perform();
			driver.findElement(By.id("card_number")).sendKeys("4111111111111111");
		driver.switchTo().defaultContent();
//		driver.switchTo().frame(0);
//		driver.switchTo().frame("//iframe[@class='card_exp_month_iframe']");//frame("//iframe[@class='card_exp_month_iframe']");
			Thread.sleep(2000);
			driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@frameborder=0])[2]")));
			driver.findElement(By.id("card_exp_month")).click();
			driver.findElement(By.id("card_exp_month")).sendKeys("12");
		//	driver.switchTo().defaultContent();
//			driver.switchTo().frame(1);
		//	driver.switchTo().frame("//iframe[@class='card_exp_year_iframe']");//frame("//iframe[@class='card_exp_year_iframe']");
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@frameborder=0])[3]")));
			Thread.sleep(2000);
			driver.findElement(By.id("card_exp_year")).click();
			driver.findElement(By.id("card_exp_year")).sendKeys("27");
		//	driver.switchTo().defaultContent();
//		driver.switchTo().frame(2);	
		//	driver.switchTo().frame("//iframe[@class='security_code_iframe']");//frame("//iframe[@class='security_code_iframe']");
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@frameborder=0])[4]")));
			Thread.sleep(2000);
			driver.findElement(By.id("security_code")).click();
			driver.findElement(By.id("security_code")).sendKeys("411");
			driver.switchTo().defaultContent();
		//driver.switchTo().frame(5);
			//	driver.switchTo().frame("name_on_card_iframe_xvewG6ohcY4Pdhpg");
			Thread.sleep(2000);
			driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@frameborder=0])[5]")));
			Thread.sleep(2000);
			driver.findElement(By.id("name_on_card")).click();
			driver.findElement(By.id("name_on_card")).sendKeys("Netmeds.com Test");
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("(//button[@type='submit'])[5]")).click();
			
		//*/
			waitForElement(driver.findElement(By.xpath("//h5[contains(text(),'Transaction Failed')]")));
			//Thread.sleep(15000);
			String fail = driver.findElement(By.xpath("//h5[contains(text(),'Transaction Failed')]")).getText();
			System.err.println("The Transaction status was : "+fail);
		

		  
	}


	
	public void paymentFailure_Pop_up() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Actions acc =  new Actions(driver);
		
		 Thread.sleep(3000);
			try {
				driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
				System.err.println("Switched to frame");
				driver.findElement(By.xpath("//i[@class='we_close']|/html/body/div/div/div[1]/div/div[4]")).click();
				driver.switchTo().defaultContent();
				System.err.println("Switched out of frame");
			} catch (Exception e) {
				
				driver.switchTo().defaultContent();
				System.err.println("Switched out of frame 11");
			}

			
			
			
			
	}
	
	
	// 	
	public void waitForElement(WebElement element) {
	
	WebDriverWait waitt = new WebDriverWait(driver, Duration.ofSeconds(30) );
	waitt.until(ExpectedConditions.visibilityOf(element));
	
}
	
	
	

}
