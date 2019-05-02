package takescreenshot;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import apachepoi.Poi1;
import test.TestPage;

public class SeleniumHQ extends BaseClass {
	
	private SoftAssert softAssert = new SoftAssert();

	@Test
	public void getScreenshot() {

		driver.navigate().to("https://www.seleniumhq.org/");
		String title = driver.getTitle();
		System.out.println(title);
		softAssert.assertEquals(title, "Selenium - Web Browser ","Verifying title");
		
		TestPage page=new TestPage(driver);

		TestPage test12 = PageFactory.initElements(driver, TestPage.class);

		test12.getCurrentURL(driver);
		test12.clickproject();
		test12.getCurrentURL(driver);
		test12.getURLs(driver);
		test12.clickdownloadLink();
		test12.getCurrentURL(driver);
		test12.getURLs(driver);
		test12.clickdocument();
		test12.getCurrentURL(driver);
		test12.getURLs(driver);
		test12.clicksupportLink();
		test12.getCurrentURL(driver);
		test12.getURLs(driver);
		test12.clickaboutlink();
		test12.getCurrentURL(driver);
		test12.getURLs(driver);
		test12.showAllLinkTexts();
		test12.senKeysToSearch();
		test12.refreshPage();

		test12.getURLs(driver);
		
		softAssert.assertAll();
		System.out.println("page refreshed");

	}
	
	@Test(dataProvider="users",dataProviderClass=Poi1.class)
	public void  datadriven(String uname,String pass){
		System.out.println(uname+" "+pass);
	}
	

}
