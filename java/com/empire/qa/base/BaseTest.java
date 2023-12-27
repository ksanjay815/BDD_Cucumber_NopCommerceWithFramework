package com.empire.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.empire.qa.utils.EventListenerTest;

public class BaseTest {
	public static Properties prop;
	public static WebDriver driver;
	public static EventListenerTest eventlistenertest;
	public static EventFiringWebDriver eventfiringwebdriver;

	public BaseTest() throws Throwable { // we have to create constructor for every class in framework

		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream(
					".\\src\\main\\java\\com\\empire\\qa\\config\\config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public static void initialization() throws Throwable {
		String BrowserName = prop.getProperty("browser");
		if (BrowserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BrowserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BrowserName.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Enter proper browser name");
		}

		// create this two eventlistener objects after launching the rowser only

		eventlistenertest = new EventListenerTest();
		eventfiringwebdriver = new EventFiringWebDriver(driver);
		eventfiringwebdriver.register(eventlistenertest);
		driver = eventfiringwebdriver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.get(prop.getProperty("url"));
	}
}
