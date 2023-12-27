package com.empire.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.empire.qa.base.BaseTest;
import com.empire.qa.utils.UtilTest;

public class SubCategoriesPage extends BaseTest {

	@FindBy(xpath = "//h1[text()='Subcategories']")
	WebElement subCatTitileText;

	@FindBy(xpath = "//i[@class='fa fa-reply mr-2']")
	WebElement backBtn;

	@FindBy(xpath = "//span[@id='select2-subcatDD-container']")
	WebElement selectCategoriesDropdown;

	@FindBy(xpath = "//button[@class='btn btn-success']")
	WebElement searchBtn;

	@FindBy(xpath = "//i[@class='fa fa-plus']")
	WebElement addNewSubCategoryBtn;

	@FindBy(xpath = "//select[@id='subcatDD']")
	WebElement categoryNameDropdown;

	@FindBy(xpath = "//input[@id='SubCategoryName']")
	WebElement subCategoryName;

	@FindBy(xpath = "//button[text()=' Save']")
	WebElement saveBtn;

	@FindBy(xpath = "//a[@class='btn btn-add']")
	WebElement backBtnAddSubCategoryTypePg;

	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	WebElement searchTextField;

	@FindBy(xpath = "//span[@class='ti-arrow-up']")
	WebElement upArrowBtn;

//	@FindBy(xpath = "//a[normalize-space()='Next']")
//	WebElement nextPage;
//
//	@FindBy(xpath = "//a[normalize-space()='Previous']")
//	WebElement previousPage;

	@FindBy(xpath = "//th[@aria-label='#.: activate to sort column descending']")
	WebElement sortSno;

	@FindBy(xpath = "//th[@aria-label='Sub Category Name: activate to sort column ascending']")
	WebElement sortSubCategoryName;

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

	public SubCategoriesPage() throws Throwable {
		super();
		PageFactory.initElements(driver, this);
	}

	public String VerifySubCategoriesPageTitle() {
		return driver.getTitle();

	}

	public void VerifySubCategoriesTitleText() {
		String subTitle = subCatTitileText.getText();
		System.out.println(subTitle);
		if (subTitle.equals("Sub Categories")) {
			Assert.assertTrue(true);
		}
	}

	public void VerifyBackBtn() throws InterruptedException {

		backBtn.click();
	}

	public void VerifybackBtnAddSubCategoryTypePg() throws InterruptedException {
		addNewSubCategoryBtn.click();
		Thread.sleep(1000);
		backBtnAddSubCategoryTypePg.click();
	}

	public void VerifyaddSubCategoryPagewithValidData() throws InterruptedException {

		addNewSubCategoryBtn.click();
		Thread.sleep(1000);
		UtilTest.dropdownmethod(categoryNameDropdown, "bed room");
		Thread.sleep(1000);
		subCategoryName.sendKeys("bed");
		saveBtn.click();
	}

	public void VerifyaddSubCategoryPagewithoutData() throws InterruptedException {

		addNewSubCategoryBtn.click();
		Thread.sleep(1000);
		saveBtn.click();
	}

	public void VerifyaddSubCategoryPagewithInvalidSubCategoryName() throws InterruptedException {

		addNewSubCategoryBtn.click();
		Thread.sleep(1000);
		UtilTest.dropdownmethod(categoryNameDropdown, "bed room");
		Thread.sleep(1000);
		subCategoryName.sendKeys("24$%");
		saveBtn.click();
	}

	public void VerifyToTopArrowBtn() throws InterruptedException {

		UtilTest.ScrolldowntoEnd();
		upArrowBtn.click();
	}

//	public void VerifyNextPageBtn() throws InterruptedException {
//		Thread.sleep(2000);
//		UtilTest.ScrolldowntoEnd();
//		nextPage.click();
//	}
//
//	public void VerifyPreviousPageBtn() throws InterruptedException {
//		Thread.sleep(2000);
//		UtilTest.ScrolldowntoEnd();
//		nextPage.click();
//		previousPage.click();
//	}

	public void VerifySnoSorting() throws InterruptedException {

		sortSno.click();
	}

	public void VerifySubCategoryNameSorting() throws InterruptedException {

		sortSubCategoryName.click();
	}

	public void VerifyShowEntriesDropdown() {
		UtilTest.dropdownmethod(showEntriesDropdown, "10");
	}

	public void VerifyEditButtonBySearchSubCategoryName() throws InterruptedException {

		selectCategoriesDropdown.click();
		Thread.sleep(1000);
		List<WebElement> dropdownlist = driver.findElements(By.xpath("//ul[@id='select2-subcatDD-results']//li"));

		for (WebElement option : dropdownlist) {
			System.out.println(option.getText());
			if (option.getText().contains("bed room")) {
				option.click();
			}
		}
		searchBtn.click();
		Thread.sleep(1000);
		searchTextField.sendKeys("bed");
		Thread.sleep(1000);
		editBtn.click();
		Thread.sleep(1000);
		subCategoryName.clear();
		subCategoryName.sendKeys("single bed");
		saveBtn.click();
	}

	public void VerifyDeleteButtonBySearchSubCategoryName() throws InterruptedException {

		selectCategoriesDropdown.click();
		Thread.sleep(1000);
		List<WebElement> dropdownlist = driver.findElements(By.xpath("//ul[@id='select2-subcatDD-results']//li"));

		for (WebElement option : dropdownlist) {
			System.out.println(option.getText());
			if (option.getText().contains("bed room")) {
				option.click();
			}
		}
		searchBtn.click();
		Thread.sleep(1000);
		searchTextField.sendKeys("bed");
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

		selectCategoriesDropdown.click();
		Thread.sleep(1000);
		List<WebElement> dropdownlist = driver.findElements(By.xpath("//ul[@id='select2-subcatDD-results']//li"));

		for (WebElement option : dropdownlist) {
			System.out.println(option.getText());
			if (option.getText().contains("bed room")) {
				option.click();
			}
		}
		searchBtn.click();
		Thread.sleep(1000);
		searchTextField.sendKeys("bed");
		Thread.sleep(1000);
		deleteBtn.click();
		Thread.sleep(1000);
		yesBtn.click();

	}

	public void VerifySearchTextField() throws InterruptedException {

		selectCategoriesDropdown.click();
		Thread.sleep(1000);
		List<WebElement> dropdownlist = driver.findElements(By.xpath("//ul[@id='select2-subcatDD-results']//li"));

		for (WebElement option : dropdownlist) {
			System.out.println(option.getText());
			if (option.getText().contains("bed room")) {
				option.click();
			}
		}
		searchBtn.click();

		searchTextField.sendKeys("bed");

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

	public void VerifySearchTextFieldWithInvalidData() throws InterruptedException {

		selectCategoriesDropdown.click();
		Thread.sleep(1000);
		List<WebElement> dropdownlist = driver.findElements(By.xpath("//ul[@id='select2-subcatDD-results']//li"));

		for (WebElement option : dropdownlist) {
			System.out.println(option.getText());
			if (option.getText().contains("bed room")) {
				option.click();
			}
		}
		searchBtn.click();
		searchTextField.sendKeys("storeeeee");
		WebElement message = driver.findElement(By.xpath("//td[text()='No matching records found']"));
		System.out.println(message.getText());
		if (message.getText().equals("No matching records found")) {
			Assert.assertTrue(true);
		}

	}
}