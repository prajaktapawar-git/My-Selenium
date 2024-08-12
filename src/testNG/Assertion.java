package testNG;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion {
	
	@Test
	void testTitle() {


		String exp_result = "OpenCart";
		String act_result = "OpenApp";
		
		/*if(exp_result.equals(act_result))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}*/
		
		Assert.assertEquals(exp_result, act_result);

	}

}
