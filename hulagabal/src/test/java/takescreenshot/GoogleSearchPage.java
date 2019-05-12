package takescreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListener.class)
public class GoogleSearchPage {
	WebDriver driver;

	@Test
	public void takeSnap() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Mitturaj.h\\Desktop\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.google.com/");
		driver.findElement(By.name("r")).sendKeys("hulagabal");

	}

	@AfterMethod
	public void TakeSnap(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE){
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sourceFile, new File("./hulagabal/mutturaj-" + dataStamp() + ".png"));
		} catch (IOException e) {

			e.printStackTrace();
			
		}
		}else{
			System.out.println("test passed");
			driver.quit();
		}

	}

	private String dataStamp() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		String date = dateFormat.format(new Date());
		return date;
	}
}
