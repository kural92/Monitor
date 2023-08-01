package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderReviewPage {
	
	public OrderReviewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// ******************  Select Address ************************************************
	
		@FindBy(xpath = "//a[contains(text(),'SELECT ADDRESS')]")
		private WebElement select_Address;

		public WebElement getSelect_Address() {
			return select_Address;
		}
		public void setSelect_Address(WebElement select_Address) {
			this.select_Address = select_Address;
		}
		
		
		// ******************  Select Address ************************************************
		
			@FindBy(xpath = "//a[contains(text(),'SELECT ADDRESS')]")
			private List<WebElement> select_Address_List;
			public List<WebElement> getSelect_Address_List() {
				return select_Address_List;
			}
			public void setSelect_Address_List(List<WebElement> select_Address_List) {
				this.select_Address_List = select_Address_List;
			}
			
			
		
		//********************  Address Radio Box***************************
		
		

		@FindBy(xpath = "//input[@name='customeraddress']")//(id="customeraddress_3344380")
		private WebElement Address_checkbox;

		public WebElement getAddress_checkbox() {
			return Address_checkbox;
		}
		public void setAddress_checkbox(WebElement address_checkbox) {
			Address_checkbox = address_checkbox;
		}
		
		// *************************** Pay Button ********************************
		
		@FindBy(id = "pay-button")//(id="pay-button")
		private WebElement Pay_btn;
		public WebElement getPay_btn() {
			return Pay_btn;
		}
		public void setPay_btn(WebElement pay_btn) {
			Pay_btn = pay_btn;
		}

		/////&*************** M@ Confirm Order **********************************
		
		@FindBy(xpath = "//button[contains(text(),'Confirm Order')]")
		private WebElement Confirm_Order;
		
		
		public WebElement getConfirm_Order() {
			return Confirm_Order;
		}
		public void setConfirm_Order(WebElement confirm_Order) {
			Confirm_Order = confirm_Order;
		}
		
		
		//******************************* Track order success Page
	

		@FindBy(xpath = "(//button[contains(text(),'Track Order')])[2]")
		private WebElement OrderPage_Track_Orderbtn;

		public WebElement getOrderPage_Track_Orderbtn() {
			return OrderPage_Track_Orderbtn;
		}
		public void setOrderPage_Track_Orderbtn(WebElement orderPage_Track_Orderbtn) {
			OrderPage_Track_Orderbtn = orderPage_Track_Orderbtn;
		}
		
		
		//////***************************  Track order ********************
		
		@FindBy(xpath = "//button[contains(text(),'Track Order')]")
		private WebElement TrackOrder;

		public WebElement getTrackOrder() {
			return TrackOrder;
		}
		public void setTrackOrder(WebElement trackOrder) {
			TrackOrder = trackOrder;
		}
		
		
		////**************************** Cancel order ****************
		
		@FindBy(xpath = "//button[contains(text(),'Cancel Order')]")
		private WebElement Cancel_order;

		public WebElement getCancel_order() {
			return Cancel_order;
		}
		public void setCancel_order(WebElement cancel_order) {
			Cancel_order = cancel_order;
		}
		
		//************************* Cancel Reason **********************
		@FindBy(xpath = "(//input[@name='reasonselect'])[2]")
		private WebElement Cancel_reason;

		public WebElement getCancel_reason() {
			return Cancel_reason;
		}
		public void setCancel_reason(WebElement cancel_reason) {
			Cancel_reason = cancel_reason;
		}
		
		////***************************** Submit and cancel ****************
		@FindBy(xpath = "//button[contains(text(),'SUBMIT & CANCEL')]")
		private WebElement Submit_Cancel;

		public WebElement getSubmit_Cancel() {
			return Submit_Cancel;
		}
		public void setSubmit_Cancel(WebElement submit_Cancel) {
			Submit_Cancel = submit_Cancel;
		}
		
		
		///*************************** Cancelled text ***********
		
		@FindBy(xpath = "//span[contains(text(),'Cancelled ')]")
		private WebElement Canceleld_Text;

		public WebElement getCanceleld_Text() {
			return Canceleld_Text;
		}
		public void setCanceleld_Text(WebElement canceleld_Text) {
			Canceleld_Text = canceleld_Text;
		}
		
		///************************** Cancelled Text ****************
		
		@FindBy(xpath = "//input[@role='textbox']")
		private WebElement LoginPage_SearchBox;
		

		public WebElement getLoginPage_SearchBox() {
			return LoginPage_SearchBox;
		}
	
}
