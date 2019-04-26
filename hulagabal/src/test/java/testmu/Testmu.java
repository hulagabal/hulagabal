package testmu;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Testmu {
	@Test
	public void add1() {
		
		Assert.assertEquals(true, false);
		
		System.out.println("Add");
	}

	@Test
	public void add() {
		System.out.println("Add1");
	}
}
