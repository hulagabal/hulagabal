package takescreenshot;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import test.BrowseFactory;

public class BaseClass {
	
	protected WebDriver driver;
	
	@BeforeMethod
	public void start(){
		driver = BrowseFactory.getDriver();
		
	}

	@AfterMethod
	public void takeScreeShotOnFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			ScreenShotUtility.takePic(driver);
		}
	}

	@AfterMethod(dependsOnMethods={"takeScreeShotOnFailure"})
	public void closeAll(){
		driver.quit();
	}

}
