package com.empire.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.empire.qa.base.BaseTest;
import com.empire.qa.utils.UtilTest;


public class AddInventoryPage extends BaseTest {
	@FindBy(xpath = "//select[@id='catDD']")
	WebElement categoryDropdown;

	@FindBy(xpath = "//select[@id='subcatDD']")
	WebElement SubcategoryDropdown;

	@FindBy(name = "ModelNumber")
	WebElement modelNumber;

	@FindBy(name = "Title")
	WebElement itemTitle;

	@FindBy(name = "ItemDescription")
	WebElement itemDescription;

	@FindBy(name = "Brand")
	WebElement Brand;

	@FindBy(name = "Height")
	WebElement Height;

	@FindBy(name = "Width")
	WebElement width;

	@FindBy(name = "Breadth")
	WebElement Breadth;

	@FindBy(name = "ColorName")
	WebElement ColorName;

	@FindBy(name = "ColorImageUploaded")
	WebElement colorImageupload;

	@FindBy(xpath = "//select[@id='InventoryStatusId']")
	WebElement inventoryStatusId;

	@FindBy(xpath = "//select[@id='InventoryConditonId']")
	WebElement inventoryConditonId;

	@FindBy(xpath = "//select[@id='InventoryLocationId']")
	WebElement inventoryLocationId;

	@FindBy(id = "RecievedDate")
	WebElement recievedDate;

	@FindBy(name = "ActualPrice")
	WebElement actualPrice;

	@FindBy(xpath = "//select[@id='factor']")
	WebElement mrpfactor;

	@FindBy(name = "HSNCode")
	WebElement HSNCode;

	@FindBy(name = "InvoiceNumber")
	WebElement Invoiceno;

	@FindBy(name = "RackName")
	WebElement Rackname;

	@FindBy(name = "PODetails")
	WebElement supplierDetails;

	@FindBy(name = "Qty")
	WebElement qty;

	@FindBy(name = "ProductMainImageUploaded")
	WebElement PrimaryImageUpload;
	
	@FindBy(name = "ProductOtherImagesUploaded")
	WebElement OtherImageUpload;

	@FindBy(xpath = "//button[@class='btn btn-success']")
	WebElement savebtn;

	public AddInventoryPage() throws Throwable {
		super();
		PageFactory.initElements(driver, this);
	}

	public String verifyaddInventoryTitle() {
		return driver.getTitle();
	}

	public  AllInventorypage verifyaddInventorypage(String modelno, String itemTitle, String itemDescription,
			String brand, String Height, String Width, String Breadth, String colorname, String actualPrice,
			String HSNcode, String Rackname, String supplierDetails, String Invoiceno, String qty) throws Throwable {

		//UtilTest.dropdownmethod(categoryDropdown, "Living Rooms");
		//UtilTest.dropdownmethod(SubcategoryDropdown, "mattress");
		modelNumber.sendKeys(modelno);
		this.itemTitle.sendKeys(itemTitle); // using this bcoz both WebElement and argument name itemTitle is same
		this.itemDescription.sendKeys(itemDescription);
		Brand.sendKeys(brand);
		this.Height.sendKeys(Height);
		this.width.sendKeys(Width);
		this.Breadth.sendKeys(Breadth);
		this.ColorName.sendKeys(colorname);

		colorImageupload
				.sendKeys("D:\\Eclipse\\MT-01447\\EmpireHome\\src\\main\\java\\com\\empire\\qa\\testdata\\blue.jpg");

		UtilTest.dropdownmethod(inventoryStatusId, "In Transit");
		UtilTest.dropdownmethod(inventoryConditonId, "Good");
		UtilTest.dropdownmethod(inventoryLocationId, "chennai");
		recievedDate.sendKeys("13/10/2023");
		this.actualPrice.sendKeys(actualPrice);
		UtilTest.dropdownmethod(mrpfactor, "3.00");
		this.HSNCode.sendKeys(HSNcode);
		this.Rackname.sendKeys(Rackname);
		this.supplierDetails.sendKeys(supplierDetails);
		this.Invoiceno.sendKeys(Invoiceno);
		this.qty.clear();
		this.qty.sendKeys(qty);

		// PrimaryImageUpload.sendKeys("D:\Eclipse\MT-01447\EmpireHome\src\main\java\com\empire\qa\testdata\Bed.jpg");

		// another method for uploading files
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", PrimaryImageUpload);
		UtilTest.uploadingFiles();
		//savebtn.click();
		Thread.sleep(2000);
		return new AllInventorypage();
	}

}
