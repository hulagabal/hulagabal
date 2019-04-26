package test;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TestPage {

	WebDriver driver;
	Actions actions;
	JavascriptExecutor js;

	public TestPage(WebDriver driver) {

		actions = new Actions(driver);
		js = (JavascriptExecutor) driver;
	}

	@FindBy(how = How.ID, using = "q")
	private WebElement search1;

	@FindBy(how = How.ID, using = "submit")
	WebElement button;

	@FindBy(xpath = "//input[@id='q']")
	private WebElement search;

	@FindBy(xpath = "//input[@id='submit']")
	private WebElement goButton;

	@FindBy(xpath = "//li[@id='menu_projects']")
	private WebElement projectsLink;

	@FindBy(xpath = "//li[@id='menu_download']")
	private WebElement downloadLink;

	@FindBy(xpath = "//li[@id='menu_documentation']")
	private WebElement documentionLink;

	@FindBy(xpath = "//li[@id='menu_support']")
	private WebElement supportLink;

	@FindBy(xpath = "//li[@id='menu_about']")
	private WebElement aboutLink;

	@FindBy(xpath = "//a")
	List<WebElement> linksInAbout;

	public void clickproject() {
		projectsLink.click();
	}

	public void clickdownloadLink() {
		downloadLink.click();
	}

	public void clickdocument() {
		documentionLink.click();
	}

	public void clicksupportLink() {
		supportLink.click();
	}

	public void clickaboutlink() {
		actions.moveToElement(aboutLink).click().build().perform();
	}

	public void getCurrentURL(WebDriver driver) {
		String currentDomain = (String) js.executeScript("return document.location.href");
		System.out.println(currentDomain);
	}
	
	public void showAllLinkTexts() {
		int size = linksInAbout.size();
		for (int i = 0; i < size; i++) {
			System.out.println(linksInAbout.get(i).getText());
		}
	}

	public void senKeysToSearch() {
		actions.sendKeys(search1, "Actions").build().perform();
		actions.moveToElement(button).sendKeys(Keys.ENTER).build().perform();
	}

	public void refreshPage() {
		js.executeScript("history.go(0)");
	}

	public void getURLs(WebDriver driver) {
		System.out.println(driver.getCurrentUrl());

	}
}
