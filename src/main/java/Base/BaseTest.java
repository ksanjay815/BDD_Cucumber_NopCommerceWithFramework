package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import Utils.EventListenerTest;

public class BaseTest {
	public static Properties prop;
	public static WebDriver driver;
	public static EventListenerTest eventlistenertest;
	public static EventFiringWebDriver eventfiringwebdriver;
	public static Logger logger;

	public BaseTest() throws Throwable { // we have to create constructor for every class in framework

		// Logging ----> always import from org.apache.log4j

		logger = Logger.getLogger("nopCommerce");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);

		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream(".\\src\\main\\java\\Config\\config.properties");
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
		// driver.get(prop.getProperty("url"));
	}
}
