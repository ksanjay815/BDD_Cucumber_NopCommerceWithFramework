package com.empire.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.empire.qa.base.BaseTest;

public class HolidaysPage extends BaseTest {

	@FindBy(xpath = "//h1[text()='Holidays']")
	WebElement TitleText;

	@FindBy(xpath = "//span[text()='Holiday Name Required']")
	WebElement warnText;

	@FindBy(xpath = "//i[@class='fa fa-reply mr-2']")
	WebElement backBtn;

	@FindBy(xpath = "//i[@class='fa fa-plus']")
	WebElement addNewBtn;

	@FindBy(xpath = "//a[@class='btn btn-add']")
	WebElement backBtnAddHolidayTypeTypePg;

	@FindBy(xpath = "//input[@class='form-control']")
	WebElement holidayDate;

	@FindBy(xpath = "//input[@name='HolidayName']")
	WebElement holidayName;

	@FindBy(xpath = "//input[@name='HolidayDesc']")
	WebElement holidayDescription;

	@FindBy(xpath = "//button[text()=' Save']")
	WebElement saveBtn;

	@FindBy(xpath = "//i[@class='fa fa-pencil']")
	WebElement editBtn;

	@FindBy(xpath = "//i[@class='fa fa-trash-o']")
	WebElement deleteBtn;

	@FindBy(xpath = "//button[@class='swal-button swal-button--no']")
	WebElement noBtn;

	@FindBy(xpath = "//button[@class='swal-button swal-button--yes']")
	WebElement yesBtn;

	public HolidaysPage() throws Throwable {
		super();
		PageFactory.initElements(driver, this);
	}

	public String VerifyHolidaysPageTitle() {
		return driver.getTitle();

	}

	public void VerifyBackBtn() throws InterruptedException {

		backBtn.click();
	}

	public void VerifybackBtnAddHolidayTypeTypePg() throws InterruptedException {
		addNewBtn.click();
		Thread.sleep(1000);
		backBtnAddHolidayTypeTypePg.click();
	}

	public void VerifyaddNewolidayswithValidData() throws Throwable {

		addNewBtn.click();
		Thread.sleep(1000);
		holidayDate.sendKeys("26/01/2023");
		holidayName.sendKeys("Republic Day");
		holidayDescription.sendKeys("Republic day celebration");
		// saveBtn.click();
		Thread.sleep(1000);
		if (TitleText.isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("Test passed");
		} else {
			Assert.assertTrue(false);
			System.out.println("test failed");
		}
	}

	public void VerifyaddNewolidayswithoutData() throws InterruptedException {

		addNewBtn.click();
		Thread.sleep(1000);
		saveBtn.click();
		Thread.sleep(1000);
		if (warnText.isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("Test passed");
		}
	}

	public void VerifyaddNewolidayswithInvalidData() throws Throwable {

		addNewBtn.click();
		Thread.sleep(1000);
		holidayDate.sendKeys("0100/0000");
		holidayName.sendKeys("Republic Day");
		holidayDescription.sendKeys("Republic day celebration");
		// saveBtn.click();
		Thread.sleep(1000);
		if (TitleText.isDisplayed()) {
			Assert.assertTrue(false);
			System.out.println("Test failed");
		} else {
			Assert.assertTrue(true);
			System.out.println("test passed");
		}
	}

	public void VerifyEditButtonBySelectingHolidaysName() throws InterruptedException {

		editBtn.click();
		Thread.sleep(1000);
		holidayDate.sendKeys("10/04/2023");
		holidayName.clear();
		holidayName.sendKeys("Holi");
		holidayDescription.clear();
		holidayDescription.sendKeys("This is a festival of colours");
		saveBtn.click();
	}

	public void VerifyDeleteButtonBySelectingHolidaysName() throws InterruptedException {

		deleteBtn.click();
		Thread.sleep(1000);
		noBtn.click();
		WebElement cancelledMsg = driver.findElement(By.xpath("//div[@class='toast toast-error']"));
		if (cancelledMsg.getText().equals("Delete cancelled!")) {
			Assert.assertTrue(true);
		}
	}

	public void VerifyDeleteButtonBySelectingHolidaysNameAndClickingYes() throws InterruptedException {

		deleteBtn.click();
		Thread.sleep(1000);
		yesBtn.click();
	}

}
