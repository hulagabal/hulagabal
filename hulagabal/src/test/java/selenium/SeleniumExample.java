package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumExample {

	private WebDriver driver;

	@Test
	public void getDriver() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Mitturaj.h\\Desktop\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.navigate().to("https://markmanson.net/subscribed");

		List<WebElement> lists = driver.findElements(By.xpath("//a"));

		System.out.println(lists.size());

		for (WebElement s : lists) {
			try {
				String text = s.getText();

				if (text.length() != 0) {
					System.out.println(s.getText());
					s.click();
					System.out.println("Clicked");
					

				} else {
					System.out.println("No link text");
				}
			} catch (StaleElementReferenceException exception) {
				System.out.println(exception);
				continue;
			}

		}

		driver.quit();
	}

}
