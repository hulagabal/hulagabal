package seleniumWebdriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.annotations.Test;

import takescreenshot.BaseClass;

public class RobotExample extends BaseClass {
	
	@Test
	public void open() throws AWTException, InterruptedException{
		
	
		driver.navigate().to("https://www.youtube.com/");
		
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		
		
		
	}
	

}
