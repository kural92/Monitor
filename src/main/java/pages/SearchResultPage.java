package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	public WebDriver driver;
	public SearchResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//***************** Search Icon **************************
	
	@FindBy(id="search")
	private WebElement SearchBox;
	public WebElement getSearchBox() {
		return SearchBox;
	}

	public void setSearchBox(WebElement searchBox) {
		SearchBox = searchBox;
	}
	
	// ***************************************** Add to cart *********************
	
	@FindBy(xpath = "//*[@id=\"algolia_hits\"]/div/div/ol/li[1]/div/form/button")
    private WebElement AddToCart;
	public WebElement getAddToCart() {
		return AddToCart;
	}

	public void setAddToCart(WebElement addToCart) {
		AddToCart = addToCart;
	}
	
	//*********************************  
	//  //input[@role='textbox']|
	
	
	@FindBy(xpath = "//input[@role='textbox']")
	private WebElement LoginPage_SearchBox;
	

	public WebElement getLoginPage_SearchBox() {
		return LoginPage_SearchBox;
	}
	

	
}
