package testmu;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CSSSelector1 extends BaseClass {
	WebDriver driver;

	@Test
	public void TestCSSSelctor() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Mitturaj.h\\Desktop\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		logger=extentReports.startTest("TestCSSSelctor");

		driver.get("https://www.google.co.in/maps");

		driver.findElement(By.id("searchboxinput")).sendKeys("Mysuru");

		driver.findElement(By.id("searchbox-searchbutton")).click();

		driver.findElement(By.xpath("//button[@data-value='Directions']")).click();
		
		Thread.sleep(2000);
		
		List<WebElement> searchBox=driver.findElements(By.cssSelector("input.tactile-searchbox-input"));
		System.out.println(searchBox.size());
			
		searchBox.get(2).sendKeys("Atharga");
		
		/*JavascriptExecutor executor=(JavascriptExecutor)driver;
		
		executor.executeAsyncScript("arguments[0].value='Atharga'", searchBox);*/
		

		driver.findElement(By.cssSelector("div.widget-directions-icon.reverse")).click();
		driver.quit();

	}

}
