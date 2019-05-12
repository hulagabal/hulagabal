package selenium;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class MyListener implements IAnnotationTransformer {

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		if (testMethod.getName().equals("method3")) {
			annotation.setPriority(0);
			annotation.setDataProviderClass(selenium.MyDataProvider.class);
			annotation.setDataProvider("mydata");

		}

	}

}