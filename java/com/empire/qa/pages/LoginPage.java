package com.empire.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.empire.qa.base.BaseTest;

public class LoginPage extends BaseTest{
	@FindBy(name = "emailid")
	WebElement uname;

	@FindBy(id = "pword")
	WebElement pwd;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginbtn;

	@FindBy(xpath = "//img[@src=\"/WebApp/assets/dist/img/logo.png\"]")
	WebElement ehimg;
	
	public LoginPage() throws Throwable {
		super();

		PageFactory.initElements(driver, this);

	}

	public String VerifyEhomeTitle() {
		return driver.getTitle();
	}

	public boolean VerifyEhomeImage() {
		return ehimg.isDisplayed();
	}

	public HomePage VerifyLoginPage() throws Throwable {
		uname.sendKeys(prop.getProperty("username"));
		pwd.sendKeys(prop.getProperty("password"));
		loginbtn.click();
		Thread.sleep(1000);
		return new HomePage();  // because after login it will redirect it to homepage , therefore return type is also homepage
		

	}
}
