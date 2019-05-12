package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GoogleTest {

	@Test
	public void launchPage() throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Mitturaj.h\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.google.com/");

		// by using Soft Assert
		SoftAssert softAssert = new SoftAssert();

		softAssert.assertEquals(driver.getTitle(), "Goo");

		System.out.println("##THIS LINE WILL BE EXECUTED##");

		// use assertAll at the end of all the statement
		softAssert.assertAll();
	}

}
