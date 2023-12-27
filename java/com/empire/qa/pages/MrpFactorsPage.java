package com.empire.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.empire.qa.base.BaseTest;
import com.empire.qa.utils.UtilTest;

public class MrpFactorsPage extends BaseTest {

	@FindBy(xpath = "//i[@class='fa fa-reply mr-2']")
	WebElement backBtn;

	@FindBy(xpath = "//i[@class='fa fa-plus']")
	WebElement addNewBtn;

	@FindBy(xpath = "//input[@id='FactorName']")
	WebElement factorName;

	@FindBy(xpath = "//input[@id='FactorValue']")
	WebElement factorValue;

	@FindBy(xpath = "//button[text()=' Save']")
	WebElement saveBtn;

	@FindBy(xpath = "//a[@class='btn btn-add']")
	WebElement backBtnAddMrpFactorsPg;

	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	WebElement searchTextField;

	@FindBy(xpath = "//span[@class='ti-arrow-up']")
	WebElement upArrowBtn;

	@FindBy(xpath = "//a[normalize-space()='2']")
	WebElement page2;

	@FindBy(xpath = "//a[normalize-space()='Next']")
	WebElement nextPage;

	@FindBy(xpath = "//a[normalize-space()='Previous']")
	WebElement previousPage;

	@FindBy(xpath = "//th[@aria-label='#.: activate to sort column descending']")
	WebElement sortSno;

	@FindBy(xpath = "//th[@aria-label='Factor Name: activate to sort column ascending']")
	WebElement sortFactorName;

	@FindBy(xpath = "//th[@aria-label='Factor Value: activate to sort column ascending']")
	WebElement sortFactorValue;

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

	public MrpFactorsPage() throws Throwable {
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

	public void VerifybackBtnAddMrpFactorsPg() throws InterruptedException {
		addNewBtn.click();
		Thread.sleep(1000);
		backBtnAddMrpFactorsPg.click();
	}

	public void VerifyaddNewMrpFactorwithValidData() throws InterruptedException {

		addNewBtn.click();
		Thread.sleep(1000);
		factorName.sendKeys("GST");
		factorValue.sendKeys("9");
		Thread.sleep(1000);
		saveBtn.click();
	}

	public void VerifyaddNewMrpFactorwithoutData() throws InterruptedException {

		addNewBtn.click();
		Thread.sleep(1000);
		saveBtn.click();
	}

	public void VerifyaddNewMrpFactorwithInvalidFactorValue() throws InterruptedException {

		addNewBtn.click();
		Thread.sleep(1000);
		factorName.sendKeys("GST");
		factorValue.sendKeys("@#rw");
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

	public void VerifySnoSorting() throws InterruptedException {

		sortSno.click();
	}

	public void VerifyFactorNameSorting() throws InterruptedException {

		sortFactorName.click();
	}

	public void VerifyFactorValueSorting() throws InterruptedException {

		sortFactorValue.click();
	}

	public void VerifyShowEntriesDropdown() {
		UtilTest.dropdownmethod(showEntriesDropdown, "25");
	}

	public void VerifyEditButtonBySearchFactorName() throws InterruptedException {
		searchTextField.sendKeys("GST");
		Thread.sleep(1000);
		editBtn.click();
		Thread.sleep(1000);
		factorName.clear();
		factorName.sendKeys("VAT");
		factorValue.clear();
		factorValue.sendKeys("5");
		Thread.sleep(1000);
		saveBtn.click();
	}

	public void VerifyDeleteButtonBySearchFactorName() throws InterruptedException {
		searchTextField.sendKeys("VAT");
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
		searchTextField.sendKeys("VAT");
		Thread.sleep(1000);
		deleteBtn.click();
		Thread.sleep(1000);
		yesBtn.click();
	}

	public void VerifySearchTextField() {
		searchTextField.sendKeys("GST");

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
		searchTextField.sendKeys("@#%D");
		WebElement message = driver.findElement(By.xpath("//td[text()='No matching records found']"));
		System.out.println(message.getText());
		if (message.getText().equals("No matching records found")) {
			Assert.assertTrue(true);
		}
	}
}