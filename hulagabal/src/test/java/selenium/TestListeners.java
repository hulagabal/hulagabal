package selenium;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener{
	

	public void onTestStart(ITestResult result) {
		System.out.println("<=====================Test started=====================>");
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("<=====================Test Passed=====================>");
		
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("<=====================Test failed=====================>");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("<=====================Test SKIPPED=====================>");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
		
	}

	public void onStart(ITestContext context) {
		System.out.println("<=====================Test Started=====================>"+context.getName());
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("<=====================Test Finnished=====================>"+context.getName());
		
		
	}

}
