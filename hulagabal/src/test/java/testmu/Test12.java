package testmu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test12 {

	private static WebDriver driver;
	private static String[][] data;

	public static void take() throws IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Mitturaj.h\\Desktop\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File destFile = new File("C:\\Users\\Mitturaj.h\\Desktop\\Photos\\"
				+ new SimpleDateFormat("yyyy-MM-dd-HHmmss").format(new Date()) + ".jpg");
		FileUtils.copyFile(src, destFile);

		driver.quit();
	}

	public static String[][] getdata()
			throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException {

		Workbook workbook = WorkbookFactory
				.create(new FileInputStream(new File("C:\\Users\\Mitturaj.h\\Desktop\\data.xlsx")));

		Sheet sheet = workbook.getSheetAt(0);

		int row = sheet.getLastRowNum();

		data = new String[row][2];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < 2; j++) {
				data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();

			}

		}

		return data;

	}
	
	@DataProvider(name="data")
	public static Object[][] dataprovider() throws Exception{
		return getdata();
	}
	
	@Test(dataProvider="data")
	public void login(String fname,String lname){
		System.out.println(fname+" "+lname);
	}

	
}
