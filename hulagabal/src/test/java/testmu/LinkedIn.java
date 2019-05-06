package testmu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class LinkedIn extends BaseClass {
	@Test
	public void Login() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Mitturaj.h\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.linkedin.com");

		logger = extentReports.startTest("logIn");

		driver.findElement(By.linkText("Sign in")).click();

		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("hulagabal@gmail.com");

		driver.findElement(By.cssSelector("input[id='password']")).sendKeys("8970711727");

		driver.findElement(By.cssSelector("button[type='submit']")).submit();

		driver.findElement(By.id("nav-settings__dropdown-trigger")).click();

		driver.findElement(By.linkText("Sign out")).click();

		driver.quit();
		logger.log(LogStatus.PASS, "To pass");
	}

	@Test
	public void test111() {
		logger = extentReports.startTest("test111");
		Assert.assertTrue(false);
		logger.log(LogStatus.FAIL, "To fail");
	}

}
