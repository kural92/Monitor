package stepDefinition;

import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.Chromaticity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test {
	
	WebDriver driver;
	
	
	@Given("Enter the Url")
	public void enter_the_url() {
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		ChromeOptions option = new ChromeOptions();
		
		option.setExperimentalOption("debuggerAddress", "localhost:9988");
		option.addArguments("--disable-notifications");
		option.addArguments("--remote-allow-origins=*");
		
		driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	   
	}

	@When("Enter the login details")
	public void enter_the_login_details() {
	  
		driver.get("https://www.netmeds.com");
		
	}

	@Then("Verify the login")
	public void verify_the_login() {
		
		driver.manage().window().maximize();

	}

}
