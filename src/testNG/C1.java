package testNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C1 {
	@Test
	void abc()
	{
		System.out.println("abc from C1");
	}
	
	@BeforeTest
	void bt()
	{
		System.out.println("BeforeTest: bt from C1");
	}
	

}
