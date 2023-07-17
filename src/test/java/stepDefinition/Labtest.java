package stepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import pages.LabTest;
import pages.LoginPage;
import pages.OrderReviewPage;
import pages.PaymentPage;
import pages.ProductPage;
import pages.SearchResultPage;

public class Labtest extends BaseClass{
	
	
	LoginPage loginPage;
    HomePage homePage;
    SearchResultPage searchResultPage;
    CartPage cartPage;
    OrderReviewPage orderReviewPage;
    ProductPage productPage;
    PaymentPage paymentPage;
    LabTest labTest;
  

@Given("Check Already logged in Browser was Opened Click on Labtest button")
public void check_already_logged_in_browser_was_opened_click_on_labtest_button() throws Throwable {
	
	LabTest labTest = new LabTest(driver);
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 Actions acc = new Actions(driver);
	
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
		
		

	
	 
	 Thread.sleep(3000);
	 acc.moveToElement(labTest.getLabTest_btn()).build().perform();
		labTest.getLabTest_btn().click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,250)");
      
}

@When("Check page was landed successfully and check popular test package and top category package")
public void check_page_was_landed_successfully_and_check_popular_test_package_and_top_category_package() throws Throwable {
	
	
	 LabTest labTest = new LabTest(driver);
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 Actions acc = new Actions(driver);
	
	String popt = labTest.getPopularTest().getTagName();
	System.out.println(popt);
	if (popt.equalsIgnoreCase("Popular Tests")) {
		System.out.println("The Lab Test Page was Landed Successfully ");
	} else {
		
	}
	System.out.println(labTest.getPopularTest_text().getText());
	
	List<WebElement> popn =labTest.getPopularTest_Names();
	int a = popn.size();
	
	for (int i = 0; i <a; i++) {
		
		System.err.println(popn.get(i).getText());
	}
	
	
	js.executeScript("window.scrollBy(0,250)");
	
	List<WebElement> topsell =labTest.getTop_selling_Pack_Name();
	int aa = topsell.size();
	
	for (int i = 0; i <aa; i++) {
		
		System.out.println(topsell.get(i).getText());
	}
	
	Thread.sleep(3000);
	labTest.getTop_Selling_pack_BookNow().click();
	
  
}

@When("Check all text fields was enabled and Click on Pathology")
public void check_all_text_fields_was_enabled_and_click_on_pathology() {
	LabTest labTest = new LabTest(driver);
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 Actions acc = new Actions(driver);
	 
	 js.executeScript("window.scrollBy(350,0)");
	
	
	 
 
}

@Then("Click on Pathology and enter the required details Amudhan N,{int} and {int}")
public void click_on_pathology_and_enter_the_required_details_amudhan_n_and(Integer int1, Integer int2) {
	LabTest labTest = new LabTest(driver);
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 Actions acc = new Actions(driver);
	 
	 
	 labTest.getLabTest_Name().sendKeys("Amudhan N");

	 labTest.getLabTest_MobileNum().sendKeys("8000000000");
	 
	 labTest.getLabTest_pinCode().sendKeys("600100");
	
	 
}

@Then("Choose package and choose test click on book now and verify the Booking content")
public void choose_package_and_choose_test_click_on_book_now_and_verify_the_booking_content() {
	LabTest labTest = new LabTest(driver);
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 Actions acc = new Actions(driver);
	 
	 Select ss = new Select(labTest.getLabTest_ChoosePackage());
	 ss.selectByIndex(5);
	 
	 Select ss1 = new Select(labTest.getLabTest_ChooseTest());
	 ss1.selectByIndex(12);
	 
	 labTest.getLabTest_Terms().click();
	 
	 labTest.getLapTest_BookNow().click();
	
	
	//span[@class='reg_success']
	String ref_success = driver.findElement(By.xpath("//div[@class='thank-you']")).getText();
	System.err.println(ref_success);
	
	String aa =  driver.findElement(By.xpath("//span[contains(text(),'Thank you for sharing your details')]")).getText();
	System.out.println(aa);
	
}



}
