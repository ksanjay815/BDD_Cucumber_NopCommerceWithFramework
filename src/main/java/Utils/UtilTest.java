package Utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseTest;


public class UtilTest extends BaseTest {

	public UtilTest() throws Throwable {
		super();

	}

	// for dropdown
	public static void dropdownmethod(WebElement ele, String value) {
		Select sel = new Select(ele);
		sel.selectByVisibleText(value);
	}

	// for excel sheet
	public static String ExcelData = ".\\src\\main\\java\\com\\empire\\qa\\testdata\\EHomeData.xlsx";
	public static Workbook book;
	public static Sheet sheet;

	public static Object[][] getExcelData(String sheetname) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(ExcelData);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// this object contains two arguments 1 for last row count and 1 for last column
		// count(cell)
		for (int r = 0; r < sheet.getLastRowNum(); r++) { // taken the row no
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) { // taken the column no
				DataFormatter df = new DataFormatter(); // it is used bcoz we are using different data types in String
														// value in arguments
				data[r][k] = df.formatCellValue(sheet.getRow(r + 1).getCell(k));

			}
		}
		return data;
	}

	public static String primaryImg = ".\\src\\main\\java\\com\\empire\\qa\\testdata\\Bed";

	public static void uploadingFiles() throws AWTException {
		Robot rb = new Robot();
		rb.delay(2000);
		// this next 2 lines is to copy the file
		StringSelection ss = new StringSelection(primaryImg);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// this next 2 lines is to paste the file
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		rb.keyPress(KeyEvent.VK_ENTER); // enter
		rb.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void ScreenshotMethod() throws Throwable {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir");
		FileUtils.copyFile(src, new File(dest + "/EmpireScreenshots/" + System.currentTimeMillis() + ".png"));
	}

	public static void ScrolldowntoEnd() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// js.executeScript("window.scrollBy(0,1500)");
		// this code is to scroll till the bottom of page
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void Explicitywaitmethod(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2000));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

}