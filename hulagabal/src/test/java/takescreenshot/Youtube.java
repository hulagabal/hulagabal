package takescreenshot;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Youtube extends BaseClass {

	private SoftAssert softAssert=new SoftAssert();
	private SoftAssert softAssert1=new SoftAssert();
	
	private static final org.apache.logging.log4j.Logger LOGGER=LogManager.getLogger(Youtube.class.getName());
	
	@Test
	public void Test123() {
		
		driver.get("https://www.techbeamers.com/using-testng-assertions-selenium/");
		
		LOGGER.info("URL launched");
		
		String title=driver.getTitle();
		System.out.println(title);
		softAssert.assertEquals(title, "How to Use TestNG Assertions for Validation in Selenium");
		
		LOGGER.info("Driver title verified");
		softAssert.assertAll();
		
		System.out.println("One");
	}

	@Test
	public void test234() {
		
		softAssert1.assertEquals(false, true,"Test to fail");
		
		
		LOGGER.info("Asserted");
		
		System.out.println("two");
		softAssert1.assertAll();
	}

}
