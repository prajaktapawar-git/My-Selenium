package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Annotations1 {

	@BeforeClass //Execute only once before all test methods
	void Login()
	{
		System.out.println("Login");
	}
	
	@Test
	void Search()
	{
		System.out.println("Serach");
	}

	@Test (priority=1)
	void AdvSerach()
	{
		System.out.println("Adv Search");
	}
	
	@AfterClass // Execute only once after all test methods
	void Logout()
	{
		System.out.println("Logout");
	}
}
