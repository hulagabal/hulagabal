package testmu;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExternalLink {
	@Test
	public void clickOnLink() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Mitturaj.h\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://hulagabal.blogspot.com/");

		System.out.println(driver.getTitle());

		WebElement linkedInLink = driver.findElement(By.xpath("//a[text()='Mutturaj Hulagabal']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", linkedInLink);

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		System.out.println(tabs.size());

		driver.switchTo().window(tabs.get(1));

		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("//a[text()='Sign in']")).click();

		driver.findElement(By.id("login-email")).sendKeys("hulagabal@gmail.com");

		driver.findElement(By.id("login-password")).sendKeys("8970711727");

		driver.findElement(By.id("login-submit")).submit();

		driver.findElement(By.id("nav-settings__dropdown-trigger")).click();

		driver.findElement(By.xpath("//a[text()='Sign out']")).click();

		driver.switchTo().window(tabs.get(0));

		System.out.println(driver.getTitle());

		driver.quit();

	}

}
