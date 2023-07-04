package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

public class LabTest extends BaseClass{
	
	public LabTest(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	// lab test button
	
	@FindBy(xpath = "//a[contains(text(),'Lab Tests')]")
	private WebElement labTest_btn;

	public WebElement getLabTest_btn() {
		return labTest_btn;
	}
	public void setLabTest_btn(WebElement labTest_btn) {
		this.labTest_btn = labTest_btn;
	}
	
	
	// Popular test
	@FindBy(xpath = "//h2[contains(text(),'Popular Tests')]")
	private WebElement popularTest;

	public WebElement getPopularTest() {
		return popularTest;
	}
	public void setPopularTest(WebElement popularTest) {
		this.popularTest = popularTest;
	}
	
	//popular Test text
	@FindBy(xpath = "//p[@class='best-prices']")
	private WebElement popularTest_text;

	public WebElement getPopularTest_text() {
		return popularTest_text;
	}
	public void setPopularTest_text(WebElement popularTest_text) {
		this.popularTest_text = popularTest_text;
	}
	
	
	//popular Test Name
		@FindBy(xpath = "//div[@class='icon-flex']")
		private List<WebElement> popularTest_Names;

		public List<WebElement> getPopularTest_Names() {
			return popularTest_Names;
		}
		public void setPopularTest_Names(List<WebElement> popularTest_Names) {
			this.popularTest_Names = popularTest_Names;
		}
		
		
		//Top selling pack
		
		@FindBy(xpath = "//h2[contains(text(),'Top Selling Packages')]")
		private WebElement top_Selling_pack;

		public WebElement getTop_Selling_pack() {
			return top_Selling_pack;
		}
		public void setTop_Selling_pack(WebElement top_Selling_pack) {
			this.top_Selling_pack = top_Selling_pack;
		}
		
		
		// Top selling pack name 
		@FindBy(xpath = "//div[@class='top-sell-wrap-item']")
		private List<WebElement> top_selling_Pack_Name;

		public List<WebElement> getTop_selling_Pack_Name() {
			return top_selling_Pack_Name;
		}
		public void setTop_selling_Pack_Name(List<WebElement> top_selling_Pack_Name) {
			this.top_selling_Pack_Name = top_selling_Pack_Name;
		}

		//  top_Selling_pack book now button
		@FindBy(xpath = "//h2[contains(text(),'Top Selling Packages')]")
		private WebElement top_Selling_pack_BookNow;

		public WebElement getTop_Selling_pack_BookNow() {
			return top_Selling_pack_BookNow;
		}
		public void setTop_Selling_pack_BookNow(WebElement top_Selling_pack_BookNow) {
			this.top_Selling_pack_BookNow = top_Selling_pack_BookNow;
		}
		
		//Enter Name
		@FindBy(id="fname-input")
		private WebElement labTest_Name;

		public WebElement getLabTest_Name() {
			return labTest_Name;
		}
		public void setLabTest_Name(WebElement labTest_Name) {
			this.labTest_Name = labTest_Name;
		}
		
		
		//Mobile Number
				@FindBy(xpath ="//input[@name='diagnosis_mobi']")
				private WebElement labTest_MobileNum;

				public WebElement getLabTest_MobileNum() {
					return labTest_MobileNum;
				}
				public void setLabTest_MobileNum(WebElement labTest_MobileNum) {
					this.labTest_MobileNum = labTest_MobileNum;
				}

				//Pin Code
				@FindBy(xpath ="//input[@name='diagnosis_pincode']")
				private WebElement labTest_pinCode;

				public WebElement getLabTest_pinCode() {
					return labTest_pinCode;
				}
				public void setLabTest_pinCode(WebElement labTest_pinCode) {
					this.labTest_pinCode = labTest_pinCode;
				}
				
				
				//Choose package
				@FindBy(id ="diagnosis_states")
				private WebElement labTest_ChoosePackage;

				public WebElement getLabTest_ChoosePackage() {
					return labTest_ChoosePackage;
				}
				public void setLabTest_ChoosePackage(WebElement labTest_ChoosePackage) {
					this.labTest_ChoosePackage = labTest_ChoosePackage;
				}
				
				//Choose Test
				@FindBy(id ="diagnosis_test")
				private WebElement labTest_ChooseTest;

				public WebElement getLabTest_ChooseTest() {
					return labTest_ChooseTest;
				}
				public void setLabTest_ChooseTest(WebElement labTest_ChooseTest) {
					this.labTest_ChooseTest = labTest_ChooseTest;
				}
				
				
				//Terms and con
				@FindBy(id="terms")
				private WebElement labTest_Terms;

				public WebElement getLabTest_Terms() {
					return labTest_Terms;
				}
				public void setLabTest_Terms(WebElement labTest_Terms) {
					this.labTest_Terms = labTest_Terms;
				}
				
				//bOOK nOW 
				@FindBy(xpath = "//input[@value='BOOK NOW']")
				private WebElement lapTest_BookNow;

				public WebElement getLapTest_BookNow() {
					return lapTest_BookNow;
				}
				public void setLapTest_BookNow(WebElement lapTest_BookNow) {
					this.lapTest_BookNow = lapTest_BookNow;
				}
				
				
				//span[@class='reg_success']
				//bOOK nOW  Success content
				@FindBy(xpath = "//input[@value='BOOK NOW']")
				private WebElement lapTest_BookNow_Success;

				public WebElement getLapTest_BookNow_Success() {
					return lapTest_BookNow_Success;
				}
				public void setLapTest_BookNow_Success(WebElement lapTest_BookNow_Success) {
					this.lapTest_BookNow_Success = lapTest_BookNow_Success;
				}
				

				//Pathology Button
				@FindBy(xpath = "//a[@class='patho-button']")
				private WebElement pathology;

				public WebElement getPathology() {
					return pathology;
				}
				public void setPathology(WebElement pathology) {
					this.pathology = pathology;
				}
				
				//
				
}
