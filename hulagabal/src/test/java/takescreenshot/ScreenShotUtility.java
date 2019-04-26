package takescreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtility {
	
	WebDriver driver;
	

	public static void takePic(WebDriver driver) {
		

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./Screenshots/screens" + dateStamp() + ".jpg"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("Screenshot taken");

	}
	
	public static String dateStamp(){
		return new SimpleDateFormat("yyyy-MM-dd-HHmmss").format(new Date());
	}
	
}
