package stepDefinition;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseClass;
import Page_Manager.PageObjectManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderReviewPage;
import pages.PaymentPage;
import pages.ProductPage;
import pages.SearchResultPage;

public class MedicineFlow2 extends BaseClass{
	
	
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	CartPage cartPage;
	OrderReviewPage orderReviewPage;
	ProductPage productPage;
	PaymentPage paymentPage;
	PageObjectManager pom;
	//ConfigFileReader configFileReader;
	

@Given("Check the Browser was already logged in")
public void check_the_browser_was_already_logged_in() throws Throwable {
	
	
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

@Given("clear the cart")
public void clear_the_cart() throws Throwable {
  
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

@When("click on Upload and Upload Prescription")
public void click_on_upload_and_upload_prescription() throws Throwable {
  
	driver.navigate().to("https://www.netmeds.com/");
	pom = new PageObjectManager(driver);
	homePage=pom.getHomePage();
//	HomePage homePage = 
	Thread.sleep(2000);
	homePage.getUpload_btn().click();
	Thread.sleep(2000);
	homePage.getUpload_Prescription_btn().sendKeys("C:\\Users\\Netmeds\\eclipse-workspace\\Monitor\\Prescription\\APIS.png");

	
}

@When("Click on search Medicine,search and Add medicine")
public void click_on_search_medicine_search_and_add_medicine() throws Throwable {
 
	pom=new PageObjectManager(driver);
	homePage=pom.getHomePage();
	if (!(homePage.getSearch_Add_Medicine().isSelected())) {
		homePage.getSearch_Add_Medicine().click();
	} else {
	}

	Thread.sleep(2000);
	waitForElement(homePage.getUpload_Continue_btn());
	homePage.getUpload_Continue_btn().click();
	Thread.sleep(2000);
	homePage.getM2_Search_TextBox().sendKeys("Rxtor");
	Thread.sleep(2000);
	homePage.getM2_Add_to_cart().click();
	Thread.sleep(2000);
	homePage.getM2_proceed_to_cart_popUP().click();
	Thread.sleep(2000);
	try {
		homePage.getM2_proceed_to_cart().click();
	} catch (Exception e) {
		
	}
	
}

@Then("Click on proceed and place the order")
public void click_on_proceed_and_place_the_order() throws Throwable {
   
	pom=new PageObjectManager(driver);
	homePage=pom.getHomePage();
	orderReviewPage=pom.getOrderReviewPage();
	Thread.sleep(1000);
	try {
	homePage.getM2_proceed_to_cart().click();
	
	}catch (Exception e) {
		
	}
	try {
		Thread.sleep(1000);
		homePage.getM2_proceed_to_cart().click();
	} catch (Exception e) {
		
	}
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

	Thread.sleep(2000);
	orderReviewPage.getConfirm_Order().click();
	//driver.findElement(By.xpath("//button[contains(text(),'Confirm Order')]")).click();

	
}

@Then("Track the order and cancel the order")
public void track_the_order_and_cancel_the_order() throws InterruptedException {
    
	Thread.sleep(2000);
	OrderReviewPage orderReviewPage = new OrderReviewPage(driver);
	orderReviewPage.getOrderPage_Track_Orderbtn().click();
	Thread.sleep(2000);
	orderReviewPage.getTrackOrder().click();
	Thread.sleep(2000);
	orderReviewPage.getCancel_order().click();
	Thread.sleep(2000);
	orderReviewPage.getCancel_reason().click();
	Thread.sleep(2000);
	orderReviewPage.getSubmit_Cancel().click();
	Thread.sleep(2000);
	if (driver.findElement(By.xpath("//span[contains(text(),'Cancelled ')]")).getText().contains("Cancelled ")) {
		System.err.println("Order cancelled Successfully");
	} else {

	}
	
}

@When("Click on Get call from Netmeds and continue")
public void click_on_get_call_from_netmeds_and_continue() throws Throwable {
	driver.navigate().to("https://www.netmeds.com/");
	HomePage homePage = new HomePage(driver);
	homePage.getUpload_btn().click();
	homePage.getUpload_Prescription_btn().sendKeys("C:\\Users\\Netmeds\\eclipse-workspace\\Monitor\\Prescription\\APIS.png");

	if (!(homePage.getGet_Call_from_netmeds().isSelected())) {

		homePage.getGet_Call_from_netmeds().click();
	} else {
	}

	Thread.sleep(3000);
	homePage.getUpload_Continue_btn().click();
	Thread.sleep(2000);
}

@Then("Click on confirm and Place the Order")
public void click_on_confirm_and_place_the_order() throws InterruptedException {
	OrderReviewPage orderReviewPage = new OrderReviewPage(driver);
	Thread.sleep(2000);
	if (!(orderReviewPage.getSelect_Address_List().size() == 0)) {
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

	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[contains(text(),'Confirm Order')]")).click();

}

@When("click on Upload and Saved Prescription")
public void click_on_upload_and_saved_prescription() throws Throwable {
	HomePage homePage = new HomePage(driver);
	homePage.getUpload_btn().click();
	homePage.getSaved_Prescription().click();
	try {
		homePage.getSaved_Prescription_Radio_btnl().click();
	} catch (Exception e) {
Thread.sleep(3000);
		Actions acc = new Actions(driver);
		acc.moveToElement(homePage.getSaved_Prescription_Radio_btnl()).click().perform();

	} //

	try {
		homePage.getSaved_prescription_close().click();
	} catch (Exception e) {

		Actions acc = new Actions(driver);
		acc.moveToElement(homePage.getSaved_prescription_close()).click().perform();

	}


}

public void waitForElement(WebElement element) {
	
	WebDriverWait waitt = new WebDriverWait(driver, Duration.ofSeconds(30) );
	waitt.until(ExpectedConditions.visibilityOf(element));
	
}


}
