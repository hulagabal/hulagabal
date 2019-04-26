package seleniumWebdriver;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.annotations.Test;

import takescreenshot.BaseClass;
import video.VedioOne;
import video.Video;

public class RobotExample extends BaseClass {
	
	@Test
	public void open() throws Exception{
		VedioOne.start();
	
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
		driver.close();
		
		VedioOne.stop();
		
		
		
		
	}
	

}
