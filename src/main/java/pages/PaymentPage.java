package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

public class PaymentPage extends BaseClass{
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}

	//Jio Payment Page 
	@FindBy(xpath="//p[contains(text(),'Payments')]")
	private WebElement jio_payments_text;

	public WebElement getJio_payments_text() {
		return jio_payments_text;
	}
	
	
	
	///Credit card option
	
	@FindBy(id="2")
	private WebElement jio_creditCard_option;

	public WebElement getJio_creditCard_option() {
		return jio_creditCard_option;
	}
	
	
	//Credit card details open button
	
	@FindBy(xpath="//p[contains(text(),'CREDIT / DEBIT / ATM CARD')]")
	private WebElement jio_card_Details_Open_btn;
	public WebElement getJio_card_Details_Open_btn() {
		return jio_card_Details_Open_btn;
	}
	
	
	// Card number
	
	@FindBy(id="cardNumber")
	private WebElement jio_cardNumber;

	public WebElement getJio_cardNumber() {
		return jio_cardNumber;
	}	
	
	
	//Expiry date MM
	@FindBy(xpath="//p[contains(text(),'MM')]")
	private WebElement jio_month_button;

	public WebElement getJio_month_button() {
		return jio_month_button;
	}
	
	
	// Month Details
	@FindBy(xpath="//p[contains(text(),'08 - August')]")
	private WebElement jio_month_option;
	
	
	public WebElement getJio_month_option() {
		return jio_month_option;
	}

	//Expiry year
	@FindBy(xpath="//p[contains(text(),'YYYY')]")
	private WebElement jio_year_button;

	public WebElement getJio_year_button() {
		return jio_year_button;
	}
	

	
	// Year options
	@FindBy(xpath="//p[contains(text(),'2027')]")
	private WebElement jio_year_options;

	public WebElement getJio_year_options() {
		return jio_year_options;
	}
	
	
	
	// Cvv number
	
	@FindBy(id="cvvNumber")
	private WebElement jio_cvv_number;

	public WebElement getJio_cvv_number() {
		return jio_cvv_number;
	}
	
	
	// name on card
	
	@FindBy(id="cardHolderName")
	private WebElement Jio_nameOnCard;

	public WebElement getJio_nameOnCard() {
		return Jio_nameOnCard;
	}
	
	
	// Pay button   (//button[contains(text(),'Pay')])[4]
	@FindBy(xpath="//button[contains(text(),'Pay ₹')]")
	private WebElement Jio_Paybutton;

	public WebElement getJio_Paybutton() {
		return Jio_Paybutton;
	}
	
	@FindBy(xpath="//p[contains(text(),'Skip for now')]")
	private WebElement jio_Pay_skipButton;

	public WebElement getJio_Pay_skipButton() {
		return jio_Pay_skipButton;
	}
	
	
	
}



