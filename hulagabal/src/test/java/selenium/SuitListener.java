package selenium;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuitListener implements ISuiteListener {

	public void onStart(ISuite suite) {
		System.out.println("<==================Suite ended=============>");
		
	}

	public void onFinish(ISuite suite) {
		System.out.println("<==================Suite ended=============>");
		
	}

}
