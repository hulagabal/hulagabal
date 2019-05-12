package takescreenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TakeSnap {
	@Test
	public void takeSnap() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Mitturaj.h\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		try {
			driver.get("https://www.google.com/");
			driver.findElement(By.name("r")).sendKeys("hulagabal");
		} catch (Exception e) {
			File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sourceFile, new File("./hulagabal/mutturaj-"+dataStamp()+ ".png"));
		}

		driver.close();
		driver.quit();
	}

	private String dataStamp() {
	 SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
	 String date=dateFormat.format(new Date());
		return date;
	}
	

}
