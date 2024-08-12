package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardvsSoftAssertion {
	
	@Test
	void HardAssertion()
	{
		System.out.println("Testing 1");
		System.out.println("Testing 2");
		
		Assert.assertEquals(1, 2);
		
		System.out.println("Testing 3");
		System.out.println("Testing 4");
	}
	
	@Test
	void SoftAssertion()
	{
		System.out.println("Testing 11");
		System.out.println("Testing 12");
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(1, 2);
		
		System.out.println("Testing 13");
		System.out.println("Testing 14");
		
		sa.assertAll();
		
	}

}
