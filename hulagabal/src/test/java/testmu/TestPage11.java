package testmu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestPage11 {

	private WebDriver driver;

	@Test
	public void gteIt() throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Mitturaj.h\\Desktop\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://hulagabal.blogspot.com/");

		Page1.getAllLinks(driver);

		Page1.getAllPosts(driver);
		driver.close();
	}

}

class Page {

	private static String[] links;

	public static void getAllLinks(WebDriver driver) throws Exception {

		List<WebElement> element = driver
				.findElements(By.xpath("//*[@id='BlogArchive2_ArchiveList']/ul[1]/li/ul[1]/li/ul/li"));

		System.out.println(element.size());
		int i = 0;
		links = new String[element.size()];
		for (WebElement e : element) {

			links[i] = e.getText();

			i++;
		}

	}

	public static void getAllPosts(WebDriver driver) {

		for (int i = 0; i < links.length; i++) {

			WebElement element = driver.findElement(By.linkText(links[i]));
			Actions actions = new Actions(driver);
			actions.click(element).build().perform();
			System.out.println(links[i] + " cliked" + i);

		}
	}

}
