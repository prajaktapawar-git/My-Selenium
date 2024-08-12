package testNG;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {

	@Test
	void ass()
	{
		//Assert.assertEquals("xyz", "xyz"); //pass
		//Assert.assertEquals(123, "abc"); //NA
		//Assert.assertEquals(123, 123); //Pass
		
		//Assert.assertNotEquals(12, 123); // Failed
		//Assert.assertNotEquals(123, 123); //Pass
		
		//Assert.assertTrue(true); //pass
		//Assert.assertTrue(false); //fail
		
		//Assert.assertTrue(1==2); //false
		//Assert.assertTrue(1==1); //pass
		
		//Assert.assertFalse(false); //pass
		//Assert.assertFalse(true); //fail
		
		//want to fail my test method
		Assert.fail();
	}
}
