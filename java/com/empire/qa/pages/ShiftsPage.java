package com.empire.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.empire.qa.base.BaseTest;
import com.empire.qa.utils.UtilTest;

public class ShiftsPage extends BaseTest {

	@FindBy(xpath = "//h1[text()='Holidays']")
	WebElement TitleText;

	@FindBy(xpath = "//span[text()='Shift Name Required']")
	WebElement warnText;

	@FindBy(xpath = "//i[@class='fa fa-reply mr-2']")
	WebElement backBtn;

	@FindBy(xpath = "//i[@class='fa fa-plus']")
	WebElement addNewBtn;

	@FindBy(xpath = "//a[@class='btn btn-add']")
	WebElement backBtnAddShiftsPg;

	@FindBy(xpath = "//input[@id='ShiftName']")
	WebElement shiftName;

	@FindBy(xpath = "//input[@name='StartTime']")
	WebElement startTime;

	@FindBy(xpath = "//input[@name='EndTime']")
	WebElement endTime;

	@FindBy(xpath = "//button[text()=' Save']")
	WebElement saveBtn;

	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	WebElement searchTextField;

	@FindBy(xpath = "//span[@class='ti-arrow-up']")
	WebElement upArrowBtn;

	@FindBy(xpath = "//a[normalize-space()='Next']")
	WebElement nextPage;

	@FindBy(xpath = "//a[normalize-space()='2']")
	WebElement page2;

	@FindBy(xpath = "//a[normalize-space()='Previous']")
	WebElement previousPage;

	@FindBy(xpath = "//th[@aria-label='#.: activate to sort column descending']")
	WebElement sortSno;

	@FindBy(xpath = "//th[@aria-label='Shift Name: activate to sort column ascending']")
	WebElement sortShiftName;

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

	public ShiftsPage() throws Throwable {
		super();
		PageFactory.initElements(driver, this);
	}

	public String VerifyConditionPageTitle() {
		return driver.getTitle();

	}

	public void VerifyBackBtn() throws InterruptedException {

		backBtn.click();
	}

	public void VerifybackBtnAddShiftsPg() throws InterruptedException {
		addNewBtn.click();
		Thread.sleep(1000);
		backBtnAddShiftsPg.click();
	}

	public void VerifyaddNewShiftwithValidData() throws InterruptedException {

		addNewBtn.click();
		Thread.sleep(1000);
		shiftName.sendKeys("Night");
		startTime.sendKeys("10:00PM");
		endTime.sendKeys("06:00AM");
		saveBtn.click();
		Thread.sleep(2000);
		if (TitleText.isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("Test passed");
		} else {
			Assert.assertTrue(false);
			System.out.println("test failed");
		}
	}

	public void VerifyaddNewShiftwithoutData() throws InterruptedException {

		addNewBtn.click();
		Thread.sleep(1000);
		saveBtn.click();
		Thread.sleep(2000);
		if (warnText.isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("Test passed");
		}
	}

	public void VerifyaddNewShiftwithInvalidShiftName() throws InterruptedException {

		addNewBtn.click();
		Thread.sleep(1000);
		shiftName.sendKeys("Night");
		startTime.sendKeys("36:00PM");
		endTime.sendKeys("46:66AM");
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

	public void VerifyPage2Btn() throws InterruptedException {

		UtilTest.ScrolldowntoEnd();
		page2.click();
	}

	public void VerifyPreviousPageBtn() throws InterruptedException {

		UtilTest.ScrolldowntoEnd();
		nextPage.click();
		previousPage.click();
	}

	public void VerifySnoSorting() throws InterruptedException {

		sortSno.click();
	}

	public void VerifyShiftNameSorting() throws InterruptedException {

		sortShiftName.click();
	}

	public void VerifyShowEntriesDropdown() {
		UtilTest.dropdownmethod(showEntriesDropdown, "25");
	}

	public void VerifyEditButtonBySearchShiftName() throws InterruptedException {
		searchTextField.sendKeys("morning");
		Thread.sleep(1000);
		editBtn.click();
		Thread.sleep(1000);
		shiftName.clear();
		shiftName.sendKeys("Mrng");
		saveBtn.click();
	}

	public void VerifyDeleteButtonBySearchShiftName() throws InterruptedException {
		searchTextField.sendKeys("Mrng");
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
		searchTextField.sendKeys("Mrng");
		Thread.sleep(1000);
		deleteBtn.click();
		Thread.sleep(1000);
		yesBtn.click();
	}

	public void VerifySearchTextField() {
		searchTextField.sendKeys("Morning");

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
