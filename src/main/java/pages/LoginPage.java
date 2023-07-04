package pages;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
public WebDriver driver;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// ***************************   HomePage Sign In Button *************************
	@FindBy(xpath = "//a[contains(text(),' Sign in / Sign up ')]")
	private WebElement signIn_btn;

	public WebElement getSignIn_btn() {
		return signIn_btn;
	}
	public void setSignIn_btn(WebElement signIn_btn) {
		this.signIn_btn = signIn_btn;
	}
	
	
	// ***************************** Enter Mobile Number Text Box *****************
	
	@FindBy(id = "loginfirst_mobileno")
	private WebElement MobileNumber;

	public WebElement getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(WebElement mobileNumber) {
		MobileNumber = mobileNumber;
	}
	
	// ***************************  Click on OTP button ****************************
	
	@FindBy(xpath = "//button[contains(text(),'USE OTP')]")
	private WebElement Otp;

	public WebElement getOtp() {
		return Otp;
	}
	public void setOtp(WebElement otp) {
		Otp = otp;
	}
	
	// ************************ Otp Verify Button *********************
	
	@FindBy(xpath = "//button[contains(text(),'verify')]")
	private WebElement Verify;

	public WebElement getVerify() {
		return Verify;
	}
	public void setVerify(WebElement verify) {
		Verify = verify;
	}
	
	
	// ************************************ Create SSo session Failed Text ******************
	
	@FindBy(xpath = "//div[contains(text(),'creating sso session failed')]")
	private WebElement create_sso_failed;

	public WebElement getCreate_sso_failed() {
		return create_sso_failed;
	}
	public void setCreate_sso_failed(WebElement create_sso_failed) {
		this.create_sso_failed = create_sso_failed;
	}
	
	
	
	//***********************  Resent Otp Button *******************************
	
	@FindBy(id="login_resend_otp")
	private WebElement reSend_Otp;

	public WebElement getReSend_Otp() {
		return reSend_Otp;
	}
	public void setReSend_Otp(WebElement reSend_Otp) {
		this.reSend_Otp = reSend_Otp;
	}
	
	
	// ********************************** Rk already Validated Text **************************
	@FindBy(xpath = "//div[contains(text(),'rk has alredy been validated!')]")
	private WebElement rk_Validated;

	public WebElement getRk_Validated() {
		return rk_Validated;
	}
	public void setRk_Validated(WebElement rk_Validated) {
		this.rk_Validated = rk_Validated;
	}
	
	// ****************************
	
	
	public static void enterOTp(WebDriver driver) throws Throwable {
		//WebDriver driver;
		Scanner scc = new Scanner(System.in);
		Thread.sleep(10000);
	   // for (int i = 1; i <=6; i++) {
	    	System.out.println("Enter Otp");
	    	Thread.sleep(3000);
	    	    String otp = scc.nextLine();  // Read user input
	    	  //  int aa = Integer.parseInt(otp);
	    	  int ab = otp.length();
	    	  
	    	  for (int j = 0; j <ab; j++) {
	    		  
	    		  char ac = otp.charAt(j);
	    		  String str = String.valueOf(ac);
	    		  Thread.sleep(3000);
	    		  System.out.println("Otp is: " +str);
		    	    driver.findElement(By.xpath("(//input[@type='tel'])["+(j+4)+"]")).sendKeys(str);
				
			}
	    	    
	    	   // System.out.println("Otp is: " + otp);  // Output user input
	    	  
			
		

	}
}
