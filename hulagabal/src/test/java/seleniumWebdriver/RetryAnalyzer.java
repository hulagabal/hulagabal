package seleniumWebdriver;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	private int counter=1;
	static final int RETRY_LIMIT=3;
	
	public boolean retry(ITestResult result) {
		
			while(counter<RETRY_LIMIT){
				counter++;
				return true;
			}	
		return false;
		
		
	}

}
