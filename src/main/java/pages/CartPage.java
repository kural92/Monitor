package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	
	
	public CartPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	
	// ************************* Cart Button ***************************
	@FindBy(xpath = "//div[@class='text']")
	private WebElement Cart_btn;

	public WebElement getCart_btn() {
		return Cart_btn;
	}
	public void setCart_btn(WebElement cart_btn) {
		Cart_btn = cart_btn;
	}
	
	
	// ************************* Cart Button List***************************
	@FindBy(xpath = "//div[@class='text']")
	private List<WebElement> Cart_btn_List;
	public List<WebElement> getCart_btn_List() {
		return Cart_btn_List;
	}
	public void setCart_btn_List(List<WebElement> cart_btn_List) {
		Cart_btn_List = cart_btn_List;
	}

	//************************** Remove Icon *******************
	
	

	@FindBy(xpath = "//div[@class='text']|//a[contains(text(),'Remove')]")
	private WebElement Remove_Icon;

	public WebElement getRemove_Icon() {
		return Remove_Icon;
	}
	public void setRemove_Icon(WebElement remove_Icon) {
		Remove_Icon = remove_Icon;
	}

	// ************************  Remove confirm Button *******************************
	
	@FindBy(xpath = "//button[contains(text(),'REMOVE')]")
	private WebElement remove_btn;

	public WebElement getRemove_btn() {
		return remove_btn;
	}
	public void setRemove_btn(WebElement remove_btn) {
		this.remove_btn = remove_btn;
	}
	// ********************** Procceed button ******************************
	
	@FindBy(xpath = "//button[contains(text(),'Proceed')]")
	private WebElement cart_proceedBtn;

	public WebElement getCart_proceedBtn() {
		return cart_proceedBtn;
	}
	public void setCart_proceedBtn(WebElement cart_proceedBtn) {
		this.cart_proceedBtn = cart_proceedBtn;
	}
	
	//************************** Remove Icon *******************
	
	

	@FindBy(xpath = "//div[@class='text']|//a[contains(text(),'Remove')]")
	private List<WebElement> Remove_Icon_List;

	public List<WebElement> getRemove_Icon_List() {
		return Remove_Icon_List;
	}
	public void setRemove_Icon_List(List<WebElement> remove_Icon_List) {
		Remove_Icon_List = remove_Icon_List;
	}
	
	//************************************8 
}
