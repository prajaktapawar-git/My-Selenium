package testNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C2 {
	@Test
	void pqr()
	{
		System.out.println("pqr from C2");
	}
	
	@AfterTest
	void ct()
	{
		System.out.println("AfterTest:ct from C2");
	}

}
