package seleniumWebdriver;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.annotations.Test;

import takescreenshot.BaseClass;
import video.VedioOne;

public class RobotExample extends BaseClass {
	
	@Test
	public void open() throws Exception{
		//Start recorder
		VedioOne.start("open");
	
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
		
		
		//Stop recorder
		VedioOne.stop();
		
		
		
		
	}
	

}
