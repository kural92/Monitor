package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		
	}
	
	// ********************** Upload Button
	
	@FindBy(id="upload_prescription_button")
	private WebElement Upload_btn;
	public WebElement getUpload_btn() {
		return Upload_btn;
	}

	public void setUpload_btn(WebElement upload_btn) {
		Upload_btn = upload_btn;
	}
	
	// ********************** Upload Prescription Button **************
	
	@FindBy(xpath = "//*[@id='app']/main/app-m2/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div/div/form/div[1]/ul/li[1]/label/input")
	private WebElement Upload_Prescription_btn;
	public WebElement getUpload_Prescription_btn() {
		return Upload_Prescription_btn;
	}

	public void setUpload_Prescription_btn(WebElement upload_Prescription_btn) {
		Upload_Prescription_btn = upload_Prescription_btn;
	}
	
	//**********************************Search and Add Medicine Check Radio Button
	@FindBy(xpath = "//input[@name='m2optlist']")
	private WebElement Search_Add_Medicine;

	public WebElement getSearch_Add_Medicine() {
		return Search_Add_Medicine;
	}

	public void setSearch_Add_Medicine(WebElement search_Add_Medicine) {
		Search_Add_Medicine = search_Add_Medicine;
	}
	
	//***************** Upload Continue button 
	
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement Upload_Continue_btn;

	public WebElement getUpload_Continue_btn() {
		return Upload_Continue_btn;
	}

	public void setUpload_Continue_btn(WebElement upload_Continue_btn) {
		Upload_Continue_btn = upload_Continue_btn;
	}
	
	// ******************** M2_Search Box *******
	@FindBy(xpath="(//input[@role='textbox'])[3]")
	private WebElement M2_Search_TextBox;

	public WebElement getM2_Search_TextBox() {
		return M2_Search_TextBox;
	}

	public void setM2_Search_TextBox(WebElement m2_Search_TextBox) {
		M2_Search_TextBox = m2_Search_TextBox;
	}
	
	// *********************M2 Add to cart 
	
	@FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
	private WebElement M2_Add_to_cart;

	public WebElement getM2_Add_to_cart() {
		return M2_Add_to_cart;
	}

	public void setM2_Add_to_cart(WebElement m2_Add_to_cart) {
		M2_Add_to_cart = m2_Add_to_cart;
	}
	
	// *********************** M2 Cart Proceed ***************************
	
	@FindBy(xpath = "//button[contains(text(),'Proceed')]")
	private WebElement m2_proceed_to_cart;

	public WebElement getM2_proceed_to_cart() {
		return m2_proceed_to_cart;
	}

	public void setM2_proceed_to_cart(WebElement m2_proceed_to_cart) {
		this.m2_proceed_to_cart = m2_proceed_to_cart;
	}
	//*************** M2 Cart proceed Pop-up *****************

	@FindBy(xpath = "//a[contains(text(),'Proceed')]")
	private WebElement m2_proceed_to_cart_popUP;
	
	
	public WebElement getM2_proceed_to_cart_popUP() {
		return m2_proceed_to_cart_popUP;
	}

	public void setM2_proceed_to_cart_popUP(WebElement m2_proceed_to_cart_popUP) {
		this.m2_proceed_to_cart_popUP = m2_proceed_to_cart_popUP;
	}
	
	//****************************** Get call From netmeds


	@FindBy(xpath = "(//input[@name='m2optlist'])[2]")
	private WebElement Get_Call_from_netmeds;

	public WebElement getGet_Call_from_netmeds() {
		return Get_Call_from_netmeds;
	}

	public void setGet_Call_from_netmeds(WebElement get_Call_from_netmeds) {
		Get_Call_from_netmeds = get_Call_from_netmeds;
	}

	
	/////********** Saved Prescription **********************
	
	@FindBy(xpath = "//*[@id=\"app\"]/main/app-m2/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div/div/form/div[1]/ul/li[2]/label")
	private WebElement Saved_Prescription;

	public WebElement getSaved_Prescription() {
		return Saved_Prescription;
	}

	public void setSaved_Prescription(WebElement saved_Prescription) {
		Saved_Prescription = saved_Prescription;
	}
	
	//******************************* Saved Presc radio Button
	@FindBy(xpath = "//input[@name='m2pastRx']")
	private WebElement Saved_Prescription_Radio_btnl;

	public WebElement getSaved_Prescription_Radio_btnl() {
		return Saved_Prescription_Radio_btnl;
	}

	public void setSaved_Prescription_Radio_btnl(WebElement saved_Prescription_Radio_btnl) {
		Saved_Prescription_Radio_btnl = saved_Prescription_Radio_btnl;
	}
	
	//***********************  Saved Prescription Close button
	@FindBy(xpath = "(//*[@id=\"frameModalTop\"]/div/div/div[1]/button)[2]")
	private WebElement saved_prescription_close;

	public WebElement getSaved_prescription_close() {
		return saved_prescription_close;
	}

	public void setSaved_prescription_close(WebElement saved_prescription_close) {
		this.saved_prescription_close = saved_prescription_close;
	}
	
	///****************
	
	
	// Limited time deal
	
	@FindBy(xpath = "//h2[contains(text(),' Limited Time Deals ')]")
	private WebElement Limited_time_Deal;

	public WebElement getLimited_time_Deal() {
		return Limited_time_Deal;
	}

	public void setLimited_time_Deal(WebElement limited_time_Deal) {
		Limited_time_Deal = limited_time_Deal;
	}
	
	
	
	//limited time deal  -- View All Button
	
	@FindBy(xpath = "(//a[@class='clsviewall'])[2]")
	private WebElement Lmd_ViewAll;

	public WebElement getLmd_ViewAll() {
		return Lmd_ViewAll;
	}

	public void setLmd_ViewAll(WebElement lmd_ViewAll) {
		Lmd_ViewAll = lmd_ViewAll;
	}
	
	
	
	//////	lmd add to cart button
	
	
	@FindBy(id = "product-addtocart-button")
	private WebElement Lmd_Add_to_cart;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLmd_Add_to_cart() {
		return Lmd_Add_to_cart;
	}
	

	
	
	
	
}
