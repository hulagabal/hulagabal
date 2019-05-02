package testmu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class GT {
	WebDriver driver;
	String[] linksTitle;
	Actions actions;
	String linkText;
	@Test
	public void clickLinks() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Mitturaj.h\\Desktop\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.glowtouch.com/");

		List<WebElement> links = driver.findElements(By.xpath("//a"));

		System.out.println(links.size());
		linksTitle=new String[links.size()];

		for (int i = 0; i < links.size(); i++) {
			
			
			linkText = links.get(i).getText();
			
			System.out.println(linkText);
			
			linksTitle[i]=linkText;
			
			

		}
		clickAllLinks();
	}

	private void clickAllLinks() {
		for(int y=0;y<linksTitle.length;y++){
			System.out.println(linksTitle[y]);
		WebElement element = driver.findElement(By.linkText(linksTitle[y]));
		actions = new Actions(driver);
		System.out.println(element.getText());
		actions.click(element).build().perform();
		}
		
	}

}
