package testmu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class TestPage12 extends BaseClass {

	private WebDriver driver;

	@Test
	public void checkAlllinks() throws Exception {
		logger = extentReports.startTest("passTest");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Mitturaj.h\\Desktop\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://hulagabal.blogspot.com/");

		Page1.getAllLinks(driver);
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");

		driver.close();
	}

	@Test
	public void testToFail() {
		logger=extentReports.startTest("Fail Test");
		Assert.assertTrue(false);
		logger.log(LogStatus.PASS, "Faile Test is passed");
	}

}

class Page1 {

	private static List<WebElement> element;

	private static String[] linkTexts = null;

	public static void getAllLinks(WebDriver driver) throws Exception {
		
		Actions actions = new Actions(driver);

		WebElement yearElement = driver.findElement(By.xpath("//a[contains(text(),'2019')]"));
		actions.click(yearElement).build().perform();

		String[] month2019 = { "February", "March", "April" };
		int monthCounter = 3;
		for (String names : month2019) {

			WebElement monthElement = driver.findElement(By.xpath("//a[contains(text(),'" + names + "')]"));
			if (monthElement.isEnabled() == true) {

				actions.click(monthElement).build().perform();

				element = driver.findElements(
						By.xpath("//*[@id='BlogArchive2_ArchiveList']/ul[1]/li/ul[" + monthCounter + "]/li/ul/li"));

				System.out.println("Size of the element is : " + element.size());

				linkTexts = new String[element.size()];

				for (int i = 0; i < element.size(); i++) {

					linkTexts[i] = element.get(i).getText();
					System.out.println(linkTexts[i]);

				}
			} else {
				System.out.println("Element not present");
			}
			monthCounter--;
		}

	}

	public static void getAllPosts(WebDriver driver) throws Exception {

		for (String s : linkTexts) {
			System.out.println(s);
			if (s != null) {
				WebElement linksElements = driver.findElement(By.linkText(s));
				Actions actions = new Actions(driver);
				actions.click(linksElements).build().perform();

			} else {
				break;
			}

		}

	}

}
