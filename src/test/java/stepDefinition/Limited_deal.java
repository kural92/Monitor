package stepDefinition;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
	public void check_and_clear_the_cart() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Go to homepage and check for limited time deal")
	public void go_to_homepage_and_check_for_limited_time_deal() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Click on view all and add the product into the cart")
	public void click_on_view_all_and_add_the_product_into_the_cart() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Check schedule doctor options and proceed the order")
	public void check_schedule_doctor_options_and_proceed_the_order() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Click on select address and Pay button")
	public void click_on_select_address_and_pay_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Verify the payment page was landed successfully and place the order")
	public void verify_the_payment_page_was_landed_successfully_and_place_the_order() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


	
	public void paymentFailure_Pop_up() throws Throwable {
		
		
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
	
	
	// 	public void waitForElement(WebElement element) {
	
	WebDriverWait waitt = new WebDriverWait(driver, Duration.ofSeconds(30) );
	waitt.until(ExpectedConditions.visibilityOf(element));
	
}
	
	
	

}
