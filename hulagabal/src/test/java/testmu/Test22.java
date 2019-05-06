package testmu;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Test22 extends BaseClass {
	@Test
	public void Test1() {
		logger=extentReports.startTest("one");
		System.out.println("Test1");
		logger.log(LogStatus.PASS, "PAss");
	}

	@Test
	public void Test2() {
		extentReports.startTest("two");
		System.out.println("Test2");
		logger.log(LogStatus.FAIL, "Fail");
	}

}
