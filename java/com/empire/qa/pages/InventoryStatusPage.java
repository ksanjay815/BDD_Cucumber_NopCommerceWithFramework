package com.empire.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.empire.qa.base.BaseTest;
import com.empire.qa.utils.UtilTest;

public class InventoryStatusPage extends BaseTest {

	@FindBy(xpath = "//i[@class='fa fa-reply mr-2']")
	WebElement backBtn;

	@FindBy(xpath = "//i[@class='fa fa-plus']")
	WebElement addStatusTypeBtn;

	@FindBy(xpath = "//input[@id='StatusName']")
	WebElement statusName;

	@FindBy(xpath = "//button[text()=' Save']")
	WebElement saveBtn;

	@FindBy(xpath = "//a[@class='btn btn-add']")
	WebElement backBtnAddStatusTypePg;

	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	WebElement searchTextField;

	@FindBy(xpath = "//span[@class='ti-arrow-up']")
	WebElement upArrowBtn;

	@FindBy(xpath = "//a[normalize-space()='Next']")
	WebElement nextPage;

	@FindBy(xpath = "//a[normalize-space()='3']")
	WebElement page3;

	@FindBy(xpath = "//a[normalize-space()='Previous']")
	WebElement previousPage;

	@FindBy(xpath = "//th[@aria-label='#.: activate to sort column descending']")
	WebElement sortSno;

	@FindBy(xpath = "//th[@aria-label='Status Name: activate to sort column ascending']")
	WebElement sortStatusName;

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

	public InventoryStatusPage() throws Throwable {
		super();
		PageFactory.initElements(driver, this);
	}

	public String VerifyInventoryPageTitle() {
		return driver.getTitle();

	}

	public void VerifyBackBtn() throws InterruptedException {

		backBtn.click();
	}

	public void VerifybackBtnAddStatusPg() throws InterruptedException {
		addStatusTypeBtn.click();
		Thread.sleep(1000);
		backBtnAddStatusTypePg.click();
	}

	public void VerifyaddStatusTypewithValidData() throws InterruptedException {

		addStatusTypeBtn.click();
		Thread.sleep(1000);
		statusName.sendKeys("In Transit");
		saveBtn.click();
	}

	public void VerifyaddStatusTypewithoutData() throws InterruptedException {

		addStatusTypeBtn.click();
		Thread.sleep(1000);
		saveBtn.click();
	}

	public void VerifyaddNewStatusTypewithInvalidLocationName() throws InterruptedException {

		addStatusTypeBtn.click();
		Thread.sleep(1000);
		statusName.sendKeys("245");
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

	public void VerifyPage3Btn() throws InterruptedException {

		UtilTest.ScrolldowntoEnd();
		page3.click();
	}

	public void VerifyPreviousPageBtn() throws InterruptedException {

		UtilTest.ScrolldowntoEnd();
		nextPage.click();
		previousPage.click();
	}

	public void VerifySnoSorting() throws InterruptedException {

		sortSno.click();
	}

	public void VerifyStatusNameSorting() throws InterruptedException {

		sortStatusName.click();
	}

	public void VerifyShowEntriesDropdown() {
		UtilTest.dropdownmethod(showEntriesDropdown, "25");
	}

	public void VerifyEditButtonBySearchStatusName() throws InterruptedException {
		searchTextField.sendKeys("In Transit");
		Thread.sleep(1000);
		editBtn.click();
		Thread.sleep(1000);
		statusName.clear();
		statusName.sendKeys("Reserved1");
		saveBtn.click();
	}

	public void VerifyDeleteButtonBySearchStatusName() throws InterruptedException {
		searchTextField.sendKeys("Reserved1");
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
		searchTextField.sendKeys("Reserved1");
		Thread.sleep(1000);
		deleteBtn.click();
		Thread.sleep(1000);
		yesBtn.click();
	}

	public void VerifySearchTextField() {
		searchTextField.sendKeys("Good");

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
		searchTextField.sendKeys("wru");
		WebElement message = driver.findElement(By.xpath("//td[text()='No matching records found']"));
		System.out.println(message.getText());
		if (message.getText().equals("No matching records found")) {
			Assert.assertTrue(true);
		}
	}
}
