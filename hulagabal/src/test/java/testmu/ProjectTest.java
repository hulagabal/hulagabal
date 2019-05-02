package testmu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ProjectTest {
	private WebDriver driver;

	@Test
	public void checkAlllinks() throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Mitturaj.h\\Desktop\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://hulagabal.blogspot.com/");

		Actions action = new Actions(driver);

		for (int x = 1; x < 9; x++) {
			System.out.println("=======================");
			WebElement years = driver
					.findElement(By.xpath("//*[@id='BlogArchive2_ArchiveList']/ul[" + x + "]/li/a[2]"));

			System.out.println("Year: " + years.getText());

			WebElement year = driver.findElement(By.linkText(years.getText()));

			action.click(year).build().perform();

			List<WebElement> months = driver
					.findElements(By.xpath("//*[@id='BlogArchive2_ArchiveList']/ul[" + x + "]/li/ul"));

			for (int y = 1; y < months.size() + 1; y++) {

				String month = driver
						.findElement(
								By.xpath("//*[@id='BlogArchive2_ArchiveList']/ul[" + x + "]/li/ul[" + y + "]/li/a[2]"))
						.getText();

				WebElement monthelement = driver.findElement(By.linkText(month));
				action.click(monthelement).build().perform();

				List<WebElement> postList = driver.findElements(
						By.xpath("//*[@id='BlogArchive2_ArchiveList']/ul[" + x + "]/li/ul[" + y + "]/li/ul/li"));

				for (int z = 1; z < postList.size() + 1; z++) {

					WebElement postTitle = driver.findElement(By.xpath("//*[@id='BlogArchive2_ArchiveList']/ul[" + x
							+ "]/li/ul[" + y + "]/li/ul/li[" + z + "]/a"));

					String title = postTitle.getText();

					action.click(postTitle).build().perform();
					
					

					System.out.println(title + " clicked");

				}

			}

		}
		driver.close();
	}
}
