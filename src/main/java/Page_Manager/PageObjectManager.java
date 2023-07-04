package Page_Manager;

import org.openqa.selenium.WebDriver;

import Base.BaseClass;
import pages.CartPage;
import pages.HomePage;
import pages.LabTest;
import pages.LoginPage;
import pages.OrderReviewPage;
import pages.PaymentPage;
import pages.ProductPage;
import pages.SearchResultPage;



public class PageObjectManager extends BaseClass {
	
	
	private CartPage cartPage;
	private HomePage homePage;
	private LoginPage loginPage;
	private OrderReviewPage orderReviewPage;
	private PaymentPage paymentPage;
	private ProductPage productPage;
	private SearchResultPage searchResultPage;
	private LabTest labTest;

	
	public PageObjectManager(WebDriver driver) {
		BaseClass.driver=driver; //this.driver=driver;
		 
		
	}

	public LabTest geLabTest() {
		return (labTest==null)? labTest=new LabTest(driver):
		labTest;
		
	}
	
	public CartPage getCartPage() {
		return(cartPage==null)? cartPage=new CartPage(driver):
		cartPage;
	}
	
	public HomePage getHomePage() {
		
		return(homePage==null)? homePage=new HomePage(driver):
			homePage;
	}
	
	
	public LoginPage getLoginPage() {
		return (loginPage==null)? loginPage = new LoginPage(driver):
			loginPage;
	}
	
	public OrderReviewPage getOrderReviewPage() {
		return(orderReviewPage==null)? orderReviewPage=new OrderReviewPage(driver):
			orderReviewPage;
	
	}
	
	
	public PaymentPage getPaymentPage() {
		return(paymentPage==null)? paymentPage=new PaymentPage():
			paymentPage;
	}
	
	public ProductPage getProductPage() {
		return(productPage==null)? productPage=new ProductPage():
			productPage;
	}
	
	
	public SearchResultPage getSearchResultPage() {
		return(searchResultPage==null)? searchResultPage=new SearchResultPage(driver):
		searchResultPage;
	}
	
	
}
