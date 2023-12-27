package com.empire.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.empire.qa.base.BaseTest;

public class HomePage extends BaseTest {
	@FindBy(xpath = "//span[@class='pe-7s-keypad']")
	WebElement menu;

	@FindBy(xpath = "//span[text()='Inventory']")
	WebElement inventory;

	@FindBy(xpath = "//a[text()='Add Inventory']")
	WebElement addinventory;

	@FindBy(xpath = "//i[@class='fa fa-database']")
	WebElement masters;

	@FindBy(xpath = "//a[text()='User Types']")
	WebElement userTypes;

	@FindBy(xpath = "//a[text()='Categories']")
	WebElement categories;

	@FindBy(xpath = "//a[text()='Sub Categories']")
	WebElement subCategories;

	@FindBy(xpath = "//a[text()='Location ']")
	WebElement location;

	@FindBy(xpath = "//a[text()='Condition']")
	WebElement condition;

	@FindBy(xpath = "//a[text()='Inventory Status']")
	WebElement inventoryStatus;

	@FindBy(xpath = "//a[text()='Holidays']")
	WebElement holidays;

	@FindBy(xpath = "//a[text()='Shifts']")
	WebElement shifts;

	@FindBy(xpath = "//a[text()='Company']")
	WebElement company;

	@FindBy(xpath = "//a[text()='Taxes']")
	WebElement taxes;

	@FindBy(xpath = "//a[text()='Finance Group']")
	WebElement financeGroup;

	@FindBy(xpath = "//a[@href='/Master/FinanceHead']")
	WebElement ledgers;

	@FindBy(xpath = "//a[text()='MRP Factors']")
	WebElement mrpFactor;

	public HomePage() throws Throwable {
		super();
		PageFactory.initElements(driver, this);
	}

	public String verifyEhomepageTitle() {
		return driver.getTitle();
	}

	public AddInventoryPage verifyEhomepage() throws Throwable {
		
		menu.click();
		Thread.sleep(3000);
		inventory.click();
		Thread.sleep(3000);
		addinventory.click();
		Thread.sleep(3000);
		return new AddInventoryPage();

	}

	public UserTypesPage verifyUserTypePage() throws Throwable {
		
		masters.click();
		Thread.sleep(3000);
		userTypes.click();
		return new UserTypesPage();
	}

	public CategoryTypesPage verifyCategoryTypePage() throws Throwable {
		
		masters.click();
		Thread.sleep(3000);
		categories.click();
		return new CategoryTypesPage();
	}

	public SubCategoriesPage verifySubCategoriesPage() throws Throwable {
	
		masters.click();
		Thread.sleep(3000);
		subCategories.click();
		return new SubCategoriesPage();
	}

	public LocationTypesPage verifyLocationTypesPage() throws Throwable {
		
		masters.click();
		Thread.sleep(3000);
		location.click();
		return new LocationTypesPage();
	}

	public ConditionTypesPage verifyConditionTypesPage() throws Throwable {
		
		masters.click();
		Thread.sleep(3000);
		condition.click();
		return new ConditionTypesPage();
	}

	public InventoryStatusPage verifyInventoryStatusPage() throws Throwable {
		
		masters.click();
		Thread.sleep(3000);
		inventoryStatus.click();
		return new InventoryStatusPage();
	}

	public HolidaysPage verifyHolidaysPage() throws Throwable {
		
		masters.click();
		Thread.sleep(3000);
		holidays.click();
		return new HolidaysPage();
	}

	public ShiftsPage verifyShiftsPage() throws Throwable {
	
		masters.click();
		Thread.sleep(3000);
		shifts.click();
		return new ShiftsPage();
	}
	public MrpFactorsPage verifyMrpFactorPage() throws Throwable {
		
		masters.click();
		Thread.sleep(3000);
		mrpFactor.click();
		return new MrpFactorsPage();
	}
}
