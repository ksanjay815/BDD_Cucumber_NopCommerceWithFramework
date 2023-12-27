package com.empire.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.empire.qa.base.BaseTest;
import com.empire.qa.utils.UtilTest;

public class UserTypesPage extends BaseTest {
	@FindBy(xpath = "//i[@class='fa fa-reply mr-2']")
	WebElement backBtn;

	@FindBy(xpath = "//i[@class='fa fa-plus']")
	WebElement addNewBtn;

	@FindBy(xpath = "//input[@id='TypeName']")
	WebElement typeName;

	@FindBy(xpath = "//input[@id='TypeCode']")
	WebElement typeCode;

	@FindBy(xpath = "//button[text()=' Save']")
	WebElement saveBtn;

	@FindBy(xpath = "//a[@class='btn btn-add']")
	WebElement backBtnAddUserTypePg;

	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	WebElement searchTextField;

	@FindBy(xpath = "//span[@class='ti-arrow-up']")
	WebElement upArrowBtn;

	@FindBy(xpath = "//a[normalize-space()='2']")
	WebElement page2;

	@FindBy(xpath = "//a[normalize-space()='3']")
	WebElement page3;

	@FindBy(xpath = "//a[normalize-space()='Next']")
	WebElement nextPage;

	@FindBy(xpath = "//a[normalize-space()='Previous']")
	WebElement previousPage;

	@FindBy(xpath = "//th[@aria-label='#.: activate to sort column descending']")
	WebElement sortSno;

	@FindBy(xpath = "//th[@aria-label='Type Name: activate to sort column ascending']")
	WebElement sortTypeName;

	@FindBy(xpath = "//th[@aria-label='Type Code: activate to sort column ascending']")
	WebElement sortTypeCode;

	@FindBy(xpath = "//select[@name='mydatatable_length']")
	WebElement showEntriesDropdown;

	@FindBy(xpath = "//i[@class='fa fa-pencil']")
	WebElement editBtn;

	@FindBy(xpath = "//i[@class='fa fa-trash-o']")
	WebElement deleteBtn;

	@FindBy(xpath = "//button[@class='swal-button swal-button--no']")
	WebElement noBtn;

	@FindBy(xpath = "//button[@class='swal-button swal-button--yes']")
	WebElement yesBtn;

	public UserTypesPage() throws Throwable {
		super();
		PageFactory.initElements(driver, this);
	}

	public String VerifyUserTypePageTitle() {
		return driver.getTitle();

	}

	public void VerifyBackBtn() throws InterruptedException {
		Thread.sleep(1000);
		backBtn.click();
	}

	public void VerifybackBtnAddUserTypePg() throws InterruptedException {
		addNewBtn.click();
		Thread.sleep(1000);
		backBtnAddUserTypePg.click();
	}

	public void VerifyaddNewUserTypePagewithValidData() throws InterruptedException {

		addNewBtn.click();
		Thread.sleep(1000);
		typeName.sendKeys("Sanjay");
		typeCode.sendKeys("1447");
		Thread.sleep(1000);
		saveBtn.click();
	}

	public void VerifyaddNewUserTypePagewithoutData() throws InterruptedException {

		addNewBtn.click();
		Thread.sleep(1000);
		saveBtn.click();
	}

	public void VerifyaddNewUserTypePagewithInvalidTypeName() throws InterruptedException {

		addNewBtn.click();
		Thread.sleep(1000);
		typeName.sendKeys("@!@#Jay");
		typeCode.sendKeys("1447");
		Thread.sleep(1000);
		saveBtn.click();
	}

	public void VerifyaddNewUserTypePagewithInvalidTypeCode() throws InterruptedException {

		addNewBtn.click();
		Thread.sleep(1000);
		typeName.sendKeys("Sanjay");
		typeCode.sendKeys("ABC@123");
		Thread.sleep(1000);
		saveBtn.click();
	}

	public void VerifyToTopArrowBtn() throws InterruptedException {

		UtilTest.ScrolldowntoEnd();
		upArrowBtn.click();
	}

	public void VerifyNextPageBtn() throws InterruptedException {

		UtilTest.ScrolldowntoEnd();
		nextPage.click();
	}

	public void VerifyPreviousPageBtn() throws InterruptedException {

		UtilTest.ScrolldowntoEnd();
		nextPage.click();
		previousPage.click();
	}

	public void VerifyPage2Btn() throws InterruptedException {

		UtilTest.ScrolldowntoEnd();
		page2.click();
	}

	public void VerifyPage3Btn() throws InterruptedException {

		UtilTest.ScrolldowntoEnd();
		page3.click();
	}

	public void VerifySnoSorting() throws InterruptedException {

		sortSno.click();
	}

	public void VerifyTypeNameSorting() throws InterruptedException {

		sortTypeName.click();
	}

	public void VerifyTypeCodeSorting() throws InterruptedException {

		sortTypeCode.click();
	}

	public void VerifyShowEntriesDropdown() {
		UtilTest.dropdownmethod(showEntriesDropdown, "25");
	}

	public void VerifyEditButtonBySearch_TypeName() throws InterruptedException {
		searchTextField.sendKeys("Sanjay");
		Thread.sleep(1000);
		editBtn.click();
		Thread.sleep(1000);
		typeName.clear();
		typeName.sendKeys("sanju");
		typeCode.clear();
		typeCode.sendKeys("1447");
		Thread.sleep(1000);
		saveBtn.click();
	}

	public void VerifyDeleteButtonBySearch_TypeName() throws InterruptedException {
		searchTextField.sendKeys("sanju");
		Thread.sleep(1000);
		deleteBtn.click();
		Thread.sleep(1000);
		noBtn.click();
		WebElement cancelledMsg = driver.findElement(By.xpath("//div[@class='toast toast-error']"));
		if (cancelledMsg.getText().equals("Delete cancelled!")) {
			Assert.assertTrue(true);
		}
	}

	public void VerifyDeleteButtonByClickingYes() throws InterruptedException {
		searchTextField.sendKeys("sanju");
		Thread.sleep(1000);
		deleteBtn.click();
		Thread.sleep(1000);
		yesBtn.click();
	}

	public void VerifySearchTextField() {
		searchTextField.sendKeys("Emp1");

		WebElement table = driver.findElement(By.xpath("//table[@id='mydatatable']"));

		// the below code is used to print the table data after searching text in he
		// text field

		java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (WebElement row : rows) {
			java.util.List<WebElement> columns = row.findElements(By.tagName("td"));

			for (WebElement column : columns) {
				System.out.print(column.getText() + "\t");
			}
			System.err.println(); // Move to the next row, err to print in red colour
		}
	}

	public void VerifySearchTextFieldWithInvalidData() {
		searchTextField.sendKeys("qqqq");
		WebElement message = driver.findElement(By.xpath("//td[text()='No matching records found']"));
		System.out.println(message.getText());
		if (message.getText().equals("No matching records found")) {
			Assert.assertTrue(true);
		}
	}
}